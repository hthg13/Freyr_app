package com.example.client.ui.Activities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.RecipeViewActivity;

import java.util.ArrayList;

public class RecyclerAdapterCreateRecipe extends RecyclerView.Adapter<RecyclerAdapterCreateRecipe.RecipeViewHolder> {

    private ArrayList<String> ingr;
    // images fæst úr recipes arraylist þegar Recipe Object er tilbúinn
    private String[] images;

    private Context context;

    public RecyclerAdapterCreateRecipe(ArrayList<String> r, Context c) {
        ingr = r;
        context = c;

    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView title;
        Context context;
        ArrayList<String> ingr;


        public RecipeViewHolder(View v, Context c, ArrayList<String> r, String[] i) {
            super(v);

            title = v.findViewById(R.id.cbTitle);
            itemView.setOnClickListener(this);

            this.context = c;
            this.ingr = r;
        }


        @Override
        public void onClick(View v) {

        }
    }


    @NonNull
    @Override
    public RecyclerAdapterCreateRecipe.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view_layout, parent, false);

        RecipeViewHolder vh = new RecipeViewHolder(view, context, ingr, images);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterCreateRecipe.RecipeViewHolder holder, final int position) {
        holder.title.setText(ingr.get(position));
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingr.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, ingr.size());

                }
        });

        /*
        holder.image.setImageResource(recipes.get(position).getImage();
        */
    }

    @Override
    public int getItemCount() {
        return ingr.size();
    }


}
