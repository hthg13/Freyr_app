package com.example.client.data.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.client.data.DAO.UserDao;
import com.example.client.data.entities.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao mUserDao();
    private static UserDatabase INSTANCE;

    public static UserDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {

            synchronized (UserDatabase.class) {

                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(
                            context, UserDatabase.class, "USER_DATABASE")
                            .fallbackToDestructiveMigration()
                            .build();

                }

            }

        }

        return INSTANCE;

    }

}
