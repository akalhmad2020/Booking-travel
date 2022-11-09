package com.example.bookingtravel.adapters.rvadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;

public class RvBookingTripSelectTransportationAdapter extends RecyclerView.Adapter<RvBookingTripSelectTransportationAdapter.BookingTripTransportationHolder> {


    @NonNull
    @Override
    public BookingTripTransportationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking_trip_select_transportation,parent,false);
        return new BookingTripTransportationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingTripTransportationHolder holder, int position) {
        holder.tvNameTransportation.setText("Car");
    }

    @Override
    public int getItemCount() {
        return 4 ;
    }

    public class BookingTripTransportationHolder extends RecyclerView.ViewHolder {

        TextView tvNameTransportation ;

        public BookingTripTransportationHolder(@NonNull View itemView) {
            super(itemView);

            tvNameTransportation = itemView.findViewById(R.id.tv_booking_transportation);

        }
    }
}
