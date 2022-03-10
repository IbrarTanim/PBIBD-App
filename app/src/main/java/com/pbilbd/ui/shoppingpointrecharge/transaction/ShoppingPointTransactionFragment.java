package com.pbilbd.ui.shoppingpointrecharge.transaction;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pbilbd.adapters.ShoppingPointTransactionAdapter;
import com.pbilbd.cache.PBIRoomDatabase;
import com.pbilbd.cache.PaymentMethodEntity;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.databinding.ShoppingPointTransactionFragmentBinding;
import com.pbilbd.dto.responses.shoppingpointtransactions.Datum;
import com.pbilbd.dto.responses.shoppingpointtransactions.PaymentMethod;
import com.pbilbd.dto.responses.shoppingpointtransactions.ShoppingPointTransactionsResponse;
import com.pbilbd.utils.ProgressDialog;

import java.util.Calendar;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class ShoppingPointTransactionFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private Context context;
    private ShoppingPointTransactionFragmentBinding binding;
    private ShoppingPointTransactionViewModel mViewModel;
    private String startDate = "";
    private String endDate = "";
    private com.pbilbd.utils.DatePicker datePicker;
    private int CLICKED_DATE_VIEW_ID = 0; //Start date = 101 ; End date = 102 ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ShoppingPointTransactionFragmentBinding.inflate(inflater, container, false);
        mViewModel =
                new ViewModelProvider(this).get(ShoppingPointTransactionViewModel.class);
        datePicker =
                new com.pbilbd.utils.DatePicker(context);
        //Get All Transactions
        getAllTransaction();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        //Date layouts handle
        binding.btnStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLICKED_DATE_VIEW_ID = 101;
                datePicker.show(getChildFragmentManager(), "Pick Start Date");
            }
        });
        binding.btnEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLICKED_DATE_VIEW_ID = 102;
                datePicker.show(getChildFragmentManager(), "Pick End Date");
            }
        });
        binding.filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDate = binding.tvStartDate.getText().toString();
                endDate = binding.tvEndDate.getText().toString();
                getAllTransaction();
            }
        });
        binding.resetFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvStartDate.setText("");
                binding.tvEndDate.setText("");
                startDate = "";
                endDate = "";
                getAllTransaction();
            }
        });
    }

    private void getAllTransaction() {

        ProgressDialog.show(context);

        mViewModel.getTransactions(context, startDate, endDate);

        mViewModel.getProductPagedList().observe(getViewLifecycleOwner(), new Observer<PagedList<Datum>>() {
            @Override
            public void onChanged(PagedList<Datum> data) {
                if (data != null) {
                    ShoppingPointTransactionAdapter adapter = new ShoppingPointTransactionAdapter();
                    adapter.submitList(data);
                    LinearLayoutManager manager = new LinearLayoutManager(context);
                    binding.rvAllTransaction.setLayoutManager(manager);
                    binding.rvAllTransaction.setAdapter(adapter);
                }
                mViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        if (integer == 200) {
                            ProgressDialog.cancel();
                            mViewModel.getAllTransactionsResponseLive().observe(getViewLifecycleOwner(), new Observer<ShoppingPointTransactionsResponse>() {
                                @Override
                                public void onChanged(ShoppingPointTransactionsResponse shoppingPointTransactionsResponse) {
                                    if (shoppingPointTransactionsResponse != null) {
                                        if (shoppingPointTransactionsResponse.getData().getPaymentMethods() != null) {
                                            PBIRoomDatabase database = PBIRoomDatabase.getInstance(context);
                                            List<PaymentMethod> methods = shoppingPointTransactionsResponse.getData().getPaymentMethods();
                                            for (PaymentMethod method : methods) {
                                                PaymentMethodEntity entity = new PaymentMethodEntity(method.getId(), method.getName(), method.getLogo(), method.getAccount(), method.getType());
                                                database.paymentMethodDao().insertPaymentMethod(entity);
                                            }
                                        }
                                        if (shoppingPointTransactionsResponse.getData().getShoppingWallet() != null) {
                                            binding.tvCrntShoppingBalance.setText(shoppingPointTransactionsResponse.getData().getShoppingWallet());
                                        }
                                        if (shoppingPointTransactionsResponse.getData().getTotal() != null) {
                                            binding.tvTotalTransaction.setText(shoppingPointTransactionsResponse.getData().getTotal());
                                        }
                                        if (shoppingPointTransactionsResponse.getData().getRecords().getData() != null && !shoppingPointTransactionsResponse.getData().getRecords().getData().isEmpty()) {
                                            binding.tvNoRecords.setVisibility(View.GONE);
                                        } else {
                                            binding.tvNoRecords.setVisibility(View.VISIBLE);
                                        }
                                    }
                                }
                            });
                        } else if (integer == 401) {
                            ProgressDialog.cancel();
                            Toasty.warning(context, BaseConstants.ERROR_UNAUTHORIZED).show();
                        } else if (integer == BaseConstants.UNKNOWN_ERROR) {
                            ProgressDialog.cancel();
                            Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                        } else if (integer == BaseConstants.FAILURE_ERROR) {
                            ProgressDialog.cancel();
                            Toasty.warning(context, BaseConstants.ERROR_FAILURE).show();
                        } else {
                            ProgressDialog.cancel();
                            Toasty.warning(context, BaseConstants.ERROR_UNKNOWN).show();
                        }
                    }
                });

            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, i);
        mCalendar.set(Calendar.MONTH, i1);
        mCalendar.set(Calendar.DAY_OF_MONTH, i2);
        //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        int mm = i1 + 1;
        String selectedDate;
        String month;
        String day;
        if (mm < 10) {

            month = "0" + mm;

        } else {

            month = String.valueOf(mm);

        }

        if (i2 < 10) {

            day = "0" + i2;

        } else {

            day = String.valueOf(i2);

        }


        selectedDate = i + "/" + month + "/" + day;

        if (CLICKED_DATE_VIEW_ID == 101) {

            binding.tvStartDate.setText(selectedDate);

        } else if (CLICKED_DATE_VIEW_ID == 102) {

            binding.tvEndDate.setText(selectedDate);

        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}