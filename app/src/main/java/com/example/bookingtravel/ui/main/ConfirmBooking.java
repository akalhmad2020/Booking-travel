package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookingtravel.R;
import com.example.bookingtravel.databinding.ActivityConfirmBookingBinding;
import com.example.bookingtravel.databinding.ActivityViewRoomBinding;

public class ConfirmBooking extends AppCompatActivity {

    ActivityConfirmBookingBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityConfirmBookingBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.btConfirmationConfirmBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConfirmBooking.this,CompleteBooking.class));
            }
        });



    }
}