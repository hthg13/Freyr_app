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

public class RecyclerAdapterCookBook extends RecyclerView.Adapter<RecyclerAdapterCookBook.RecipeViewHolder> {

    private ArrayList<Recipe> recipes;
    // images fæst úr recipes arraylist þegar Recipe Object er tilbúinn
    private String[] images;

    private Context context;

    public RecyclerAdapterCookBook(ArrayList<Recipe>r, Context c) {
        recipes = r;
        context = c;
        images = new String[r.size()];
        for(int i=0; i<r.size(); i++){
            images[i]=r.get(i).getImage();
        }
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView title;
        Context context;
        ArrayList<Recipe> recipes;
        String[] images;

        public RecipeViewHolder(View v, Context c, ArrayList<Recipe> r, String[] i) {
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
            recipeViewIntent.putExtra("recipeTitle", recipes.get(getAdapterPosition()).getTitle());
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
        holder.title.setText(recipes.get(position).getTitle());


        /*
        holder.image.setImageResource(recipes.get(position).getImage();
        */
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
