package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.client.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RecipeViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);


        imageView = findViewById(R.id.recipeImage);
        textView = findViewById(R.id.recipeTitle);

        String s = getIntent().getStringExtra("recipeImage");
        setImageView(s);
        textView.setText(getIntent().getCharSequenceExtra("recipeTitle"));

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
