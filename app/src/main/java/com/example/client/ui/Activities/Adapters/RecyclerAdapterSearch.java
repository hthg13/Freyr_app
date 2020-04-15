package com.example.client.ui.Activities.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.utilities.RecipeMapper;
import com.example.client.ui.Activities.RecipeViewActivity;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class RecyclerAdapterSearch extends RecyclerView.Adapter<RecyclerAdapterSearch.RecipeViewHolder> {

    private ArrayList<Recipe> recipes;
    // images fæst úr recipes arraylist þegar Recipe Object er tilbúinn

    private Context context;

    public RecyclerAdapterSearch(ArrayList<Recipe> r,  Context c) {
        recipes = r;
        context = c;
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView title;
        ImageView image;
        Context context;
        ArrayList<Recipe> recipes;
        RecipeMapper recipeMapper = new RecipeMapper();

        public RecipeViewHolder(View v, Context c, ArrayList<Recipe> r) {
            super(v);
            image = v.findViewById(R.id.vmynd);
            title = v.findViewById(R.id.vtitle);
            itemView.setOnClickListener(this);

            this.context = c;
            this.recipes = r;
        }

        @Override
        public void onClick(View v) {
            /*
            Todo bæta við upplsysingum sem a að birta með hverri uppskr
             */

            Intent recipeViewIntent= new Intent(this.context, RecipeViewActivity.class);
            Recipe r = null;
            System.out.println(recipes.get(getAdapterPosition()).getId());
            try {
                r = recipeMapper.getDetails(recipes.get(getAdapterPosition()));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (UnirestException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            recipeViewIntent.putExtra("recipe", r);
            recipeViewIntent.putExtra("from","search");
            this.context.startActivity(recipeViewIntent);


        }
    }


    @NonNull
    @Override
    public RecyclerAdapterSearch.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_view_layout, parent, false);

        RecipeViewHolder vh = new RecipeViewHolder(view, context, recipes);


        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterSearch.RecipeViewHolder holder, int position) {
        holder.title.setText(recipes.get(position).getTitle());

        Picasso.get()
                .load(recipes.get(position).getImage())
                .error(R.drawable.mynd)
                .into(holder.image, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(context.getApplicationContext(), "An error occurred loading image", Toast.LENGTH_SHORT).show();
                    }

                });

        /*
        holder.image.setImageResource(recipes.get(position).getImage();
         */
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
