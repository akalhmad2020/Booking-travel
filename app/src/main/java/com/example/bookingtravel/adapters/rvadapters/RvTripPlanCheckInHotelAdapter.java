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

public class RvTripPlanCheckInHotelAdapter extends RecyclerView.Adapter<RvTripPlanCheckInHotelAdapter.TripPlanCheckInHotelHolder> {

      private Context context ;

    public RvTripPlanCheckInHotelAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TripPlanCheckInHotelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip_plan_check_in_hotel,parent,false);
        return new TripPlanCheckInHotelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripPlanCheckInHotelHolder holder, int position) {
        holder.textView.setText("Go to the beach");

    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public class TripPlanCheckInHotelHolder extends RecyclerView.ViewHolder   {

        ImageView imageView ;
        TextView textView ;

        public TripPlanCheckInHotelHolder(@NonNull View itemView) {
            super(itemView);


            textView = itemView.findViewById(R.id.tv_check_in_hotel);
            imageView = itemView.findViewById(R.id.iv_check_in_hotel);

        }

    }
}
