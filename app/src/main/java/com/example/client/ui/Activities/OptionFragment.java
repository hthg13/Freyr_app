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

public class OptionFragment extends Fragment {

    private UserViewModel mProfileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mProfileViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_options, container, false);

        super.onCreate(savedInstanceState);

        Button cookbook = (Button)root.findViewById(R.id.get_cookbook);
        Button createRecipie = (Button)root.findViewById(R.id.get_createRecipie);
        Button shoppinglist = (Button)root.findViewById(R.id.get_shoppinglist);


        cookbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent results = new Intent(getActivity(), CookBookActivity.class);
                OptionFragment.this.startActivity(results);


            }
        });

        createRecipie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent results = new Intent(getActivity(), CreateRecipeActivity.class);
                OptionFragment.this.startActivity(results);


            }
        });

        shoppinglist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent results = new Intent(getActivity(), ShoppingListActivity.class);
                OptionFragment.this.startActivity(results);


            }
        });


        return root;
    }
}
