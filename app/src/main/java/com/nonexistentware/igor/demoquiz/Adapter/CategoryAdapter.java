package com.nonexistentware.igor.demoquiz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nonexistentware.igor.demoquiz.Common.Common;
import com.nonexistentware.igor.demoquiz.MainActivity;
import com.nonexistentware.igor.demoquiz.Model.Category;
import com.nonexistentware.igor.demoquiz.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    Context context;
    List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_category_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.txtCategoryName.setText(categories.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardCategory;
        TextView txtCategoryName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardCategory = (CardView) itemView.findViewById(R.id.cardCategory);
            txtCategoryName = (TextView) itemView.findViewById(R.id.txtCategoryName);
            cardCategory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Click at category" + categories.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();

                    Common.selectedCategory = categories.get(getAdapterPosition());
//                    Intent intent = new Intent(context, Ques)
                }
            });
        }
    }
}
