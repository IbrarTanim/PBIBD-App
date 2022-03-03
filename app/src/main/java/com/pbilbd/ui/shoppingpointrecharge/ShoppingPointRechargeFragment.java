package com.pbilbd.ui.shoppingpointrecharge;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayoutMediator;
import com.pbilbd.adapters.ViewPagerAdapter;
import com.pbilbd.databinding.ShoppingPointRechargeFragmentBinding;

public class ShoppingPointRechargeFragment extends Fragment {

    private ShoppingPointRechargeViewModel mViewModel;
    private Context context;
    private ShoppingPointRechargeFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ShoppingPointRechargeFragmentBinding.inflate(inflater, container, false);



        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            String titles[] = new String[]{"Recharge", "Transaction"};
            tab.setText(titles[position]);
            binding.viewPager.setCurrentItem(position);
        }).attach();

        binding.viewPager.setCurrentItem(0);

        return binding.getRoot();
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