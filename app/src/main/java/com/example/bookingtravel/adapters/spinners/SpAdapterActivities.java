package com.example.bookingtravel.adapters.spinners;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookingtravel.R;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;

import java.util.ArrayList;

public class SpAdapterActivities extends BaseAdapter {

    ArrayList<Activity> list ;
    Context context ;

    public SpAdapterActivities( Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        if(list != null){
            return list.size();
        }

        return 0 ;

    }


    public void setActivitiesList(ArrayList<Activity> list){
        this.list = list ;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_spinner_name_activities,parent,false);

      TextView textView = view.findViewById(R.id.tv_name_activity_spinner);

      textView.setText(list.get(position).getNameActivity());
        return view;
    }
}
