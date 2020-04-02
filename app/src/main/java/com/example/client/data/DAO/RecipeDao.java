package com.example.client.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.client.data.entities.Recipe;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface RecipeDao {

    @Insert
    void insert(Recipe recipe);
    @Delete
    void delete(Recipe recipe);
    @Update
    void update(Recipe recipe);
    @Query("SELECT * FROM recipe_table")
    List<Recipe> getAll();

}
