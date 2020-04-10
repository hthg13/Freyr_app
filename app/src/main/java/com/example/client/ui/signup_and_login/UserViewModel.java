package com.example.client.ui.signup_and_login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.client.data.Repositories.UserRepository;
import com.example.client.data.entities.User;

import java.util.List;

/**
 * performes as a viewModel for all these three ActivityClasses:
 * 1. SignupOrLoginActivity
 * 2. SignupActivity
 * 3. LoginActivity
 */
public class UserViewModel extends AndroidViewModel {

    private UserRepository mUserRepository;
    private LiveData<List<User>> mAllUsers;
    private MutableLiveData<List<User>> searchResults;

    public UserViewModel (Application application) {
        super(application);
        mUserRepository = new UserRepository(application);
        mAllUsers = mUserRepository.getAllUsers();
    }

    public void insert(User user) {
        mUserRepository.insertUser(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void updateUserEmail(String email, long userid) {
        mUserRepository.updateUserEmail(email, userid);
    }

    public void delete(User user) {
        mUserRepository.deleteUser(user);
    }

    public void updateUserCookbookId(int cookbookid, long userid) {
        mUserRepository.updateUserCookbookId(cookbookid,userid);
    }

    public void updateUserScheduleId(int scheduleid, long userid) {
        mUserRepository.updateUserCookbookId(scheduleid,userid);
    }

    public void updateUserShoppingListId(int shoppinglistid, long userid) {
        mUserRepository.updateUserCookbookId(shoppinglistid,userid);
    }
}
