package is.hi.hbv501g.freyr.Freyr.Controllers;

import com.mashape.unirest.http.exceptions.UnirestException;
import is.hi.hbv501g.freyr.Freyr.Entities.Recipe;
import is.hi.hbv501g.freyr.Freyr.Entities.User;
import is.hi.hbv501g.freyr.Freyr.Services.RecipeService;
import is.hi.hbv501g.freyr.Freyr.Services.UserService;
import is.hi.hbv501g.freyr.Freyr.Utilities.addListsToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import is.hi.hbv501g.freyr.Freyr.Utilities.AlertsToUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class recipeController {

    private RecipeService recServ;
    private AlertsToUser alertsToUser = new AlertsToUser(); // this is one of the utilities classes
    private UserService userService;

    @Autowired
    public recipeController(RecipeService recipeServices, UserService userService){
        this.recServ = recipeServices;
        this.userService = userService;
    }

    // sets up the basic home page
    @RequestMapping("/")
    public String Home(Model model, HttpSession session){
        if(session.getAttribute("LoggedInUser") != null){
            model.addAttribute("loggedinuser",session.getAttribute("LoggedInUser"));
            return "home";
        }
        model.addAttribute("loggedinuser", null);
        return "home";
    }

    // shows in detail the recipe that was clicked
    @RequestMapping(value="/recipe", method=RequestMethod.GET)
    public String recipeInformation( Recipe clickedRecipe, Model model, HttpSession session){
        // get the session user (the logged in user)
        User sessionUser = (User) session.getAttribute("LoggedInUser");

        // get the clicked recipe
        clickedRecipe = recServ.getSelectedRecipe();

        // notify the user if not logged in with a message
        String message = alertsToUser.messageLogin(sessionUser);
        model.addAttribute("message", message);

        // setup the recipe for html
        model.addAttribute("recipe", clickedRecipe);

        return "recipe";
    }

    // shows in detail the recipe that was clicked
    // if the user wishes to save the recipe to favorites
    // the method will save that recipe and it will be
    // accessible in a list of the users favorite recipes
    @RequestMapping(value="/recipe", method=RequestMethod.POST)
    public String addToFavorites(@Valid Recipe recipe, BindingResult result, Model model, HttpSession session)  {
        // get the session user (the logged in user)
        User sessionUser = (User) session.getAttribute("LoggedInUser");

        // notify the user if not logged in
        String message = alertsToUser.messageLogin(sessionUser);
        model.addAttribute("message", message);

        // if user is logged in and has not saved the recipe to favorites already
        // we add the recipe to favorites
        if (sessionUser != null) {
            recipe = recServ.getSelectedRecipe();

            if(result.hasErrors()){
                return "recipe";
            }

            boolean alreadySaved = false;

            for (int i = 0; i < sessionUser.getFavorite().size(); i++) {                    //check all of users favorite recipes
                if (sessionUser.getFavorite().get(i).equals(recipe.getId())) {              //if any user favorite id equals recipe id
                    alreadySaved = true;                                                    //the user already has saved the recipe so dont save again
                }
            }

            if (!alreadySaved) {                                                            // if not saved to favorites
                sessionUser = userService.updateFavorite(sessionUser, recipe.getId());      // update user favorites in user database
                session.setAttribute("LoggedInUser", sessionUser);                      // update user favorites in session
            }

            Recipe exists = recServ.findById(recipe.getId());
            if (exists == null) {                                                       // if recipe does not exist in recipe database
                recipe = recServ.save(recipe);                                          // add recipe to recipe database
            }
            // setup the recipe for html
            model.addAttribute("recipe", recipe);
        }

        // redirect to the recipe page
        return "redirect:/recipe";
    }

    // býr til gerfi recipe hlut
    public Recipe createFakeRecipe(){
        Recipe clickedRecipe = new Recipe();
        clickedRecipe.setId(1);
        clickedRecipe.setTitle("Lasagne");
        clickedRecipe.setIngredients("pasta");
        clickedRecipe.setIngredients("tomatoes");
        clickedRecipe.setInstructions("some text some text some text some text some text some text some text some text some text some text some text some text some text some text");
        clickedRecipe.setReadyInMinutes(10);
        clickedRecipe.setServings(3);
        clickedRecipe.setRating(5.0);
        clickedRecipe.setImage("https://images.pexels.com/photos/2765875/pexels-photo-2765875.jpeg?cs=srgb&dl=baked-close-up-creamy-2765875.jpg&fm=jpg");
        return clickedRecipe;
    }

    // sets up and shows all favorite recipes of the user
    // if there are no favorite recipes the page will say so
    @RequestMapping(value="/favoriteRecipes", method=RequestMethod.GET)
    public String favoriteRecipe(Model model,  HttpSession session){
        // get the session user (the logged in user)
        User sessionUser = (User) session.getAttribute("LoggedInUser");

        // setup an array for possible recipes that the user has saved
        ArrayList<Recipe> recipes = new ArrayList<>();

        if(sessionUser == null) {                                                   // no one is logged in
            model.addAttribute("recipes", null);                            // display no recipes
        } else {
            for(int i=0; i<sessionUser.getFavorite().size(); i++) {
                recipes.add(recServ.findById(sessionUser.getFavorite().get(i)));    // get the recipes with the id-s the user has added to favorites
            }
            model.addAttribute("recipes", recipes);
        }

        return "/favoriteRecipes";
    }

    @RequestMapping(value="ingredientSearch", method=RequestMethod.GET)
    public String ingredientSearch(Model model){
        addListsToModel.ingredientsToModel(model);
        return "ingredientSearch";
    }

    @RequestMapping(value="ingredientSearch", method=RequestMethod.POST)
    public String IngredientSearch(@RequestParam(required = false, value = "index") String index, @RequestParam(name = "vegetables", required = false)String[] vegetables, @RequestParam(name = "fruits", required = false)String[] fruits, @RequestParam(name = "dairyAndAlternatives", required = false)String[] dairyAndAlternatives, @RequestParam(name = "meats", required = false)String[] meats,
                                   @RequestParam(name = "seafoodAndFish", required = false)String[] seafoodAndFish, @RequestParam(name = "nuts", required = false)String[] nuts, @RequestParam(name = "grainsAndBaking", required = false)String[] grainsAndBaking, @RequestParam(name = "oils", required = false)String[] oils, @RequestParam(name = "sweets", required = false)String[] sweets, Model model)
    throws UnirestException{

        addListsToModel.ingredientsToModel(model);
        ArrayList<String> combinedIngredients = new ArrayList<String>();

        if(vegetables != null) combinedIngredients.addAll(Arrays.asList(vegetables));
        if(fruits != null) combinedIngredients.addAll(Arrays.asList(fruits));
        if(dairyAndAlternatives != null) combinedIngredients.addAll(Arrays.asList(dairyAndAlternatives));
        if(oils != null) combinedIngredients.addAll(Arrays.asList(oils));
        if(seafoodAndFish != null) combinedIngredients.addAll(Arrays.asList(seafoodAndFish));
        if(meats != null) combinedIngredients.addAll(Arrays.asList(meats));
        if(sweets != null) combinedIngredients.addAll(Arrays.asList(sweets));
        if(nuts != null) combinedIngredients.addAll(Arrays.asList(nuts));
        if(grainsAndBaking != null) combinedIngredients.addAll(Arrays.asList(grainsAndBaking));

        if(combinedIngredients != null){
            if (combinedIngredients.size() > 0) {
                if(combinedIngredients.equals(recServ.getSearch())){
                    model.addAttribute("recipes",recServ.getListInUse());
                }else{
                    ArrayList resultList = recServ.getResultsIngredients(combinedIngredients);
                    System.out.println("resList: " +resultList);
                    if(resultList.size() > 0){
                        model.addAttribute("recipes", resultList);
                    } else{
                        model.addAttribute("recipes", "-1");
                    }
                }
            }

            if (index != null) {
                recServ.setSelectedRecipe(Integer.parseInt(index));
                if (recServ.getSelectedRecipe().getFullInfo() == false ) {
                    recServ.getDetails(recServ.getSelectedRecipe());
                    recServ.getSelectedRecipe().setFullInfo();
                }
                return "redirect:/recipe";
            }
        }

        return "ingredientSearch";
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String Searched(Model model){
        addListsToModel.mealKindsToModel(model);
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(required = false, value = "index") String
                                     index, @RequestParam(required = false, value = "foodType") String foodType, @RequestParam(name = "mealKinds", required = false) String mealKind, Model model) throws
            UnirestException {

        addListsToModel.mealKindsToModel(model);

        if (foodType.length() > 0) {
            ArrayList resultList = recServ.getResultsSimple(foodType, mealKind);
            if(resultList.size() > 0){
                model.addAttribute("recipes", resultList);
            }
            else{
                System.out.println("innnnnnfrkhwergewr");
                model.addAttribute("recipes", "-1");
            }
            recServ.setSearch(foodType);
        }

        if (index != null) {
            recServ.setSelectedRecipe(Integer.parseInt(index));
            if (recServ.getSelectedRecipe().getFullInfo() == false ) {
                recServ.getDetails(recServ.getSelectedRecipe());
                recServ.getSelectedRecipe().setFullInfo();
            }
            return "redirect:/recipe";
        }

        return "search";
    }
}
