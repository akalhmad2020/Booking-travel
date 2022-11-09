package com.example.bookingtravel.adapters.rvadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;

public class RvCompleteBookingAdapter extends RecyclerView.Adapter<RvCompleteBookingAdapter.CompleteBookingHolder> {



    @NonNull
    @Override
    public CompleteBookingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_complete_booking,parent,false);
        return new CompleteBookingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteBookingHolder holder, int position) {
        holder.tvNumberTrip.setText("100035");
        holder.tvPriceTrip.setText("$1700");
        holder.tvTypeTrip.setText("Personal");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class CompleteBookingHolder extends RecyclerView.ViewHolder {

        TextView tvTypeTrip ;
        TextView tvNumberTrip ;
        TextView tvPriceTrip ;

        public CompleteBookingHolder(@NonNull View itemView) {
            super(itemView);

            tvNumberTrip = itemView.findViewById(R.id.tv_number_trip);
            tvPriceTrip = itemView.findViewById(R.id.tv_price_trip);
            tvTypeTrip = itemView.findViewById(R.id.tv_type_trip);

        }
    }
}
