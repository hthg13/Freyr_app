package com.example.client.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.client.data.entities.CookBook;
import com.example.client.data.entities.Schedule;
import com.example.client.data.entities.ShoppingList;
@Entity(tableName = "user_table")
public class User {

    /*
    todo skoða one-to-one relationship við cookbook
     */
    @PrimaryKey(autoGenerate = true)
    private long mId;
    private String mUserName;
    private String mEmail;
    private String mPassword;
    //private CookBook mCookbook;
    //private Schedule mSchedule;
    //private ShoppingList mShoppingList;


    public User(long id, String userName) {
        this.mId = id;
        this.mUserName = userName;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    /*public CookBook getCookbook() {
        return mCookbook;
    }

    public void setCookbook(CookBook cookbook) {
        mCookbook = cookbook;
    }

    public Schedule getSchedule() {
        return mSchedule;
    }

    public void setSchedule(Schedule schedule) {
        mSchedule = schedule;
    }

    public ShoppingList getShoppingList() {
        return mShoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        mShoppingList = shoppingList;
    }*/
}
