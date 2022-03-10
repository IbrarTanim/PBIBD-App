package com.pbilbd.cache.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.pbilbd.cache.PaymentMethodEntity;

import java.util.List;

@Dao
public interface PaymentMethodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPaymentMethod(PaymentMethodEntity entity);

    @Query("SELECT * FROM payment_method_entity")
    List<PaymentMethodEntity> getAllPaymentMethod();

    @Query("DELETE FROM payment_method_entity")
    void deleteAllPaymentMethod();

}
