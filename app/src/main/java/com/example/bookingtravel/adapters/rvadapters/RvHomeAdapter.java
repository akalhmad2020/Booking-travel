package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookingtravel.R;
import com.example.bookingtravel.pojo.PojoHomeFragment;
import com.example.bookingtravel.pojo.pojofornetwork.Activity;
import com.example.bookingtravel.ui.main.ListingCategories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;


public class RvHomeAdapter extends RecyclerView.Adapter<RvHomeAdapter.RvHomeVH> implements Filterable {

    List<Activity> list ;
    List<Activity> fullList ;
    Context context ;

    public RvHomeAdapter(List<Activity> list , Context context) {
        this.list = list;
        this.fullList = new ArrayList<>(list);
        this.context = context ;
    }

    @NonNull
    @Override
    public RvHomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_rv,parent,false);
        return new RvHomeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHomeVH holder, int position) {
        holder.textView.setText(list.get(position).getNameActivity());

        if(list.get(position).getActivityUrl() != null){
            Glide.with(context).load(list.get(position).getActivityUrl()).into(holder.imageView);
        }

        holder.itemView.setTag(position);
        holder.textView.setTag(list.get(position).getNameActivity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public Filter getFilter() {
        return filter;
    }


    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Activity> listFilter = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0 ){
                listFilter.addAll(fullList);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();
                for(Activity item : fullList){
                    if(item.getNameActivity().toLowerCase().contains(filterPattern)){
                        listFilter.add(item);
                    }
                }
            }

            FilterResults filterResults = new FilterResults() ;
            filterResults.values = listFilter ;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
            list.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };


    public class RvHomeVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView ;
        TextView textView ;

        public RvHomeVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_iv_home_rv);
            textView = itemView.findViewById(R.id.item_tv_home_rv);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = (int) itemView.getTag();
            String nameActivity = (String) textView.getTag();
            context.startActivity(new Intent(context, ListingCategories.class).putExtra("nameActivity",nameActivity)
                    .putExtra("pItemRvHome",position));
        }
    }
}
