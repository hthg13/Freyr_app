package com.example.client.data.entities;

import androidx.room.ColumnInfo;
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
    private int mCookbookId; //todo er ekki í lagi að vísa í id frekar en hlutinn? það er ekki hægt að geyma sérútbúna hluti í room db ...
    private int mScheduleId;
    private int mShoppingListId;

    public User(long id, String userName, String password) {
        this.mId = id;
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
}
