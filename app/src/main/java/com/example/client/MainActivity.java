package com.example.client;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.client.entities.User;
import com.example.client.ui.Activities.CookBookActivity;
import com.example.client.ui.Activities.CreateRecipeActivity;
import com.example.client.ui.Activities.LogInActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    // TODO: remove
    private static final String LOG_TAG = "Helga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent activityIntent;

        startNavigation();


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

        // TODO: remove
        Log.d(MainActivity.LOG_TAG, LogInActivity.testLoginActivity());
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
