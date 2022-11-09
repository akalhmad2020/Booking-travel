package com.example.bookingtravel.adapters.rvadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;

public class RvTopVisitAdapter extends RecyclerView.Adapter<RvTopVisitAdapter.RvHomeVH> {


    @NonNull
    @Override
    public RvHomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_visit,parent,false);
        return new RvHomeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHomeVH holder, int position) {

        holder.imageView.setImageAlpha(R.drawable.japan);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class RvHomeVH extends RecyclerView.ViewHolder {
        ImageView imageView ;

        public RvHomeVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_iv_top_visit);

        }
    }
}
