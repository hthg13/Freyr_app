package is.hi.hbv501g.freyr.Freyr.Controllers;

import is.hi.hbv501g.freyr.Freyr.Entities.Recipe;
import is.hi.hbv501g.freyr.Freyr.Entities.User;
import is.hi.hbv501g.freyr.Freyr.Services.RecipeService;
import is.hi.hbv501g.freyr.Freyr.Services.UserService;
import is.hi.hbv501g.freyr.Freyr.Utilities.AlertsToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class userController {

    private UserService userService;
    private RecipeService recipeService;
    private AlertsToUser alertsToUser = new AlertsToUser(); // this is one of the utilities classes

    @Autowired
    public userController(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    // USER PAGE FUNCTIONS
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String logOut(@RequestParam(value = "logout", required = false) String logout, HttpSession session){
        if(logout != null){
            System.out.println("BPPÐ");
            session.setAttribute("LoggedInUser", null);
            return "home";
        }
        return "home";
    }
    /**
     * @return redirects to user page where all users can be seen
     */
    //REST
    @RequestMapping("/user")
    public List<User> User(Model model) {
        return userService.findAll();
    }


    // SIGNUP PAGE FUNCTIONS

    /**
     * @param user
     * @return redirects to home page
     */
    /*@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpGET(User user, HttpSession session){
        if(session.getAttribute("LoggedInUser") != null){
            return "redirect:/";
        }
        else {
            return "signup";
        }

    }
*/
    // sign up page
    //REST
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signUpPOST(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid user")
        }

        String message = "Username already exists";
        User exists = userService.findByUserName(user.getUserName());

        if(exists == null){
            return userService.save(user);
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message)
    }

    // identifies the user if exists and returns to home page
    // else shows a message to the user informing him about the error
    //rest
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User loginPOST(@Valid @RequestBody User user, BindingResult result, HttpSession session){

        if(result.hasErrors()){
            throw new ResponseStatusException()
        }

        String message = "Incorrect user information or user does not exist";
        User exists = userService.validate(user);

        if (exists != null) {
            user = userService.findByUserName(user.getUserName());
            session.setAttribute("LoggedInUser", user);
            return exists
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,message)
    }




    // todo remove this method
    // shows the user name of the user that is logged in
    //REST
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public User loggedinGET(HttpSession session){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser != null){
            return sessionUser;
        }
        else
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"you have to be logged in");
    }

    // sets up the user profile
    // only displays values if user is logged in
    @RequestMapping(value="/profile", method=RequestMethod.GET)
    public String userProfileGet(Model model,  HttpSession session){
        // get the session user (the logged in user)
        User sessionUser = (User) session.getAttribute("LoggedInUser");

        if(sessionUser != null){
            model.addAttribute("loggedinuser", sessionUser);
        }

        // setup an array for possible recipes that the user has saved
        ArrayList<Recipe> recipes = new ArrayList<>();

        if(sessionUser == null) {                                                   // no one is logged in
            model.addAttribute("recipes", null);                            // display no recipes
        } else {
            for(int i=0; i<sessionUser.getFavorite().size(); i++) {
                recipes.add(recipeService.findById(sessionUser.getFavorite().get(i)));    // get the recipes with the id-s the user has added to favorites
            }
            model.addAttribute("recipes", recipes);
        }

        return "profile";
    }

    @RequestMapping(value="/profile", method=RequestMethod.POST)
    public String recipeOperations(@RequestParam(required = false, value = "id") String id,@RequestParam(required = false, value = "delete") String remove, Model model, HttpSession session){
        // get the session user (the logged in user)
        User sessionUser = (User) session.getAttribute("LoggedInUser");

        if(id!=null) {
            Recipe recipe = recipeService.findById(Integer.parseInt(id));
            model.addAttribute("recipe", recipe);
        }
        if(remove != null){
            for(int i = 0; i < sessionUser.getFavorite().size(); i++){
                if(sessionUser.getFavorite().get(i) == Integer.parseInt(remove)) {
                    sessionUser.getFavorite().remove(i);
                }
            }

            ArrayList<Recipe> recipes = new ArrayList<>();
            for(int j=0; j<sessionUser.getFavorite().size(); j++) {
                recipes.add(recipeService.findById(sessionUser.getFavorite().get(j)));    // get the recipes with the id-s the user has added to favorites
            }
                model.addAttribute("recipes", recipes);
                model.addAttribute("loggedinuser", sessionUser);
                userService.save(sessionUser);
                return "profile";

        }

        return "recipe";
    }


    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String changePwGET(User user){
        return "settings";
    }

    @RequestMapping(value="/settings", method=RequestMethod.POST)
    public String changePwPOST(@RequestParam(value = "password")String pw, @RequestParam(value = "npassword")String npw, HttpSession session, Model model){


        User sessionUser = (User) session.getAttribute("LoggedInUser");
        model.addAttribute("loggedinuser", sessionUser);
        System.out.println(sessionUser.getPassword());
        userService.findByUserName(sessionUser.getUserName());
        if(!pw.equals(sessionUser.getPassword())){
            String message = alertsToUser.wrongPassword();
            model.addAttribute("message", message);
            return "settings";
        }else{
            sessionUser.setPassword(npw);
            userService.save(sessionUser);
            session.setAttribute("LoggedInUser", sessionUser);
            System.out.println(sessionUser.getPassword()+"EFVIRKAR");
        }

        return "redirect:/profile";
    }

}
