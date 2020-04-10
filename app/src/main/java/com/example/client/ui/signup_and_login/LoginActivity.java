package com.example.client.ui.signup_and_login;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.client.R;
import com.example.client.data.entities.User;
import com.example.client.utilities.TokenStore;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    private static final String TOKEN_PREFERENCE = "TOKEN_PREFERENCE";
    SharedPreferences mSharedPreferences;

    private UserViewModel mLoginViewModel;
    private boolean validInput;
    private List<User> allUsers;
    private int SIGNUPORLOGIN_REQUEST_CODE = 0;
    private boolean mExists;
    private boolean mMatch;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginViewModel = ViewModelProviders.of(LoginActivity.this).get(UserViewModel.class);

        setAllUsers(mLoginViewModel.getAllUsers().getValue());

        mSharedPreferences = getSharedPreferences(TOKEN_PREFERENCE, Context.MODE_PRIVATE);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final boolean[] validName = new boolean[1];
        final boolean[] validPassword = new boolean[1];

        mLoginViewModel.getAllUsers().observe(LoginActivity.this, new Observer<List<User>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onChanged(List<User> users) {
                setAllUsers(users);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enteredUserName = String.valueOf(usernameEditText.getText());
                String enteredPassword = String.valueOf(passwordEditText.getText());

                // check if username exists and if it has been filled out
                if (String.valueOf(usernameEditText.getText()).isEmpty()) {
                    usernameEditText.setError("Enter user name");
                    validName[0] = false;
                } else if (!doesNameExist(enteredUserName)) {
                    usernameEditText.setError("User name does not exist");
                    validName[0] = false;
                } else {
                    validName[0] = true;
                }

                if (String.valueOf(passwordEditText.getText()).isEmpty()) {
                    passwordEditText.setError("Enter password");
                    validPassword[0] = false;
                } else if (!doesUnameMatchPassw(enteredPassword,enteredUserName)) {
                    passwordEditText.setError("Incorrect password");
                    validPassword[0] = false;
                }else {
                    validPassword[0] = true;
                }


                if (validPassword[0] && validName[0]) {
                    User user = null;
                    try {
                        user = mLoginViewModel.getUserInfoByName(enteredUserName);
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    TokenStore.storeUser(mSharedPreferences, user);
                    finish();
                }
            }
        });
    }

    /*
     * change behaviour of the back button and return to signup or login page
     */
    @Override
    public void onBackPressed() {
        Intent activitySignupOrLogin = new Intent(this, SignupOrLoginActivity.class);
        startActivityForResult(activitySignupOrLogin, SIGNUPORLOGIN_REQUEST_CODE);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    private boolean doesNameExist(final String enteredUserName) {
        List<User> userName = getAllUsers();
        for (int i = 0; i<userName.size(); i++) {
            if (enteredUserName.equals(userName.get(i).getUserName())) {
                setExists(true);
                break;
            }
            else setExists(false);
        }
        return getExists();
    }

    private boolean doesUnameMatchPassw(final String enteredPassword, final String enteredUserName) {
        List<User> users = getAllUsers();
        for (int i = 0; i<users.size(); i++) {
            if (enteredUserName.equals(users.get(i).getUserName())) {
                setMatch(users.get(i).getPassword().equals(enteredPassword));
                break;
            }
            else setMatch(false);
        }
        return isMatch();
    }

    private void setExists(boolean value){
        mExists = value;
    }

    private boolean getExists(){
        return mExists;
    }

    public boolean isMatch() {
        return mMatch;
    }

    public void setMatch(boolean match) {
        mMatch = match;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
}
