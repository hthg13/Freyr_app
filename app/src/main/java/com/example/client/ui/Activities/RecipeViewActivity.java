package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.client.data.entities.User;
import com.example.client.ui.signup_and_login.LoginActivity;
import com.example.client.ui.signup_and_login.UserViewModel;
import com.example.client.utilities.TokenStore;
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
    TextView title;
    TextView instructions;
    TextView ingr;
    Button addFav;

    private SharedPreferences mSharedPreferences;
    public static final String TOKEN_PREFERENCE = "TOKEN_PREFERENCE";
    private UserViewModel mUserViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);
/*
        mUserViewModel = ViewModelProviders.of(RecipeViewActivity.this).get(UserViewModel.class);
        mSharedPreferences = getSharedPreferences(TOKEN_PREFERENCE, Context.MODE_PRIVATE);
        String sessionUser = TokenStore.getUserName(mSharedPreferences);
        User user = null;

        try {
            user = mUserViewModel.getUserInfoByName(sessionUser);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //cbid = user.getCookbookId();
*/
        imageView = findViewById(R.id.recipeImage);
        title = findViewById(R.id.recipeTitle);
        instructions = findViewById(R.id.instructions);
        ingr = findViewById(R.id.ingrList);
        addFav = findViewById(R.id.addFav);


        final Recipe recipe = getIntent().getParcelableExtra("recipe");

        setImageView(recipe.getImage());
        title.setText(recipe.getTitle());
        instructions.setText(recipe.getInstructions());
        System.out.println(recipe.getIngredients().size()+"HALLO");
        ingr.setText(this.ingrToList(recipe.getIngredients()));




        String from = getIntent().getExtras().getString("from");
        if(from.equals("search")){
            addFav.setVisibility(View.VISIBLE);

            addFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TokenStore.addRecipe(recipe);
                    addFav.setVisibility(View.INVISIBLE);

                }
            });

        }
        else {
            addFav.setVisibility(View.INVISIBLE);
        }


    }

    private String ingrToList(ArrayList<String> ingr){

        String ret = "";
        for(int i=0; i<ingr.size(); i++){
            ret +=ingr.get(i)+"\n";

        }
        return ret;
    }

    private void setImageView(String s){
        Picasso.get()
                .load(s)
                .error(R.drawable.foodlove)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("TAG", "onSuccess");
                    }

                    @Override
                    public void onError(Exception e) {

                    }

                });
    }

}
