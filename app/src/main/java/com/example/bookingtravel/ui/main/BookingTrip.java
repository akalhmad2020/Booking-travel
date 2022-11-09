package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvBookingTripCountPeopleAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvBookingTripRoomAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvBookingTripSelectTransportationAdapter;
import com.example.bookingtravel.databinding.ActivityBookingTripBinding;

public class BookingTrip extends AppCompatActivity implements View.OnClickListener {

    ActivityBookingTripBinding binding ;


    private RvBookingTripCountPeopleAdapter countPeopleAdapter ;
    private RvBookingTripRoomAdapter roomAdapter ;
    private RvBookingTripSelectTransportationAdapter transportationAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityBookingTripBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.rvBookingTripCountPeople.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        countPeopleAdapter = new RvBookingTripCountPeopleAdapter();
        binding.rvBookingTripCountPeople.setAdapter(countPeopleAdapter);


        binding.rvBookingTripRoom.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        roomAdapter = new RvBookingTripRoomAdapter(this);
        binding.rvBookingTripRoom.setAdapter(roomAdapter);



        binding.rvBookingTransportation.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        transportationAdapter = new RvBookingTripSelectTransportationAdapter();
        binding.rvBookingTransportation.setAdapter(transportationAdapter);


        binding.btBookingTripConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_booking_trip_confirm :
                startActivity(new Intent(this,ConfirmBooking.class));
        }
    }
}