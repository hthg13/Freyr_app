package com.example.client.ui.signup_and_login;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.client.R;
import com.example.client.ui.profile.ProfileViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ProfileViewModel mProfileViewModel;
    private boolean validInput;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(LoginActivity.this).get(LoginViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final boolean[] validName = new boolean[1];
        final boolean[] validPassword = new boolean[1];

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (String.valueOf(passwordEditText.getText()).isEmpty()) {
                    passwordEditText.setError("Enter password");
                    validPassword[0] = false;
                } else {
                    validPassword[0] = true;
                }

                if (String.valueOf(usernameEditText.getText()).isEmpty()) {
                    usernameEditText.setError("Enter user name");
                    validName[0] = false;
                } else {
                    validName[0] = true;
                }

                // todo does password match given username?

                if (validPassword[0] && validName[0]) {
                    finish();
                }
            }
        });
    }
}
