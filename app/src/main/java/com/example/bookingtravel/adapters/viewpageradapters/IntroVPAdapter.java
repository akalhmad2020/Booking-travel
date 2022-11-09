package com.example.bookingtravel.adapters.viewpageradapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bookingtravel.R;


import java.util.ArrayList;

public class IntroVPAdapter  extends RecyclerView.Adapter<IntroVPAdapter.IntroHolder> {

    ArrayList<String> list  ;

    public IntroVPAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public IntroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_intro,
                parent,false);
        return new IntroHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntroHolder holder, int position) {
        holder.textView.setText(list.get(position));

        if(position == 0) {
            holder.linearLayout.setBackgroundResource(R.drawable.bg_intro);
        }else if(position == 1)
        {
            holder.linearLayout.setBackgroundResource(R.drawable.bg_intro2);

        }
        else if(position == 2)
        {
            holder.linearLayout.setBackgroundResource(R.drawable.bg_intro3);

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class IntroHolder extends RecyclerView.ViewHolder {

        public  TextView textView  ;
        public LinearLayout linearLayout ;
        public IntroHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_item_intro);
            linearLayout = itemView.findViewById(R.id.bg_item_vp_intro);

        }
    }

}
