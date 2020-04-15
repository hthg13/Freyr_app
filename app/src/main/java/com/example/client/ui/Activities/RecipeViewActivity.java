package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class RecipeViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button addFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        imageView = findViewById(R.id.recipeImage);
        textView = findViewById(R.id.recipeTitle);
        addFav = findViewById(R.id.addFav);


        Recipe recipe = getIntent().getParcelableExtra("recipe");
        setImageView(recipe.getImage());
        textView.setText(recipe.getTitle());


        String from = getIntent().getExtras().getString("from");
        if(from.equals("search")){
            addFav.setVisibility(View.VISIBLE);

        }
        else {
            addFav.setVisibility(View.INVISIBLE);
        }


    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void setImageView(String s){
        Picasso.get()
                .load(s)
                .error(R.drawable.mynd)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                    }

                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getApplicationContext(), "An error occurred loading image", Toast.LENGTH_SHORT).show();
                    }

                });
    }

}
