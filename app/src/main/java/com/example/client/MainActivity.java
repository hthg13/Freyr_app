package com.example.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.client.ui.Activities.CookBookActivity;
import com.example.client.ui.Activities.CreateRecipeActivity;
import com.example.client.ui.Activities.IngredientOrTitleSearchActivity;
import com.example.client.ui.Activities.IngredientSearchPageOneActivity;
import com.example.client.ui.signup_and_login.LoginActivity;
import com.example.client.ui.signup_and_login.SignupActivity;
import com.example.client.ui.signup_and_login.SignupOrLoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private int SIGNUPORLOGIN_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // start by checking if the user wants to login or signup to the app
        Intent activitySignupOrLogin = new Intent(this, SignupOrLoginActivity.class);
        startActivityForResult(activitySignupOrLogin, SIGNUPORLOGIN_REQUEST_CODE);
    }

    /*
     * activated after signuporloginactivity returns result from user
     * either the user wants to login or signup
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SIGNUPORLOGIN_REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                String returnString = data.getStringExtra("hello");

                if (returnString.equals("login")) {
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                } else {
                    Intent i = new Intent(this, SignupActivity.class);
                    startActivity(i);
                }

                // starts the navigation view after successfull login or signup
                startNavigation();

                // creates temporary buttons from þorsteinn
                // todo remove
                createTempButtons();
            }
        }
    }

    private void createTempButtons() {
        //
        // Til að geta prófað cookbook og create
        //
        Button button = (Button)findViewById(R.id.temp);
            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cookbook = new Intent(MainActivity.this, CookBookActivity.class);
                MainActivity.this.startActivity(cookbook);
            }
        });

        Button button2 = (Button)findViewById(R.id.temp2);
            button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(MainActivity.this, CreateRecipeActivity.class);
                MainActivity.this.startActivity(create);
            }
        });

        Button button3 = (Button)findViewById(R.id.temp3);
            button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent(MainActivity.this, IngredientOrTitleSearchActivity.class);
                MainActivity.this.startActivity(create);
            }
        });
    }


    public void startNavigation() {
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}
