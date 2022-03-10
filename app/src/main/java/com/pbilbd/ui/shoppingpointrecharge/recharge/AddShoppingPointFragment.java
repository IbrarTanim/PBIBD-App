package com.pbilbd.ui.shoppingpointrecharge.recharge;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pbilbd.adapters.PaymentMethodsAdapter;
import com.pbilbd.cache.PaymentMethodEntity;
import com.pbilbd.databinding.AddShoppingPointFragmentBinding;
import com.pbilbd.utils.RecyclerClickItem;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class AddShoppingPointFragment extends Fragment {

    private AddShoppingPointViewModel mViewModel;
    private AddShoppingPointFragmentBinding binding;
    private Context context;
    private int selectedPaymentMethodID = -1;
    private PaymentMethodsAdapter adapter;

    private ActivityResultLauncher<String[]> commonResultLauncher;
    private ActivityResultLauncher<Intent> galleryResultLauncher;

    private Bitmap photo;
    private FileOutputStream fileOutputStream;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AddShoppingPointFragmentBinding.inflate(inflater, container, false);
        mViewModel =
                new ViewModelProvider(this).get(AddShoppingPointViewModel.class);
        mViewModel.initViewModel(context);
        mViewModel.getAllPaymentMethods().observe(getViewLifecycleOwner(), new Observer<List<PaymentMethodEntity>>() {
            @Override
            public void onChanged(List<PaymentMethodEntity> paymentMethodEntities) {
                if (paymentMethodEntities != null){
                    adapter = new PaymentMethodsAdapter(context, paymentMethodEntities, new RecyclerClickItem() {
                        @Override
                        public void onItemClick(View view, int position) {
                            selectedPaymentMethodID = paymentMethodEntities.get(position).getMethodId();
                            adapter.setSelectedPosition(position);
                        }
                    });
                    LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                    binding.rvPaymentMethod.setLayoutManager(manager);
                    binding.rvPaymentMethod.setAdapter(adapter);
                }
            }
        });

        commonResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
            @Override
            public void onActivityResult(Map<String, Boolean> result) {
            }
        });

        galleryResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Uri photoUri = result.getData().getData();
                    uriToBitmap(photoUri);
                    savePhotoInInternal();
                }
            }
        });

        initialize();

        return binding.getRoot();
    }

    private void initialize() {

        binding.btnChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

    }


    private void openGallery() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_MEDIA_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                String[] trackerPerms = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_MEDIA_LOCATION, Manifest.permission.CAMERA};
                commonResultLauncher.launch(trackerPerms);
            } else {
                String[] trackerPerms = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
                commonResultLauncher.launch(trackerPerms);
            }
        } else {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            galleryResultLauncher.launch(intent);
        }
    }

    private void savePhotoInInternal() {

        if (photo != null) {
            File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(folder, "PBI_" + System.currentTimeMillis() + ".jpg");

            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                //e.printStackTrace();
            }
            try {
                photo.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            } catch (NullPointerException ne) {

            }
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String filePath = file.getPath();

            if (filePath != null){
                binding.tvFileName.setText(filePath);
            }

        } else {
            Toasty.warning(context, "Provide picture..", Toasty.LENGTH_LONG, true).show();
        }
    }

    private void uriToBitmap(Uri selectedFileUri) {
        try {
            ParcelFileDescriptor parcelFileDescriptor =
                    context.getContentResolver().openFileDescriptor(selectedFileUri, "r");
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
            setPhoto(image);
            parcelFileDescriptor.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}