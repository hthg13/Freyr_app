package com.example.client.ui.signup_and_login;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.client.R;
import com.example.client.data.Repositories.UserRepository;
import com.example.client.data.entities.User;

import java.util.List;
import java.util.Objects;

public class SignupActivity extends AppCompatActivity {
    private SignupViewModel mSignupViewModel;
    private UserRepository mUserRepository;

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

                // TODO HANDLE PASSWORD CHECK IF SAME AS FIRST ONE
                /*
                if (String.valueOf(passwordEditText2.getText()).isEmpty()) {
                    passwordEditText2.setError("Enter user name");
                    validName[0] = false;
                } else {
                    validName[0] = true;
                }
                */

                if (String.valueOf(usernameEditText.getText()).isEmpty()) {
                    usernameEditText.setError("Enter user name");
                    validName[0] = false;
                } else {
                    validName[0] = true;
                }
                
                // TODO SINGUP LOGIC
                // todo does username exist else create user and login?
                if (validPassword[0] && validName[0]) {
                    User user = new User(usernameEditText.getText().toString(), passwordEditText.getText().toString());

                    mSignupViewModel.insert(user);

                    Log.d("helga: ", user.toString());

                    //Log.d("helga: ", "all users: " + users.getValue());

                    finish();
                }
            }
        });

        /*
         * prentar út id og notendanafn allra notendanna
         */
        mSignupViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onChanged(List<User> users) {
                List<User> userName = Objects.requireNonNull(users);

                for (int i = 0; i<users.size(); i++) {
                    Log.d("helga", "user number " + i + " has id " + userName.get(i).getId() + " and username " + userName.get(i).getUserName());
                }
            }
        });
    }
}
