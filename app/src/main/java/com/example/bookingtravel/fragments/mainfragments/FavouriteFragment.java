package com.example.bookingtravel.fragments.mainfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvFavouriteAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvListingCategoriesAdapter;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;
import com.example.bookingtravel.viewmodels.BookingTravelViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FavouriteFragment extends Fragment {


    private BookingTravelViewModel  viewModel ;

    private RecyclerView recyclerView ;
    private RvFavouriteAdapter rvFavouriteAdapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favourite, container, false);


        viewModel = new ViewModelProvider(this).get(BookingTravelViewModel.class);


        viewModel.getActivities();

        viewModel.getListActivities().observe(getActivity(), new Observer<ArrayList<Activity>>() {
            @Override
            public void onChanged(ArrayList<Activity> list) {
                rvFavouriteAdapter = new RvFavouriteAdapter(list,view.getContext());
                recyclerView.setAdapter(rvFavouriteAdapter);
                rvFavouriteAdapter.notifyDataSetChanged();

            }
        });



        recyclerView = view.findViewById(R.id.rv_favourite);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL,false));



        return view ;
    }
}