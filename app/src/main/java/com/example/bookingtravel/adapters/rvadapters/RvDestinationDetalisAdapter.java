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

import com.bumptech.glide.Glide;
import com.example.bookingtravel.R;
import com.example.bookingtravel.pojo.PojoDestinationDetails;
import com.example.bookingtravel.pojo.pojofornetwork.CityActivity;
import com.example.bookingtravel.pojo.pojotosubfragments.PojoPlacesAndActivities;
import com.example.bookingtravel.ui.main.PlaceTripDetails;

import java.util.ArrayList;
import java.util.List;

public class RvDestinationDetalisAdapter extends RecyclerView.Adapter<RvDestinationDetalisAdapter.MyDDHolder> {

    private Context context ;
    private List<CityActivity> cityActivityList ;

    private  String cityName ;
    private  String countryName ;


    public RvDestinationDetalisAdapter(Context context, List<CityActivity> cityActivityList, String cityName, String countryName) {
        this.context = context;
        this.cityActivityList = cityActivityList;
        this.cityName = cityName;
        this.countryName = countryName;

    }

    @NonNull
    @Override
    public MyDDHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fdd,parent,false);
        return new MyDDHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDDHolder holder, int position) {

        CityActivity cityActivity = cityActivityList.get(position);

        holder.nameCity.setText(cityName);
        holder.nameCountry.setText(countryName);
        holder.namePlace.setText(cityActivity.getNameItem());
        if(cityActivity.getImageItem() != null){
            Glide.with(context).load(cityActivity.getImageItem()).into(holder.imageView);
        }


        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
          if(cityActivityList.size() != 0)
            return  cityActivityList.size();


          return 0 ;
    }

    public class MyDDHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView ;
        TextView nameCity ;
        TextView namePlace ;
        TextView nameCountry ;

        public MyDDHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_iv_fdd);
            nameCity = itemView.findViewById(R.id.tv_name_city_fdd);
            nameCountry = itemView.findViewById(R.id.tv_name_country_fdd);
            namePlace = itemView.findViewById(R.id.tv_name_place_Fdd);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = (int) itemView.getTag();
            Intent intent = new Intent(context, PlaceTripDetails.class);
            intent.putExtra("positionRvDDA",position);
            context.startActivity(intent);
        }
    }

    public  void  addCitiesActivitiesList(List<CityActivity> cityActivities){
        cityActivityList = cityActivities ;
        notifyDataSetChanged();
    }


}
