package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvTripPlanCheckInHotelAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvTripPlanDaysAdapter;
import com.example.bookingtravel.databinding.ActivityTripPlanBinding;

public class TripPlan extends AppCompatActivity implements View.OnClickListener {

    ActivityTripPlanBinding binding ;


    private RecyclerView rvTripPlanDays ;
    private RvTripPlanDaysAdapter rvTripPlanDaysAdapter ;



    private RecyclerView rvCheckInHotel ;
    private RvTripPlanCheckInHotelAdapter rvTripPlanCheckInHotelAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTripPlanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        rvTripPlanDays =  findViewById(R.id.rv_trip_plan_days);
        rvTripPlanDays.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rvTripPlanDaysAdapter = new RvTripPlanDaysAdapter(this);
        rvTripPlanDays.setAdapter(rvTripPlanDaysAdapter);




        rvCheckInHotel =  findViewById(R.id.rv_check_in_hotel);
        rvCheckInHotel.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rvTripPlanCheckInHotelAdapter = new RvTripPlanCheckInHotelAdapter(this);
        rvCheckInHotel.setAdapter(rvTripPlanCheckInHotelAdapter);



        binding.btTripPlanBookNow.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_trip_plan_book_now :
                startActivity(new Intent(this,BookingTrip.class));
                finish();
                break;
        }
    }
}