package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.client.R;
import com.example.client.ui.Activities.Adapters.RecyclerAdapter;

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

        // Test data
        int mynd = R.drawable.mynd;
        int [] myndir = new int[2];
        myndir[0]=mynd;
        myndir[1]=mynd;
        ArrayList<String> a = new ArrayList<>();
        a.add("Lasagna");
        a.add("Burger");

        mAdapter = new RecyclerAdapter(a,myndir);
        recyclerView.setAdapter(mAdapter);
    }
}
