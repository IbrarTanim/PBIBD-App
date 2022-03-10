package com.pbilbd.cache;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pbilbd.cache.daos.PaymentMethodDao;

@Database(entities = {PaymentMethodEntity.class,}, version = 2, exportSchema = false)
public abstract class PBIRoomDatabase extends RoomDatabase {

    private static volatile PBIRoomDatabase instance;

    public static PBIRoomDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (PBIRoomDatabase.class) {
                if (instance == null) {
                    instance = Room
                            .databaseBuilder(context.getApplicationContext(), PBIRoomDatabase.class, "pbi_cache")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

    public abstract PaymentMethodDao paymentMethodDao();

}

/**
 * Version 1 includes - PaymentMethodEntity,
 * Version 2 includes - PaymentMethodEntity improvement
 */
