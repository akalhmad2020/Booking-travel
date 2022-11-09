package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;
import com.example.bookingtravel.ui.main.ViewRoom;

public class RvBookingTripRoomAdapter extends RecyclerView.Adapter<RvBookingTripRoomAdapter.BookingTripRoomHolder> {


    private Context context ;

    public RvBookingTripRoomAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BookingTripRoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_booking_trip_room,parent,false);
        return new BookingTripRoomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingTripRoomHolder holder, int position) {
        holder.room.setImageAlpha(R.drawable.room);
        holder.tvCountDays.setText( "/2 days");
        holder.tvMoney.setText("$"+122);
        holder.tvKindRoom.setText("Deluxe");
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class BookingTripRoomHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView room ;
        TextView tvKindRoom ;
        TextView tvMoney ;
        TextView tvCountDays ;


        public BookingTripRoomHolder(@NonNull View itemView) {
            super(itemView);

            room = itemView.findViewById(R.id.iv_booking_trip_room);
            tvKindRoom = itemView.findViewById(R.id.tv_booking_trip_kind_room);
            tvMoney = itemView.findViewById(R.id.tv_booking_trip_room_money);
            tvCountDays = itemView.findViewById(R.id.tv_booking_trip_room_count_days);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            context.startActivity(new Intent(context, ViewRoom.class));

        }
    }
}
