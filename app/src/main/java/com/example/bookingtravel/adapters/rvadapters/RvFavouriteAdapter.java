package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookingtravel.R;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;

import java.util.ArrayList;

public class RvFavouriteAdapter extends RecyclerView.Adapter<RvFavouriteAdapter.FavouriteHolder> {

    ArrayList<Activity> list ;

    Context context ;
    public RvFavouriteAdapter(ArrayList<Activity> list , Context context) {
        this.list = list;
        this.context = context ;
    }

    @NonNull
    @Override
    public FavouriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favourite,parent,false);
        return new FavouriteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteHolder holder, int position) {


        if(list.get(position).getActivityUrl() != null){
            Glide.with(context).load(list.get(position).getActivityUrl()).into(holder.imageView);
        }

        holder.countDes.setText(1+","+2+"k");
        holder.nameCountry.setText("Stockholm, Sweden");
        holder.nameCity.setText(list.get(position).getNameActivity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FavouriteHolder extends RecyclerView.ViewHolder {
        ImageView imageView ;
        TextView nameCity ;
        TextView nameCountry ;
        TextView countDes ;

        public FavouriteHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_favourite);
            nameCity = itemView.findViewById(R.id.name_city_favourite);
            nameCountry = itemView.findViewById(R.id.name_country_favourite);
            countDes = itemView.findViewById(R.id.tv_count_destination_favourite);
        }
    }
}
