package com.example.client.data.DAO;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.client.data.entities.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);
}
