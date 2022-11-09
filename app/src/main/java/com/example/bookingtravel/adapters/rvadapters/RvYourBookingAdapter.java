package com.example.bookingtravel.adapters.rvadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;

public class RvYourBookingAdapter extends RecyclerView.Adapter<RvYourBookingAdapter.RvHomeVH> {

    @NonNull
    @Override
    public RvHomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_your_booking,parent,false);
        return new RvHomeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHomeVH holder, int position) {

        holder.imageView.setImageAlpha(R.drawable.dumy_imge_yb);
        holder.fromDate.setText("09 july");
        holder.toDate.setText("12 july");
        holder.nameCountry.setText("Netherlands");
        holder.nameCity.setText("Amsterdam");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class RvHomeVH extends RecyclerView.ViewHolder {
        ImageView imageView ;
        TextView nameCity ;
        TextView nameCountry ;
        TextView fromDate ;
        TextView toDate ;

        public RvHomeVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_your_booking);
            nameCity = itemView.findViewById(R.id.tv_name_city_your_booking);
            nameCountry = itemView.findViewById(R.id.tv_name_country_your_booking);
            fromDate = itemView.findViewById(R.id.from_date_your_booking);
            toDate = itemView.findViewById(R.id.to_date_your_booking);
        }
    }
}
