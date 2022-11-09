package com.example.bookingtravel.fragments.mainfragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvDestinationDetalisAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvTopActivitiesAdapter;
import com.example.bookingtravel.pojo.PojoDestinationDetails;
import com.example.bookingtravel.pojo.pojofornetwork.CityActivity;
import com.example.bookingtravel.pojo.pojotosubfragments.PojoPlacesAndActivities;
import com.example.bookingtravel.viewmodels.BookingTravelViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DestinationsDetails extends Fragment {

    private RecyclerView recyclerView ;
    private RvDestinationDetalisAdapter adapter ;

    private RecyclerView topActivitiesRv ;
    private RvTopActivitiesAdapter rvTopActivitiesAdapter ;

    private TextView tvCityName , tvActivityName ;
    private static final String ARG_COUNTRY_NAME = "countryName" ;
    private static final String ARG_CITY_NAME = "cityName" ;
    private static final String ARG_NAME_ACTIVITY = "activityName" ;
    private static final String ARG_ACTIVITY_ID = "activityId" ;
    private static final String ARG_CITY_ID = "cityId" ;

    private String countryName ;
    private String cityName ;
    private String activityName ;
    private int activityId , cityId;
     private List<CityActivity> list ;
     private BookingTravelViewModel viewModel ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            countryName = getArguments().getString(ARG_COUNTRY_NAME);
            cityName = getArguments().getString(ARG_CITY_NAME);
            activityName = getArguments().getString(ARG_NAME_ACTIVITY);
            activityId = getArguments().getInt(ARG_ACTIVITY_ID);
            cityId = getArguments().getInt(ARG_CITY_ID);
        }
    }

    public static DestinationsDetails newInstance(int activityId , int cityId, String countryName , String cityName
    , String activityName){
        DestinationsDetails fragment = new DestinationsDetails();

        Bundle args = new Bundle();
        args.putString(ARG_COUNTRY_NAME,countryName);
        args.putString(ARG_CITY_NAME,cityName);
        args.putString(ARG_NAME_ACTIVITY,activityName);
        args.putInt(ARG_ACTIVITY_ID,activityId);
        args.putInt(ARG_CITY_ID,cityId);
        fragment.setArguments(args);
        return fragment ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_destinations_details, container, false);


        viewModel = new ViewModelProvider(this).get(BookingTravelViewModel.class);


        viewModel.getCitiesActivities();


        viewModel.getListCitiesActivities().observe(getActivity(), new Observer<ArrayList<CityActivity>>() {
            @Override
            public void onChanged(ArrayList<CityActivity> cityActivities) {
               ArrayList<CityActivity> newCityActivityList = new ArrayList<>();
                for(int i=0; i<cityActivities.size() ; i++){

                    if(cityId == cityActivities.get(i).getCityId() &&
                    activityId == cityActivities.get(i).getActivityId()){
                        newCityActivityList.add(cityActivities.get(i));
                    }

                }

                adapter.addCitiesActivitiesList(newCityActivityList);



            }
        });


        tvCityName = view.findViewById(R.id.tv_city_name_d_d);
        tvActivityName = view.findViewById(R.id.tv_activity_name_d_d);
        recyclerView = view.findViewById(R.id.rv_fdd);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        list = new ArrayList<>();

          adapter = new RvDestinationDetalisAdapter(view.getContext(),list , cityName, countryName);



        recyclerView.setAdapter(adapter);
        tvCityName.setText(cityName);
        tvActivityName.setText(activityName);
        topActivitiesRv = view.findViewById(R.id.rv_top_activities_fdd);
        topActivitiesRv.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));
        rvTopActivitiesAdapter = new RvTopActivitiesAdapter();
        topActivitiesRv.setAdapter(rvTopActivitiesAdapter);

        return view ;
    }


}