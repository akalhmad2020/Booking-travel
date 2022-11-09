package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.bookingtravel.adapters.rvadapters.RvCompleteBookingAdapter;
import com.example.bookingtravel.databinding.ActivityComplateBookingBinding;

public class CompleteBooking extends AppCompatActivity {

    ActivityComplateBookingBinding binding ;

    private RvCompleteBookingAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComplateBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvCompleteBooking.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RvCompleteBookingAdapter();
        binding.rvCompleteBooking.hasFixedSize();
        binding.rvCompleteBooking.setAdapter(adapter);


    }
}