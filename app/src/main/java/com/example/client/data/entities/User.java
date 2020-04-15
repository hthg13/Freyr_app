package com.example.client.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.client.data.entities.CookBook;
import com.example.client.data.entities.Schedule;
import com.example.client.data.entities.ShoppingList;

import java.util.ArrayList;
import java.util.List;

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
    private int mCookbookId;
    private int mScheduleId;
    private int mShoppingListId;

    @Ignore
    private ArrayList<Recipe> recipeList;

    public User(String userName, String password) {
        this.mUserName = userName;
        this.mPassword = password;
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

    public int getCookbookId() {
        return mCookbookId;
    }

    public void setCookbookId(int cookbookId) {
        mCookbookId = cookbookId;
    }

    public int getScheduleId() {
        return mScheduleId;
    }

    public void setScheduleId(int scheduleId) {
        mScheduleId = scheduleId;
    }

    public int getShoppingListId() {
        return mShoppingListId;
    }

    public void setShoppingListId(int shoppingListId) {
        mShoppingListId = shoppingListId;
    }

    @Override
    public String toString() {
        String username = this.mUserName;
        String password = this.mPassword;

        return "Username: " + username + ", Password: " + password;
    }
}
