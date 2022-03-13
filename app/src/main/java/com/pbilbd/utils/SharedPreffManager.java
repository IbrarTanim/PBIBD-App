package com.pbilbd.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import com.pbilbd.constants.BaseConstants;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SharedPreffManager {

    private Context context;
    private String MASTER_KEYS;
    private SharedPreferences sharedPreferences;

    public SharedPreffManager(Context context) {
        this.context = context;
        try {
            MASTER_KEYS = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC);
            sharedPreferences = EncryptedSharedPreferences.create(
                    "pbi_cache_preff",
                    MASTER_KEYS,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException e) {
            //e.printStackTrace();
        } catch (IOException ioException) {
            //ioException.printStackTrace();
        }
    }

    public void saveString(String key, String value){
        if (sharedPreferences != null){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.apply();
        }
    }

    public String getString(String key){
        if (sharedPreferences != null){
            return sharedPreferences.getString(key, BaseConstants.PREFF_ERROR);
        }
        return BaseConstants.PREFF_ERROR;
    }

    public void clearAll(){
        if (sharedPreferences != null){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
        }
    }
}
