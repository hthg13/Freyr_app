package com.example.client.ui.Activities.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecipeViewHolder> {

    private ArrayList<String>/*<Recipes>*/ recipes;
    // images fæst úr recipes arraylist þegar Recipe Object er tilbúinn
    private int[] images;

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public ImageView image;
        public RecipeViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.vmynd);
            title = v.findViewById(R.id.vtitle);
        }
    }

    public RecyclerAdapter(ArrayList<String>/*<Recipes>*/ r, int[] i) {
        recipes = r;
        images = i;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_view_layout, parent, false);

        RecipeViewHolder vh = new RecipeViewHolder(view);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecipeViewHolder holder, int position) {
        holder.title.setText(recipes.get(position));
        holder.image.setImageResource(images[position]);

        /*
        holder.image.setImageResource(recipes.get(position).getImage();
         */
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
