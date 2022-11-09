package com.example.bookingtravel.fragments.mainfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvCategoriesAdapter;
import com.example.bookingtravel.pojo.PojoHomeFragment;
import com.example.bookingtravel.pojo.pojotosubfragments.PojoCategories;

import java.util.ArrayList;
import java.util.List;

public class  CategoriesFragment extends Fragment {

    private RecyclerView recyclerView ;

    private RvCategoriesAdapter rvCategoriesAdapter ;

    private List<PojoCategories> list ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view  = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = view.findViewById(R.id.rv_categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false));
       list = new ArrayList<>();
       addItemsToList(list);
        rvCategoriesAdapter = new RvCategoriesAdapter(view.getContext(),list);
        recyclerView.setAdapter(rvCategoriesAdapter);
       return view ;
    }

    private void addItemsToList(List<PojoCategories> list) {
        list.add(new PojoCategories(112,R.drawable.mountains_2,"mountains"));
        list.add(new PojoCategories(22,R.drawable.beach,"beach"));
        list.add(new PojoCategories(52,R.drawable.kayak_2,"kayak"));
        list.add(new PojoCategories(92,R.drawable.camping_2,"camping"));
        list.add(new PojoCategories(28,R.drawable.landmark,"landmark"));

    }

}