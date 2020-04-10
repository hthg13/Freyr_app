package com.example.client.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.client.data.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User param);

    @Query("DELETE FROM user_table WHERE mUserName = :param")
    void deleteUser(String param);

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();
}
