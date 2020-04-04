package com.example.client.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * heldur utanum þau gögn sem fara í profile fragmentið
 */
public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private String text = "Username:";

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(text);
    }

    public LiveData<String> getText() {
        return mText;
    }

    /*public void setText(String text) {
        this.text = text;
    }*/
}