package is.hi.hbv501g.freyr.Freyr.Services;

import com.mashape.unirest.http.exceptions.UnirestException;
import is.hi.hbv501g.freyr.Freyr.Entities.Recipe;

import java.util.ArrayList;

public interface RecipeService {

    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    Recipe findById(Integer id);
    ArrayList<Recipe> findAll();
    //ArrayList<Recipe> findByUserId(Integer id);
    ArrayList<Recipe> getResultsSimple(String title, String type) throws UnirestException;
    ArrayList<Recipe> getResultsIngredients(ArrayList<String> ingredients) throws UnirestException;
    void getDetails(Recipe recipe) throws UnirestException;
    void setSelectedRecipe(int i);
    Recipe getSelectedRecipe();
    String getSearch();
    void setSearch(String s);
    ArrayList<Recipe> getListInUse();
}
