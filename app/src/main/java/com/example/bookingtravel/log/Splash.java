package com.example.bookingtravel.log;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookingtravel.R;
import com.example.bookingtravel.databinding.ActivitySplashBinding;

public class Splash extends AppCompatActivity implements View.OnClickListener {

    ActivitySplashBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.signInSplash.setOnClickListener(this);
        binding.signUpSplash.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in_splash:
                startActivity(new Intent(this,LogIn.class));
                break;
            case R.id.sign_up_splash:
                startActivity(new Intent(this,LogUp.class));
                break;
        }
    }
}