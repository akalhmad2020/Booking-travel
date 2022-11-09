package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;
import com.example.bookingtravel.pojo.pojotosubfragments.TrendPojo;

import java.util.List;

public class RvTrendAdapter extends RecyclerView.Adapter<RvTrendAdapter.RvHomeVH> {

    List<TrendPojo> list ;
    Context context ;

    public RvTrendAdapter(List<TrendPojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RvHomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trend,parent,false);
        return new RvHomeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHomeVH holder, int position) {

        TrendPojo trendPojo = list.get(position);

        holder.imageCity.setImageAlpha(trendPojo.getImageId());
        holder.nameCity.setText(trendPojo.getName());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RvHomeVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageCity ;
        TextView nameCity ;

        public RvHomeVH(@NonNull View itemView) {
            super(itemView);
            imageCity = itemView.findViewById(R.id.city_iv_trend);
            nameCity = itemView.findViewById(R.id.city_tv_name_trend);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = (int) itemView.getTag();

        }
    }
}
