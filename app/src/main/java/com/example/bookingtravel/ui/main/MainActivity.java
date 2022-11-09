package com.example.bookingtravel.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.viewpageradapters.HomePVA;
import com.example.bookingtravel.adapters.viewpageradapters.MainPVA;
import com.example.bookingtravel.databinding.ActivityMainBinding;
import com.example.bookingtravel.interfaces.listener.FSMListenerToHomeFragment;
import com.example.bookingtravel.interfaces.listener.SendALFromMainToHomeF;
import com.example.bookingtravel.interfaces.listener.SendSVFromHomeFToMainActivity;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;
import com.example.bookingtravel.viewmodels.BookingTravelViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements FSMListenerToHomeFragment ,
        SendSVFromHomeFToMainActivity {

    MainPVA mainPVA ;
    ActivityMainBinding binding ;
    private SearchView searchViewHomeFragment ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());




        mainPVA = new MainPVA(getSupportFragmentManager(),getLifecycle());
        binding.MainViewPager.setAdapter(mainPVA);
        setUpViewPager();
    }
    private void setUpViewPager(){
        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setIcon(R.drawable.home));
        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setIcon(R.drawable.categories));
        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setIcon(R.drawable.favourite));
        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setIcon(R.drawable.your_cart));

        binding.mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.MainViewPager.setCurrentItem(tab.getPosition());
               switch (tab.getPosition()){
                   case 0:
                       binding.linearHiName.setVisibility(View.VISIBLE);
                       binding.linearSvCategories.setVisibility(View.GONE);
                       binding.linearSvFavourite.setVisibility(View.GONE);
                       binding.linearSvYourBooking.setVisibility(View.GONE);
                       break;
                   case 1:
                       binding.linearHiName.setVisibility(View.GONE);
                       binding.linearSvCategories.setVisibility(View.VISIBLE);
                       binding.linearSvFavourite.setVisibility(View.GONE);
                       binding.linearSvYourBooking.setVisibility(View.GONE);
                       break;
                   case 2:
                       binding.linearHiName.setVisibility(View.GONE);
                       binding.linearSvCategories.setVisibility(View.GONE);
                       binding.linearSvFavourite.setVisibility(View.VISIBLE);
                       binding.linearSvYourBooking.setVisibility(View.GONE);
                       break;
                   case 3:
                       binding.linearHiName.setVisibility(View.GONE);
                       binding.linearSvCategories.setVisibility(View.GONE);
                       binding.linearSvFavourite.setVisibility(View.GONE);
                       binding.linearSvYourBooking.setVisibility(View.VISIBLE);
                        break;
               }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.MainViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                binding.mainTabLayout.selectTab(binding.mainTabLayout.getTabAt(position));
            }
        });
    }

    @Override
    public HomePVA sendFSM() {
       HomePVA homePVA = new HomePVA(getSupportFragmentManager(),getLifecycle());
        return homePVA ;
    }

    @Override
    public void onBackPressed() {
        if(!searchViewHomeFragment.isIconified()){
            searchViewHomeFragment.onActionViewCollapsed();
        }else {
            super.onBackPressed();
        }
    }
    @Override
    public void sendSearchView(SearchView searchView) {
        searchViewHomeFragment = searchView ;
    }
}
