package com.pbilbd.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.textview.MaterialTextView;
import com.pbilbd.R;
import com.pbilbd.cache.PaymentMethodEntity;
import com.pbilbd.constants.BaseConstants;
import com.pbilbd.utils.RecyclerClickItem;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodsAdapter extends RecyclerView.Adapter<PaymentMethodsAdapter.MethodViewHolder>{

    private Context context;
    private int selectedPosition = -1;
    private List<PaymentMethodEntity> methodEntities = new ArrayList<>();
    private RecyclerClickItem clickItem;

    public PaymentMethodsAdapter(Context context, List<PaymentMethodEntity> methodEntities, RecyclerClickItem clickItem) {
        this.context = context;
        this.methodEntities = methodEntities;
        this.clickItem = clickItem;
    }

    @NonNull
    @Override
    public MethodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_transaction_mehtod, parent, false);
        return new MethodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MethodViewHolder holder, int position) {
        if (methodEntities != null){
            if (selectedPosition == position){
                holder.btnSelectedMethod.setChecked(true);
            }else {
                holder.btnSelectedMethod.setChecked(false);
            }

            holder.tvMethodName.setText(methodEntities.get(position).getMethodName());
            holder.tvMethodAccount.setText(methodEntities.get(position).getMethodAccount());

            String methodLogoURL = BaseConstants.DEV_IMAGE_FETCH_URL + methodEntities.get(position).getMethodLogo();
            Glide.with(context)
                    .load(methodLogoURL)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .thumbnail(0.5f)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(holder.methodIV);
        }
    }

    @Override
    public int getItemCount() {
        return methodEntities.size();
    }

    class MethodViewHolder extends RecyclerView.ViewHolder{

        private RadioButton btnSelectedMethod;
        private AppCompatImageView methodIV;
        private MaterialTextView tvMethodName;
        private MaterialTextView tvMethodAccount;

        public MethodViewHolder(@NonNull View itemView) {
            super(itemView);
            btnSelectedMethod = itemView.findViewById(R.id.btn_radio_payment_method);
            methodIV = itemView.findViewById(R.id.iv_payment_method);
            tvMethodName = itemView.findViewById(R.id.tv_payment_method_name);
            tvMethodAccount = itemView.findViewById(R.id.tv_payment_method_account_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickItem.onItemClick(view, getAbsoluteAdapterPosition());
                }
            });
        }
    }

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }
}
