package com.example.client.data.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.client.data.DAO.RecipeDao;
import com.example.client.data.DB.RecipeDataBase;
import com.example.client.data.entities.Recipe;

import java.util.ArrayList;

public class RecipeRepository {

    private RecipeDao recipeDao;
    private ArrayList<Recipe> allRecipes;

    public RecipeRepository(Application application){
        RecipeDataBase database = RecipeDataBase.getInstance(application);
        recipeDao = database.recipeDao();
        allRecipes = (ArrayList<Recipe>)recipeDao.getAll();
    }

    public void insert(Recipe recipe){
        new InsertRecipeAsyncTask(recipeDao).execute(recipe);
    }

    public void delete(Recipe recipe){
        new DeleteRecipeAsyncTask(recipeDao).execute(recipe);
    }

    public void update(Recipe recipe){
        new UpdateRecipeAsyncTask(recipeDao).execute(recipe);
    }

    public ArrayList getAll(){
        return allRecipes;
    }

    private static class InsertRecipeAsyncTask extends AsyncTask<Recipe,Void,Void>{
        private RecipeDao recipeDao;

        private InsertRecipeAsyncTask(RecipeDao recipeDao){
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes){
            recipeDao.insert(recipes[0]);
            return null;
        }
    }

    private static class DeleteRecipeAsyncTask extends AsyncTask<Recipe,Void,Void>{
        private RecipeDao recipeDao;

        private DeleteRecipeAsyncTask(RecipeDao recipeDao){
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes){
            recipeDao.delete(recipes[0]);
            return null;
        }
    }

    private static class UpdateRecipeAsyncTask extends AsyncTask<Recipe,Void,Void>{
        private RecipeDao recipeDao;

        private UpdateRecipeAsyncTask(RecipeDao recipeDao){
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes){
            recipeDao.update(recipes[0]);
            return null;
        }
    }

}
