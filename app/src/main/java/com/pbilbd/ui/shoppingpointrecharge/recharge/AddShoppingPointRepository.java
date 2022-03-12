package com.pbilbd.ui.shoppingpointrecharge.recharge;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.pbilbd.cache.PBIRoomDatabase;
import com.pbilbd.cache.PaymentMethodEntity;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.network.NetworkClient;
import com.pbilbd.network.NetworkInterface;
import com.pbilbd.utils.SharedPreffManager;

import org.json.JSONObject;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddShoppingPointRepository {

    private Context context;
    private MutableLiveData<List<PaymentMethodEntity>> methodsLiveData;
    private SharedPreffManager preffManager;
    private MutableLiveData<Integer> errorLiveData;
    private MutableLiveData<String> responseLiveData;
    private NetworkInterface networkInterface;

    public AddShoppingPointRepository(Context context) {
        this.context = context;
        methodsLiveData = new MutableLiveData<>();
        getPaymentMethods(context);
        preffManager = new SharedPreffManager(context);
        errorLiveData = new MutableLiveData<>();
        responseLiveData = new MutableLiveData<>();
        networkInterface = NetworkClient.getNetworkService();
    }

    private void getPaymentMethods(Context context) {
        PBIRoomDatabase database = PBIRoomDatabase.getInstance(context);
        List<PaymentMethodEntity> allMethods = database.paymentMethodDao().getAllPaymentMethod();
        methodsLiveData.postValue(allMethods);
    }

    public MutableLiveData<List<PaymentMethodEntity>> getMethodsLiveData() {
        return methodsLiveData;
    }

    //save shopping point
    public void saveShoppingPoint(int paymentMethodId,
                                   String sentFrom,
                                   String trxId,
                                   String amount,
                                   String fileName){

        String accessToken = "Bearer " + preffManager.getString(BaseConstants.ACCESS_TOKEN);

        Call<JSONObject> pojoCall;
        if (fileName != null){
            File newFile = new File(fileName);
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), newFile);
            MultipartBody.Part multipartBody = MultipartBody.Part.createFormData("attachment", newFile.getName(), requestBody);
            pojoCall = networkInterface.saveShoppingPoint(accessToken, paymentMethodId, sentFrom, trxId, amount, multipartBody);
        }else {
            pojoCall = networkInterface.saveShoppingPoint(accessToken, paymentMethodId, sentFrom, trxId, amount);
        }

        if (pojoCall != null){
            pojoCall.enqueue(new Callback<JSONObject>() {
                @Override
                public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                    if (response.code() == 200){
                        errorLiveData.postValue(200);
                        responseLiveData.postValue("Your request has been sent successfully!");
                        /*JSONObject jsonObject = response.body();
                        try {
                            String message = jsonObject.get("data").toString();
                            responseLiveData.postValue(message);
                        } catch (JSONException e) {
                            responseLiveData.postValue(e.getMessage());
                            Log.e("Error 2", e.getMessage());
                        }*/
                    }else if (response.code() == 401){
                        errorLiveData.postValue(401);
                    }else if(response.code() == 422){
                        errorLiveData.postValue(422);
                    }else {
                        errorLiveData.postValue(BaseConstants.UNKNOWN_ERROR);
                    }
                }

                @Override
                public void onFailure(Call<JSONObject> call, Throwable t) {
                    errorLiveData.postValue(BaseConstants.FAILURE_ERROR);
                }
            });
        }
    }

    public MutableLiveData<Integer> getErrorLiveData() {
        return errorLiveData;
    }

    public MutableLiveData<String> getResponseLiveData() {
        return responseLiveData;
    }
}
