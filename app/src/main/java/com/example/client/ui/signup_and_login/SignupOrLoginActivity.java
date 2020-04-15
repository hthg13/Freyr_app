package com.example.client.ui.signup_and_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.client.R;


/**
 * Determines if the user pushes login or signup on the start screen and
 * passes on a string witch one was chosen back to main activity
 */
public class SignupOrLoginActivity extends AppCompatActivity {

    private UserViewModel mSignupOrLoginViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuporlogin);
        mSignupOrLoginViewModel = ViewModelProviders.of(SignupOrLoginActivity.this).get(UserViewModel.class);

        final Button loginButton = findViewById(R.id.login);
        final Button signupButton = findViewById(R.id.signup);
        final String[] logorsign = new String[1];

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logorsign[0] = "login";
                Intent intent = new Intent();
                intent.putExtra("hello", logorsign[0]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logorsign[0] = "signup";
                Intent intent = new Intent();
                intent.putExtra("hello", logorsign[0]);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }


}
