package com.example.client.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.client.data.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User param);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();

    @Query("UPDATE user_table set mEmail = :email where mId = :userid")
    void updateUserEmail(String email, long userid);

    @Query("UPDATE user_table set mCookbookId = :cookbookid where mId = :userid")
    void updateUserCookbookId(int cookbookid, long userid);

    @Query("UPDATE user_table set mScheduleId = :scheduleid where mId = :userid")
    void updateUserScheduleId(int scheduleid, long userid);

    @Query("UPDATE user_table set mShoppingListId = :shoppinglistid where mId = :userid")
    void updateUserShoppingListId(int shoppinglistid, long userid);

    @Query("SELECT mUserName, mId, mPassword, mCookbookId, mScheduleId, mShoppingListId FROM user_table where mUserName=:username")
    User getUserInfoByName(String username);
}
