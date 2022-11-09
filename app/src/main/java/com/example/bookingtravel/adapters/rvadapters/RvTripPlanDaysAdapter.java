package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;

public class RvTripPlanDaysAdapter extends RecyclerView.Adapter<RvTripPlanDaysAdapter.TripPlanDaysHolder> {

      private Context context ;

    public RvTripPlanDaysAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TripPlanDaysHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trip_plan_days,parent,false);
        return new TripPlanDaysHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TripPlanDaysHolder holder, int position) {
        holder.tripPlanDays.setText("09 July");
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return 7;
    }


    public class TripPlanDaysHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tripPlanDays ;

        public TripPlanDaysHolder(@NonNull View itemView) {
            super(itemView);

            tripPlanDays = itemView.findViewById(R.id.tv_trip_plan_days);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
             int position = (int) itemView.getTag();
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }
    }
}
