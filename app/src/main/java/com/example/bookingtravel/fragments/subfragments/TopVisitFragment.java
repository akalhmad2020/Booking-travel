package com.example.bookingtravel.fragments.subfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvTopVisitAdapter;
import com.example.bookingtravel.adapters.rvadapters.RvTrendAdapter;

public class TopVisitFragment extends Fragment {

    private RecyclerView recyclerView ;
    private RvTopVisitAdapter rvTopVisitAdapter ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_top_visit, container, false);

        recyclerView = view.findViewById(R.id.rv_top_visit);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false));
        rvTopVisitAdapter = new RvTopVisitAdapter();
        recyclerView.setAdapter(rvTopVisitAdapter);

        return  view;
    }
}