package com.example.bookingtravel.fragments.mainfragments;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.example.bookingtravel.R;
import com.example.bookingtravel.adapters.rvadapters.RvHomeAdapter;
import com.example.bookingtravel.adapters.viewpageradapters.HomePVA;
import com.example.bookingtravel.interfaces.listener.FSMListenerToHomeFragment;
import com.example.bookingtravel.interfaces.listener.SendALFromMainToHomeF;
import com.example.bookingtravel.interfaces.listener.SendSVFromHomeFToMainActivity;
import com.example.bookingtravel.pojo.PojoHomeFragment;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;
import com.example.bookingtravel.viewmodels.BookingTravelViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.EntryPoint;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment   {

    private SearchView searchView ;
    private RecyclerView recyclerView ;
    private ViewPager2 viewPager2 ;
    private TabLayout tabLayout ;
    private RvHomeAdapter rvHomeAdapter ;
    private HomePVA homePVA ;
    private SendSVFromHomeFToMainActivity svToMain ;


    private BookingTravelViewModel viewModel ;




    private FSMListenerToHomeFragment listener ;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FSMListenerToHomeFragment){
            listener = (FSMListenerToHomeFragment) context ;
        }

        if(context instanceof SendSVFromHomeFToMainActivity){
            svToMain = (SendSVFromHomeFToMainActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null ;
        svToMain = null ;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        searchView = view.findViewById(R.id.homeSearchView);
        recyclerView = view.findViewById(R.id.home_rv);
        viewPager2 = view.findViewById(R.id.home_view_pager);
        tabLayout = view.findViewById(R.id.home_tab_layout);


        viewModel = new ViewModelProvider(this).get(BookingTravelViewModel.class);


        viewModel.getActivities();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),RecyclerView.HORIZONTAL,false));

        viewModel.getListActivities().observe(getActivity() , new Observer<ArrayList<Activity>>() {
            @Override
            public void onChanged(ArrayList<Activity> list) {

                rvHomeAdapter = new RvHomeAdapter(list,getActivity());
                 recyclerView.setAdapter(rvHomeAdapter);
                rvHomeAdapter.notifyDataSetChanged();

            }
        });


        homePVA = listener.sendFSM();

        viewPager2.setAdapter(homePVA);

        setUpVP(view);

        searchView();

        svToMain.sendSearchView(searchView);



        return  view ;
    }

//    private void checkLanguage() {
//        String language = getContext().getResources().getConfiguration().locale.getLanguage();
//        if(language.equals("ar")){
//           searchView.setBackIcon(ContextCompat.getDrawable(getContext(),R.drawable.ic_arrow_right));
//        }else {
//
//        }
//    }

    private void addItemsToList(ArrayList<PojoHomeFragment> list) {
        list.add(new PojoHomeFragment("mountains",R.drawable.mountains_icon));
        list.add(new PojoHomeFragment("beach",R.drawable.beach_icon));
        list.add(new PojoHomeFragment("Kayak",R.drawable.kayak));
        list.add(new PojoHomeFragment("camping",R.drawable.camping));
    }


    public void setUpVP(View view){
        tabLayout.addTab(tabLayout.newTab().setText("Trend"));
        tabLayout.addTab(tabLayout.newTab().setText("Featured"));
        tabLayout.addTab(tabLayout.newTab().setText("Top Visit"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }

    private void searchView(){

        searchView.setImeOptions(EditorInfo.IME_ACTION_SEARCH);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rvHomeAdapter.getFilter().filter(newText);

                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                searchView.clearFocus();
                return false;
            }
        });

    }

}