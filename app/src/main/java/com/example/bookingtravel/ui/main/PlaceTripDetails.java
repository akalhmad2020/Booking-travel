package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookingtravel.R;
import com.example.bookingtravel.databinding.ActivityPlaceTripDetailsBinding;

public class PlaceTripDetails extends AppCompatActivity implements View.OnClickListener {

    ActivityPlaceTripDetailsBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityPlaceTripDetailsBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.arrowBPtd.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("positionRvDDA");

        binding.btTripPlan.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.arrow_b_ptd :
                startActivity(new Intent(this, ListingCategories.class));
                finish();
                break;
            case R.id.bt_trip_plan :
                startActivity(new Intent(this, TripPlan.class));
                finish();
                break;
        }
    }
}