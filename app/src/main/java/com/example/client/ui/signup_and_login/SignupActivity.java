package com.example.client.ui.signup_and_login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.client.R;

public class SignupActivity extends AppCompatActivity {
    private SignupViewModel mSignupViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mSignupViewModel = ViewModelProviders.of(SignupActivity.this).get(SignupViewModel.class);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final EditText passwordEditText2 = findViewById(R.id.password3);

        final Button signupButton = findViewById(R.id.login);
        final boolean[] validName = new boolean[1];
        final boolean[] validPassword = new boolean[1];

        signupButton.setOnClickListener(new View.OnClickListener() {
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

                // todo does username exist else create user and login?

                if (validPassword[0] && validName[0]) {
                    finish();
                }
            }
        });
    }
}
