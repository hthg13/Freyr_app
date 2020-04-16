package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterSearch;
import com.example.client.utilities.RecipeMapper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        ArrayList<Recipe> rs = new ArrayList<>();
        Bundle b = this.getIntent().getExtras();
        System.out.println();
        if(b!=null)
            rs = getIntent().getParcelableArrayListExtra("recipes");
        System.out.println(rs.size());

        mAdapter = new RecyclerAdapterSearch(rs,this);
        recyclerView.setAdapter(mAdapter);


    }
}
