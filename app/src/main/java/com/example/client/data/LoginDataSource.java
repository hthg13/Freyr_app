package com.example.client.data;

import android.util.Log;

import com.example.client.data.entities.User;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<User> login(String username, String password) {

        Log.d("helga", "username: " + username + " ,password: " + password);

        try {
            // TODO: handle loggedInUser authentication
            //User fakeUser = new User(username);
            User user = new User(1, username, password);

            int cookbookid = 1;

            user.setCookbookId(cookbookid);

            return new Result.Success<>(user);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
