package com.example.bookingtravel.adapters.rvadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;

public class RvBookingTripCountPeopleAdapter extends RecyclerView.Adapter<RvBookingTripCountPeopleAdapter.BookingTripCountPeopleHolder> {


    @NonNull
    @Override
    public BookingTripCountPeopleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking_trip_count_people,parent,false);
        return new BookingTripCountPeopleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingTripCountPeopleHolder holder, int position) {
        holder.tvCountPeople.setText(position+1+"");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class BookingTripCountPeopleHolder extends RecyclerView.ViewHolder {

        TextView tvCountPeople ;

        public BookingTripCountPeopleHolder(@NonNull View itemView) {
            super(itemView);

            tvCountPeople = itemView.findViewById(R.id.tv_booking_trip_count_people);

        }
    }
}
