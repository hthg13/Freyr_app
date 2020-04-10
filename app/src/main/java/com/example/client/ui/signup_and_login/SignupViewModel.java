package com.example.client.ui.signup_and_login;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.client.data.Repositories.UserRepository;
import com.example.client.data.entities.User;

import java.util.List;

public class SignupViewModel extends AndroidViewModel{
    private UserRepository mUserRepository;
    private LiveData<List<User>> mAllUsers;
    private MutableLiveData<List<User>> searchResults;

    public SignupViewModel (Application application) {
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
}
