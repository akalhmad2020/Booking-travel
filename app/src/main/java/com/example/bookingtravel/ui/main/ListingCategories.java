package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bookingtravel.R;
import com.example.bookingtravel.databinding.ActivityListingCategoriesBinding;
import com.example.bookingtravel.fragments.mainfragments.DestinationsDetails;
import com.example.bookingtravel.fragments.mainfragments.ListingCategoriesFragment;
import com.example.bookingtravel.interfaces.listener.SetUpFDD;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ListingCategories extends AppCompatActivity implements View.OnClickListener ,
        SetUpFDD {
    ActivityListingCategoriesBinding binding ;
    private  int pItemRvHome ;
    private String nameActivity ;

    private int positionCategory ;
    private String nameCategory ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityListingCategoriesBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        pItemRvHome =  getIntent().getIntExtra("pItemRvHome",0);
        nameActivity = getIntent().getStringExtra("nameActivity");

        nameCategory = getIntent().getStringExtra("nameCategory");
        positionCategory = getIntent().getIntExtra("positionCategory",0);

        if(nameActivity != null ){
            doIt(nameActivity,pItemRvHome);
        }else if(nameCategory != null ){
            doIt(nameCategory,positionCategory);
        }
        else  {
             nameActivity = "Beaches";
            doIt(nameActivity,pItemRvHome);
        }
    }

    void doIt(String nameActivity , int pItemRvHome){

        setUpFragment(ListingCategoriesFragment.newInstance( nameActivity));
        binding.backArrow.setOnClickListener(this);
        binding.backArrowSecond.setOnClickListener(this);
    }

    private void setUpFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
        binding.backArrowSecond.setVisibility(View.GONE);
        binding.backArrow.setVisibility(View.VISIBLE);
    }
    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.back_arrow:
               startActivity(new Intent(this,MainActivity.class));
               finish();
               break;
           case R.id.back_arrow_second:
               setUpFragment(ListingCategoriesFragment.newInstance( nameActivity));
               break;
       }
    }
    @Override
    public void setUpFdd(int activityId , int cityId , String countryName , String cityName , String newActivityName) {
        // here we send position from RvListingCategoriesAdapter and nameActivity from RvHomeAdapter
        // to fragment DestinationDetails by interface setUpFdd that takes position from
        //  ListingCategoriesFragment that took it from RvHomeAdapter
         setUpFragment(DestinationsDetails.newInstance(activityId,cityId,countryName,cityName,newActivityName));

         // here I control of visibility its backArrowSecond and backArrow
        binding.backArrowSecond.setVisibility(View.VISIBLE);
        binding.backArrow.setVisibility(View.GONE);

    }
}