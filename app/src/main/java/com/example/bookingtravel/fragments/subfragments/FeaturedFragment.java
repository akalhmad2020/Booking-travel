package com.example.bookingtravel.fragments.subfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvFeaturedAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvTopVisitAdapter;

public class FeaturedFragment extends Fragment {

    private RecyclerView recyclerView ;
    private RvFeaturedAdapter rvFeaturedAdapter ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_featured, container, false);

        recyclerView = view.findViewById(R.id.rv_featured);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL,false));
        rvFeaturedAdapter = new RvFeaturedAdapter(view.getContext());
        recyclerView.setAdapter(rvFeaturedAdapter);
        return  view ;
    }
}