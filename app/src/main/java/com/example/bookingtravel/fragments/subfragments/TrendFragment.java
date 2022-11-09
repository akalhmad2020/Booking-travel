package com.example.bookingtravel.fragments.subfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvTrendAdapter;
import com.example.bookingtravel.pojo.pojotosubfragments.TrendPojo;

import java.util.ArrayList;
import java.util.List;


public class TrendFragment extends Fragment {

    private RecyclerView recyclerView ;
    private RvTrendAdapter rvTrendAdapter ;
    private List<TrendPojo> list ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trend, container, false);

        list = new ArrayList<>();
        addItemsToList(list);
        recyclerView = view.findViewById(R.id.rv_trend);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false));
        rvTrendAdapter = new RvTrendAdapter(list,view.getContext());
        recyclerView.setAdapter(rvTrendAdapter);

        return  view ;
    }

     void addItemsToList(List<TrendPojo> list){
        list.add(new TrendPojo("kanyouns" , R.drawable.japan));
        list.add(new TrendPojo("gaza" , R.drawable.japan));
        list.add(new TrendPojo("rfah" , R.drawable.japan));

    }

}