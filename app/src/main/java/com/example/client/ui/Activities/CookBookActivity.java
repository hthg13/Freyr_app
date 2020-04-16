package com.example.client.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterCookBook;
import com.example.client.ui.notifications.NotificationsViewModel;
import com.example.client.ui.signup_and_login.UserViewModel;
import com.example.client.utilities.TokenStore;

import java.util.ArrayList;

public class CookBookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        //UserViewModel = ViewModelProviders.of(this).get(NotificationsViewModel.class);
       // View root = inflater.inflate(R.layout.activity_cook_book, container, false);

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
