package com.example.bookingtravel.fragments.mainfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.adapters.rvadapters.RvListingCategoriesAdapter;

import com.example.bookingtravel.adapters.spinners.SpAdapterActivities;
import com.example.bookingtravel.adapters.spinners.SpAdapterCountries;
import com.example.bookingtravel.databinding.FragmentListingCategoriesBinding;
import com.example.bookingtravel.interfaces.listener.SendPositionFromRvLCatToFLCat;
import com.example.bookingtravel.interfaces.listener.SetUpFDD;
import com.example.bookingtravel.pojo.PojoListingCategories;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;
import com.example.bookingtravel.pojo.pojofornetwork.City;
import com.example.bookingtravel.pojo.pojofornetwork.CityActivity;
import com.example.bookingtravel.pojo.pojofornetwork.Country;
import com.example.bookingtravel.viewmodels.BookingTravelViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

import com.example.bookingtravel.R;

    @AndroidEntryPoint
    public class ListingCategoriesFragment extends Fragment implements SendPositionFromRvLCatToFLCat {


         private RvListingCategoriesAdapter adapter ;
        // to send position from this fragment (ListingCategoriesFragment) to ListingCategories Activity
        private SetUpFDD setUpFDD ;
        private SpAdapterActivities spAdapterActivities ;
        private SpAdapterCountries spAdapterCountries;
        private ArrayList<Country> countriesList ;
        private ArrayList<City> citiesList ;
        private ArrayList<CityActivity> citiesActivitiesList ;
        private ArrayList<Activity> activitiesList ;

        private BookingTravelViewModel viewModel ;

         private static final String ARG_NAME_ACTIVITY = "nameActivity";


        private String newActivityName  ;

        @Override
        public void onAttach(@NonNull Context context) {
            super.onAttach(context);
            if(context instanceof SetUpFDD){
                setUpFDD = (SetUpFDD) context;
            }else {
                throw new ClassCastException("errorSetUpFDD");
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
            setUpFDD = null ;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null){
                 newActivityName = getArguments().getString(ARG_NAME_ACTIVITY);
            }
        }

        public static ListingCategoriesFragment newInstance(  String nameActivity){

             ListingCategoriesFragment fragment = new ListingCategoriesFragment();
            Bundle args = new Bundle();

            args.putString(ARG_NAME_ACTIVITY,nameActivity);
            fragment.setArguments(args);
            return fragment ;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            FragmentListingCategoriesBinding binding = FragmentListingCategoriesBinding.inflate
                    (getLayoutInflater() , container , false);



            countriesList = new ArrayList<>();
            citiesList = new ArrayList<>();
            citiesActivitiesList = new ArrayList<>();
            activitiesList = new ArrayList<>();

            viewModel = new ViewModelProvider(this).get(BookingTravelViewModel.class);

            viewModel.getCities();
            viewModel.getActivities();
            viewModel.getCountries();
            viewModel.getCitiesActivities();

            viewModel.getListActivities().observe(getActivity(), new Observer<ArrayList<Activity>>() {
                @Override
                public void onChanged(ArrayList<Activity> list) {

                    adapter.addActivitiesList(list);
                    spAdapterActivities.setActivitiesList(list);
                   activitiesList = list ;
                }
            });


            viewModel.getListCitiesActivities().observe(getActivity(), new Observer<ArrayList<CityActivity>>() {
                @Override
                public void onChanged(ArrayList<CityActivity> cityActivities) {

                    citiesActivitiesList = cityActivities ;
                   adapter.addCitiesActivitiesList(cityActivities);
                }
            });


            viewModel.getListCities().observe(getActivity(), new Observer<ArrayList<City>>() {
                @Override
                public void onChanged(ArrayList<City> cities) {

                 adapter.addCitiesList(cities);
                citiesList = cities ;

                }
            });


            viewModel.getListCountries().observe(getActivity(), new Observer<ArrayList<Country>>() {
                @Override
                public void onChanged(ArrayList<Country> countries) {

                   adapter.addCountriesList(countries);
                    spAdapterCountries.setCountriesList(countries);
                    countriesList = countries ;
                }
            });



            if(countriesList.size() != 0 && citiesList.size() != 0 && citiesActivitiesList.size()!=0
                    && activitiesList.size() !=0){
                Country country = countriesList.get(0);
                ArrayList<City> newCitiesList = new ArrayList<>();
                for(int i=0;i<citiesList.size();i++){
                    if(citiesList.get(i).getCountryId() == country.getId()){
                        newCitiesList.add(citiesList.get(i));
                    }
                }
                adapter.addCitiesList(newCitiesList);
            }


            binding.rvListingCategories.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),RecyclerView.VERTICAL,false));
            adapter = new RvListingCategoriesAdapter(binding.getRoot().getContext(), this );
            binding.rvListingCategories.setAdapter(adapter);



              spAdapterActivities = new SpAdapterActivities(binding.getRoot().getContext());
             binding.spNameActivity.setAdapter(spAdapterActivities);


             spAdapterCountries = new SpAdapterCountries(binding.getRoot().getContext());
             binding.spCountries.setAdapter(spAdapterCountries);


             binding.spNameActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                     if( activitiesList.size() !=0){
                         Activity activity = activitiesList.get(position);
                         newActivityName = activity.getNameActivity();

                         ArrayList<Activity> newActivitiesList = new ArrayList<>();

                         newActivitiesList.add(activity);


                         adapter.addActivitiesList(newActivitiesList);
                     }
                  }
                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {
                 }
             });

             binding.spCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                 @Override
                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     if(countriesList.size() != 0 && citiesList.size() != 0 && citiesActivitiesList.size()!=0
                     && activitiesList.size() !=0){
                         Country country = countriesList.get(position);
                          ArrayList<City> newCitiesList = new ArrayList<>();
                         for(int i=0;i<citiesList.size();i++){
                             if(citiesList.get(i).getCountryId() == country.getId()){
                                 newCitiesList.add(citiesList.get(i));
                             }
                         }
                         adapter.addCitiesList(newCitiesList);
                     }
                 }
                 @Override
                 public void onNothingSelected(AdapterView<?> parent) {

                 }
             });

            return binding.getRoot() ;
        }

        @Override
        public void sendPosition(int activityId , int cityId , String countryName, String cityName ) {
            setUpFDD.setUpFdd(activityId, cityId,countryName,cityName,newActivityName);
        }
    }








