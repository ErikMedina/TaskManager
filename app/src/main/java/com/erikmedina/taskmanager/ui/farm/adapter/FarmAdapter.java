package com.erikmedina.taskmanager.ui.farm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erikmedina.taskmanager.R;
import com.erikmedina.taskmanager.domain.entity.Farm;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by erik on 20/12/16.
 */

public class FarmAdapter extends RecyclerView.Adapter<FarmAdapter.ViewHolder> {

    private List<Farm> farms;
    private Context context;

    public FarmAdapter(Context context) {
        this.context = context;
        farms = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farm, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvFarmId.setText(farms.get(position).getFarmer_id());
        holder.tvFarmName.setText(farms.get(position).getFarm_name());
        holder.tvFarmZipCode.setText(farms.get(position).getZipcode());
        holder.tvFarmPhone.setText(farms.get(position).getPhone1());
    }

    @Override
    public int getItemCount() {
        return farms.size();
    }

    public void setFarms(List<Farm> farms) {
        this.farms = farms;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_farm_id)
        TextView tvFarmId;
        @BindView(R.id.tv_farm_name)
        TextView tvFarmName;
        @BindView(R.id.tv_farm_zip_code)
        TextView tvFarmZipCode;
        @BindView(R.id.tv_farm_phone)
        TextView tvFarmPhone;

        Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;
        }
    }
}
