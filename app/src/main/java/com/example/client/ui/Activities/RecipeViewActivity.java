package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.client.R;

public class RecipeViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        imageView = findViewById(R.id.recipeImage);
        textView = findViewById(R.id.recipeTitle);

        imageView.setImageResource(getIntent().getIntExtra("recipeImage",0));
        textView.setText(getIntent().getCharSequenceExtra("recipeTitle"));
    }
}
