package com.example.client.ui.signup_and_login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.client.data.Repositories.UserRepository;
import com.example.client.data.entities.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

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

    /**
     * inserts new user to usertable
     * @param user
     */
    public void insert(User user) {
        mUserRepository.insertUser(user);
    }

    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    /**
     * deletes a specific user
     * @param user
     */
    public void delete(User user) {
        mUserRepository.deleteUser(user);
    }

    /**
     * used to update the cookbookid that represents the cookbook that the user owns
     * cookbookid is initially 0
     * @param cookbookid id of the cookbook to be linked with the session user
     * @param userid session user id
     */
    public void updateUserCookbookId(int cookbookid, long userid) {
        mUserRepository.updateUserCookbookId(cookbookid,userid);
    }

    /**
     * used to update the scheduleid that represents the schedule that the user owns
     * scheduleid is initially 0
     * @param scheduleid id of the cookbook to be linked with the session user
     * @param userid session user id
     */
    public void updateUserScheduleId(int scheduleid, long userid) {
        mUserRepository.updateUserCookbookId(scheduleid,userid);
    }

    /**
     * used to update the shoppinglistid that represents the shoppinglist that the user owns
     * scheduleid is initially 0
     * @param shoppinglistid id of the shoppinglist to be linked with the session user
     * @param userid session user id
     */
    public void updateUserShoppingListId(int shoppinglistid, long userid) {
        mUserRepository.updateUserCookbookId(shoppinglistid,userid);
    }

    /**
     * used to update the email that represents the email that the user owns
     * @param email id of the shoppinglist to be linked with the session user
     * @param userid session user id
     */
    public void updateUserEmail(String email, long userid) {
        mUserRepository.updateUserEmail(email, userid);
    }

    /**
     * returns a User entity with the session user username
     * @param username
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public User getUserInfoByName(String username) throws ExecutionException, InterruptedException {
        return mUserRepository.getUserInfoByName(username);
    }
}
