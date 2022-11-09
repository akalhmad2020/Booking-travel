package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;
import com.example.bookingtravel.fragments.subfragments.FeaturedFragment;
import com.example.bookingtravel.ui.main.PlaceTripDetails;

public class RvFeaturedAdapter extends RecyclerView.Adapter<RvFeaturedAdapter.RvHomeVH> {

    private Context context ;

    public RvFeaturedAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RvHomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_featured,parent,false);
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
            imageView = itemView.findViewById(R.id.item_iv_featured);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  //  v.getContext().startActivity(context, PlaceTripDetails.class);

                }
            });
        }
    }
}
