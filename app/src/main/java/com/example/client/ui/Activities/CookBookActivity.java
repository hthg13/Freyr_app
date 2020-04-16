package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterCookBook;
import com.example.client.utilities.TokenStore;

import java.util.ArrayList;

public class CookBookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_book);
        
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        mAdapter = new RecyclerAdapterCookBook(TokenStore.getRecipes(),this);
        recyclerView.setAdapter(mAdapter);
    }
}
