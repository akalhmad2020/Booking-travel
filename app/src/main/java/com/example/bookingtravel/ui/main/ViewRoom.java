package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bookingtravel.R;
import com.example.bookingtravel.databinding.ActivityViewRoomBinding;

public class ViewRoom extends AppCompatActivity {

    ActivityViewRoomBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityViewRoomBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());





    }
}