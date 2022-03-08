package com.pbilbd.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.pbilbd.R;
import com.pbilbd.dto.responses.shoppingpointtransactions.Datum;

public class ShoppingPointTransactionAdapter extends PagedListAdapter<Datum, ShoppingPointTransactionAdapter.TransactionViewHolder> {

    private static DiffUtil.ItemCallback<Datum> DIFF_CALLBACK = new DiffUtil.ItemCallback<Datum>() {
        @Override
        public boolean areItemsTheSame(@NonNull Datum oldItem, @NonNull Datum newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Datum oldItem, @NonNull Datum newItem) {
            return true;
        }
    };

    public ShoppingPointTransactionAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shopping_point_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {

        Datum datum = getItem(position);

        if (datum != null){

            holder.rowTvPaymentMethod.setText(datum.getPaymentMethod().getName());
            holder.rowTvSentFrom.setText(datum.getSentFrom());
            holder.rowTvTrxId.setText(datum.getTrxid());
            holder.rowTvAmount.setText(datum.getAmount());
            holder.rowTvDate.setText(datum.getCreatedAt());
            holder.rowTvAction.setText(String.valueOf(datum.getStatus()));

        }

    }

    class TransactionViewHolder extends RecyclerView.ViewHolder{

        MaterialTextView rowTvPaymentMethod, rowTvSentFrom, rowTvTrxId, rowTvAmount, rowTvDate, rowTvAction;
        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);

            rowTvPaymentMethod = itemView.findViewById(R.id.row_tv_payment_method);
            rowTvSentFrom = itemView.findViewById(R.id.row_tv_sent_from);
            rowTvTrxId = itemView.findViewById(R.id.row_tv_trx_id);
            rowTvAmount = itemView.findViewById(R.id.row_tv_amount);
            rowTvDate = itemView.findViewById(R.id.row_tv_date);
            rowTvAction = itemView.findViewById(R.id.row_tv_action);

        }
    }
}
