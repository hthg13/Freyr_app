package com.example.client.data.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.client.data.DAO.RecipeDao;
import com.example.client.data.entities.Recipe;

@Database(entities = Recipe.class, version = 1)
public abstract class RecipeDataBase extends RoomDatabase {

    private static RecipeDataBase instance;

    public abstract RecipeDao recipeDao();

    public static synchronized RecipeDataBase getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), RecipeDataBase.class, "recipe_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
