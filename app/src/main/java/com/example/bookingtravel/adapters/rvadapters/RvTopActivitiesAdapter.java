package com.example.bookingtravel.adapters.rvadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;

public class RvTopActivitiesAdapter extends RecyclerView.Adapter<RvTopActivitiesAdapter.TopActivitiesHOlder> {


    @NonNull
    @Override
    public TopActivitiesHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_top_activities,parent,false);
        return new TopActivitiesHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopActivitiesHOlder holder, int position) {
        holder.textView.setText("test");
        holder.imageView.setImageAlpha(R.drawable.mountains_icon);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class TopActivitiesHOlder extends RecyclerView.ViewHolder {
        ImageView imageView ;
        TextView textView ;

        public TopActivitiesHOlder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_iv_top_activities);
            textView = itemView.findViewById(R.id.item_tv_top_activities);
        }
    }
}
