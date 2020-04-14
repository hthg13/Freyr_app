package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterSearch;

import android.os.Bundle;

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

        // Test data
        String image = "https://i.imgur.com/DvpvklR.png";
        Recipe las = new Recipe("Lasagna",1234, image);
        Recipe burg = new Recipe("Burger",1345, image);


        ArrayList<Recipe> a = new ArrayList<>();
        a.add(las);
        a.add(burg);
        mAdapter = new RecyclerAdapterSearch(a,this);
        recyclerView.setAdapter(mAdapter);

    }
}
