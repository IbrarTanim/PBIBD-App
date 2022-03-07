package com.pbilbd.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.pbilbd.ui.shoppingpointrecharge.recharge.AddShoppingPointFragment;
import com.pbilbd.ui.shoppingpointrecharge.transaction.ShoppingPointTransactionFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new ShoppingPointTransactionFragment();
        } else {
            return new AddShoppingPointFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
