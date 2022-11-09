package com.example.bookingtravel.adapters.rvadapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookingtravel.R;
import com.example.bookingtravel.pojo.pojotosubfragments.PojoCategories;
import com.example.bookingtravel.ui.main.ListingCategories;

import java.util.List;

public class RvCategoriesAdapter extends RecyclerView.Adapter<RvCategoriesAdapter.RvHomeVH> {

      private Context context ;
      private List<PojoCategories> list ;

    public RvCategoriesAdapter(Context context , List<PojoCategories> list) {
        this.context = context;
        this.list = list ;
    }

    @NonNull
    @Override
    public RvHomeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categories,parent,false);
        return new RvHomeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHomeVH holder, int position) {

        PojoCategories pojoCategories = list.get(position) ;
        holder.countDes.setText(pojoCategories.getCountDestinations()+"");
        holder.tvNameCategory.setText(pojoCategories.getNameCategory());
        holder.imageView.setImageResource(pojoCategories.getImageId());
        holder.itemView.setTag(position);
        holder.tvNameCategory.setTag(pojoCategories.getNameCategory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class RvHomeVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView ;
        TextView tvNameCategory ;
        TextView countDes ;

        public RvHomeVH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_categories);
            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
            countDes = itemView.findViewById(R.id.tv_count_destination_categories);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ListingCategories.class);
            int position = (int) itemView.getTag();
            String nameCategory = (String) tvNameCategory.getTag() ;
            intent.putExtra("positionCategory",position);
            intent.putExtra("nameCategory",nameCategory);
            context.startActivity(intent);
        }
    }
}
