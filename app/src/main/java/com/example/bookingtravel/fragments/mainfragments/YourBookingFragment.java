package com.example.bookingtravel.fragments.mainfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvFavouriteAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvYourBookingAdapter;

public class YourBookingFragment extends Fragment {

    private RecyclerView recyclerView ;
    private RvYourBookingAdapter rvYourBookingAdapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_booking, container, false);

        recyclerView = view.findViewById(R.id.rv_your_booking);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL,false));
        rvYourBookingAdapter = new RvYourBookingAdapter();
        recyclerView.setAdapter(rvYourBookingAdapter);


        return view ;
    }
}