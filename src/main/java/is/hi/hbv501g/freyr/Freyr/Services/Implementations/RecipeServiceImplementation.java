package is.hi.hbv501g.freyr.Freyr.Services.Implementations;

import com.mashape.unirest.http.exceptions.UnirestException;
import is.hi.hbv501g.freyr.Freyr.Entities.Recipe;
import is.hi.hbv501g.freyr.Freyr.Repositories.RecipeRepository;
import is.hi.hbv501g.freyr.Freyr.Services.RecipeService;
import is.hi.hbv501g.freyr.Freyr.Utilities.RecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RecipeServiceImplementation implements RecipeService {

    RecipeRepository recipeRepo;
    RecipeMapper mapper = new RecipeMapper();
    List<Recipe> listInUse = new ArrayList<Recipe>();
    Recipe selectedRecipe;
    String search = "";

    @Autowired
    public RecipeServiceImplementation(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepo.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        recipeRepo.delete(recipe);
    }

    @Override
    public Recipe findById(Integer id) {
        return recipeRepo.findById(id).orElse(null);
    }

    @Override
    public ArrayList<Recipe> findAll() {
        return recipeRepo.findAll();
    }


    /*@Override
    public ArrayList<Recipe> findByUserId(Integer id){ return  recipeRepo.findByUserId(id);}*/


    public ArrayList<Recipe> getResultsSimple(String title, String type) throws UnirestException {
        this.listInUse = mapper.getResultsTitleType(title, type);
        return (ArrayList<Recipe>) this.listInUse;
    }

    public ArrayList<Recipe> getResultsIngredients(ArrayList<String> ingredients) throws UnirestException {
        this.listInUse = mapper.getResultsIngr(ingredients);
        return (ArrayList<Recipe>) this.listInUse;

    }


    @Override
    public void setSelectedRecipe(int i) {
        this.selectedRecipe = this.listInUse.get(i);
    }

    @Override
    public Recipe getSelectedRecipe(){
        return this.selectedRecipe;
    }

    @Override
    public void getDetails(Recipe recipe) throws UnirestException {
        this.mapper.getDetails(recipe);
    }

    @Override
    public void setSearch(String s){
        this.search=s;
    }

    @Override
    public String getSearch(){
        return this.search;
    }

    public ArrayList<Recipe> getListInUse(){
        return (ArrayList<Recipe>) this.listInUse;
    }
}
