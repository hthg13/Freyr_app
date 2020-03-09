package com.example.client.ui.Activities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.ui.Activities.RecipeViewActivity;

import java.util.ArrayList;

public class RecyclerAdapterCookBook extends RecyclerView.Adapter<RecyclerAdapterCookBook.RecipeViewHolder> {

    private ArrayList<String>/*<Recipes>*/ recipes;
    // images fæst úr recipes arraylist þegar Recipe Object er tilbúinn
    private int[] images;

    private Context context;

    public RecyclerAdapterCookBook(ArrayList<String>/*<Recipes>*/ r, int[] i, Context c) {
        recipes = r;
        images = i;
        context = c;
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView title;
        Context context;
        ArrayList<String> recipes;
        int[] images;

        public RecipeViewHolder(View v, Context c, ArrayList<String>/*<Recipes>*/ r, int[] i) {
            super(v);

            title = v.findViewById(R.id.cbTitle);
            itemView.setOnClickListener(this);

            this.context = c;
            this.images = i;
            this.recipes = r;
        }

        @Override
        public void onClick(View v) {
            Intent recipeViewIntent= new Intent(this.context, RecipeViewActivity.class);
            recipeViewIntent.putExtra("recipeImage", images[getAdapterPosition()]);
            recipeViewIntent.putExtra("recipeTitle", recipes.get(getAdapterPosition()));
            this.context.startActivity(recipeViewIntent);
        }
    }


    @NonNull
    @Override
    public RecyclerAdapterCookBook.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view_layout, parent, false);

        RecipeViewHolder vh = new RecipeViewHolder(view, context, recipes, images);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterCookBook.RecipeViewHolder holder, int position) {
        holder.title.setText(recipes.get(position));


        /*
        holder.image.setImageResource(recipes.get(position).getImage();
         */
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
