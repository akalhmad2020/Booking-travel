package com.example.bookingtravel.adapters.viewpageradapters;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.transition.FragmentTransitionSupport;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bookingtravel.fragments.mainfragments.CategoriesFragment;
import com.example.bookingtravel.fragments.mainfragments.FavouriteFragment;
import com.example.bookingtravel.fragments.mainfragments.HomeFragment;
import com.example.bookingtravel.fragments.mainfragments.YourBookingFragment;
import com.example.bookingtravel.fragments.subfragments.FeaturedFragment;
import com.example.bookingtravel.fragments.subfragments.TopVisitFragment;
import com.example.bookingtravel.fragments.subfragments.TrendFragment;


public class HomePVA extends FragmentStateAdapter {


    public HomePVA(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new TrendFragment();
            case 1:
                return new FeaturedFragment();
            case 2:
                return new TopVisitFragment();
        }
        return new TrendFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
