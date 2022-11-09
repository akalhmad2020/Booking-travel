package com.example.bookingtravel.adapters.viewpageradapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bookingtravel.fragments.mainfragments.CategoriesFragment;
import com.example.bookingtravel.fragments.mainfragments.FavouriteFragment;
import com.example.bookingtravel.fragments.mainfragments.HomeFragment;
import com.example.bookingtravel.fragments.mainfragments.YourBookingFragment;


public class MainPVA extends FragmentStateAdapter {

    public MainPVA(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new CategoriesFragment();
            case 2 :
                return new FavouriteFragment();
            case 3:
                return new YourBookingFragment();

        }
        return new HomeFragment();
    }


    @Override
    public int getItemCount() {
        return 4;
    }
}
