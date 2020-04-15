package com.example.client.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.MainActivity;
import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterCookBook;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterSearch;
import com.example.client.ui.Activities.IngredientSearchPageTwoActivity;

import java.util.ArrayList;
import java.util.List;

public class IngredientOrTitleSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_or_title_search);

        Button searchByIngredients = (Button)findViewById(R.id.search_by_ingredients_page);
        Button searchByTitle = (Button)findViewById(R.id.search_by_title_page);

        searchByIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent results = new Intent(IngredientOrTitleSearchActivity.this, IngredientSearchPageOneActivity.class);
                IngredientOrTitleSearchActivity.this.startActivity(results);


            }
        });

        searchByTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent results = new Intent(IngredientOrTitleSearchActivity.this, SearchActivity.class);
                IngredientOrTitleSearchActivity.this.startActivity(results);


            }
        });
    }
}
