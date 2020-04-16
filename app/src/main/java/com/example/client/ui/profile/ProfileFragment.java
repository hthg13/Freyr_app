package com.example.client.ui.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.client.MainActivity;
import com.example.client.R;
import com.example.client.data.entities.User;
import com.example.client.ui.Activities.CookBookActivity;
import com.example.client.ui.Activities.CreateRecipeActivity;
import com.example.client.ui.Activities.ShoppingListActivity;
import com.example.client.ui.signup_and_login.UserViewModel;
import com.example.client.utilities.TokenStore;

import java.util.List;

/**
 * Setur upp síðuna profile þeas setur inn texta ofl
 */
public class ProfileFragment extends Fragment {

    private UserViewModel mProfileViewModel;
    private String mUser;

    private SharedPreferences mSharedPreferences;
    public static final String TOKEN_PREFERENCE = "TOKEN_PREFERENCE";


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mProfileViewModel = ViewModelProviders.of(ProfileFragment.this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        mSharedPreferences = this.getActivity().getSharedPreferences(TOKEN_PREFERENCE, Context.MODE_PRIVATE);

        final TextView userNameView = root.findViewById(R.id.textView15);
        final TextView userPasswordView = root.findViewById(R.id.textView20);
        final TextView userIdView = root.findViewById(R.id.textView17);

        String sessionUserName = TokenStore.getUserName(mSharedPreferences);
        String sessionUserPW = TokenStore.getUserPw(mSharedPreferences);
        String sessionuserID = String.valueOf(TokenStore.getUserId(mSharedPreferences));

        userNameView.setText(sessionUserName);
        userPasswordView.setText(sessionUserPW);
        userIdView.setText(sessionuserID);

        Button button = (Button)root.findViewById(R.id.cb);
        //button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cookbook = new Intent(getActivity(), CookBookActivity.class);
                ProfileFragment.this.startActivity(cookbook);
            }


        });

        Button button2 = (Button)root.findViewById(R.id.cr);
        //button2.setVisibility(View.INVISIBLE);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(getActivity(), CreateRecipeActivity.class);
                ProfileFragment.this.startActivity(create);
            }
        });

        Button button3 = (Button)root.findViewById(R.id.sl);
        //button2.setVisibility(View.INVISIBLE);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(getActivity(), ShoppingListActivity.class);
                ProfileFragment.this.startActivity(create);
            }
        });

        return root;
    }

}