package com.example.client.ui.signup_and_login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.client.R;
import com.example.client.data.Repositories.UserRepository;
import com.example.client.data.entities.User;
import com.example.client.utilities.TokenStore;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class SignupActivity extends AppCompatActivity {
    private UserViewModel mSignupViewModel;
    private UserRepository mUserRepository;
    private User mCurrentUser;
    private boolean mExists;
    private List<User> allUsers;
    private int SIGNUPORLOGIN_REQUEST_CODE = 0;

    private static final String TOKEN_PREFERENCE = "TOKEN_PREFERENCE";
    SharedPreferences mSharedPreferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mSignupViewModel = ViewModelProviders.of(SignupActivity.this).get(UserViewModel.class);
        mSharedPreferences = getSharedPreferences(TOKEN_PREFERENCE, Context.MODE_PRIVATE);

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText1 = findViewById(R.id.password);
        final EditText passwordEditText2 = findViewById(R.id.password3);

        final Button signupButton = findViewById(R.id.login);
        final boolean[] validName = new boolean[1];
        final boolean[] validPassword1 = new boolean[1];
        final boolean[] validPassword2 = new boolean[1];

        setAllUsers(mSignupViewModel.getAllUsers().getValue());

        mSignupViewModel.getAllUsers().observe(SignupActivity.this, new Observer<List<User>>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onChanged(List<User> users) {
                setAllUsers(users);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String enteredUserName = String.valueOf(usernameEditText.getText());
                final String enteredUserPassword1 = String.valueOf(passwordEditText1.getText());
                final String enteredUserPassword2 = String.valueOf(passwordEditText2.getText());

                // check if password1 has been entered or not
                if (String.valueOf(passwordEditText1.getText()).isEmpty()) {
                    passwordEditText1.setError("Enter password");
                    validPassword1[0] = false;
                } else {
                    validPassword1[0] = true;
                }

                // check if password2 has been entered or not and if it matches password1
                if (String.valueOf(passwordEditText2.getText()).isEmpty()) {
                    passwordEditText2.setError("Repeat password");
                    validPassword2[0] = false;
                } else if (!enteredUserPassword2.equals(enteredUserPassword1)) {
                    passwordEditText2.setError("Repeated password does not match password");
                    validPassword2[0] = false;
                } else {
                    validPassword2[0] = true;
                }

                // check if username has been entered or not and if it already exist in db
                if (String.valueOf(usernameEditText.getText()).isEmpty()) {
                    usernameEditText.setError("Enter user name");
                    validName[0] = false;
                } else if (doesNameExist(enteredUserName)){
                    usernameEditText.setError("User name already exists");
                    validName[0] = false;
                } else {
                    validName[0] = true;
                }

                // if all criteria is matched then write user to db and return to main activity
                if (validPassword1[0] && validPassword2[0] && validName[0]) {
                    User user = new User(usernameEditText.getText().toString(), passwordEditText1.getText().toString());
                    mSignupViewModel.insert(user);

                    try {
                        user = mSignupViewModel.getUserInfoByName(enteredUserName);
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
            }
            else setExists(false);
        }
        return getExists();
    }

    private void setExists(boolean value){
        mExists = value;
    }

    private boolean getExists(){
        return mExists;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

}
