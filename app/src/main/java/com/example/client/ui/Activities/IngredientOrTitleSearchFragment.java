package com.example.client.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.client.R;
import com.example.client.ui.Activities.IngredientSearchPageOneActivity;
import com.example.client.ui.Activities.SearchActivity;
import com.example.client.ui.signup_and_login.UserViewModel;

public class IngredientOrTitleSearchFragment extends Fragment {

    private UserViewModel mProfileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mProfileViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ingredient_or_title_search, container, false);

        super.onCreate(savedInstanceState);

        Button searchByIngredients = (Button)root.findViewById(R.id.search_by_ingredients_page);
        Button searchByTitle = (Button)root.findViewById(R.id.search_by_title_page);

        searchByIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent results = new Intent(getActivity(), IngredientSearchPageOneActivity.class);
                IngredientOrTitleSearchFragment.this.startActivity(results);


            }
        });

        searchByTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent results = new Intent(getActivity(), SearchActivity.class);
                IngredientOrTitleSearchFragment.this.startActivity(results);


            }
        });

        return root;
    }
}
