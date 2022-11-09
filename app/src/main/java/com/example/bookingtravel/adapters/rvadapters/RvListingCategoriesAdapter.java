
    package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookingtravel.R;
import com.example.bookingtravel.interfaces.listener.SendPositionFromRvLCatToFLCat;
import com.example.bookingtravel.pojo.PojoListingCategories;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;
import com.example.bookingtravel.pojo.pojofornetwork.City;
import com.example.bookingtravel.pojo.pojofornetwork.CityActivity;
import com.example.bookingtravel.pojo.pojofornetwork.Country;

import java.util.ArrayList;
import java.util.List;

    public class RvListingCategoriesAdapter extends RecyclerView.Adapter<com.example.bookingtravel.adapters.rvadapters.RvListingCategoriesAdapter.RvHomeVH> {

        private Context context ;
        private SendPositionFromRvLCatToFLCat sendPosition ;
        private ArrayList<Country> countriesList ;
        private ArrayList<City> citiesList ;
        private ArrayList<CityActivity> citiesActivitiesList ;
        private   ArrayList<Activity> activitiesList ;
        public RvListingCategoriesAdapter(Context context, SendPositionFromRvLCatToFLCat sendPosition
        ) {
            this.context = context;
            this.sendPosition = sendPosition;
        }

        @NonNull
        @Override
        public com.example.bookingtravel.adapters.rvadapters.RvListingCategoriesAdapter.RvHomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listing_categories,parent,false);
            return new com.example.bookingtravel.adapters.rvadapters.RvListingCategoriesAdapter.RvHomeVH(view);
        }

        @Override
        public void onBindViewHolder(@NonNull  RvHomeVH holder, int position) {


            if(citiesList  != null && countriesList != null ){
                City city =  citiesList.get(position) ;
                holder.nameCity.setTag(city.getCityName());

                holder.nameCity.setText(city.getCityName());

                if(city.getCityUrl() != null){
                    Glide.with(context).load(city.getCityUrl()).into(holder.imageView);
                }

                for(int i=0;i<countriesList.size();i++){
                    if(city.getCountryId() == countriesList.get(i).getId()){
                        holder.nameCountry.setText(countriesList.get(i).getCountryName());
                         holder.countDes.setText("9");
                    }
                }
            }else {
             }

            if(  activitiesList.size() != 0){
                holder.itemView.setTag(activitiesList.get(0).getId());
            }
                holder.countDes.setTag(citiesList.get(position).getId());
            }

        @Override
        public int getItemCount() {
            if(citiesList != null)
                return citiesList.size();

            return 0;
        }

        public class RvHomeVH extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView imageView ;
            TextView nameCity ;
            TextView nameCountry ;
            TextView countDes ;

            public RvHomeVH(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.iv_listing_categories);
                nameCity = itemView.findViewById(R.id.name_city_listing_categories);
                nameCountry = itemView.findViewById(R.id.name_country_listing_categories);
                countDes = itemView.findViewById(R.id.tv_count_destination_listing_categories);


                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                int activityId = (int) itemView.getTag();
                int cityId = (int) countDes.getTag();
                String countryName = (String) nameCountry.getTag();
                String cityName = (String) nameCity.getTag();
                sendPosition.sendPosition(activityId ,cityId,countryName,cityName);

            }
        }

        public void addCountriesList(ArrayList<Country> list){
            this.countriesList = list ;
            notifyDataSetChanged();
        }
        public void addCitiesList(ArrayList<City> list){
            this.citiesList = list ;
            notifyDataSetChanged();
        }
        public void addActivitiesList(ArrayList<Activity> list){
            this.activitiesList = list ;
            notifyDataSetChanged();
        }
        public void addCitiesActivitiesList(ArrayList<CityActivity> list){
            this.citiesActivitiesList = list ;
            notifyDataSetChanged();
        }
        public void clearCountriesList(){
            this.countriesList.clear();
            notifyDataSetChanged();
        }
        public void clearActivitiesList(){
            this.citiesActivitiesList.clear();
            notifyDataSetChanged();
        }
        public void clearCitiesActivitiesList(){
            this.citiesActivitiesList.clear();
            notifyDataSetChanged();
        }
        public void clearCitiesList(){
            this.citiesList.clear();
            notifyDataSetChanged();
        }
    }
