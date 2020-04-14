package is.hi.hbv501g.freyr.Freyr.Utilities;

import is.hi.hbv501g.freyr.Freyr.Entities.User;

public class AlertsToUser {

    // creates a message based on if the user is logged in or not
    // might be helpful to use this when the user needs to login
    // before some activity is performed
    // see sample usage in recipeController and recipe.html
    public String messageLogin(User sessionUser) {
        // if user is logged in dont alert
        String message = "";

        // if user is not logged in alert
        if(sessionUser == null) {
            message = "you need to login first";
        }

        return message;
    }

    public String alreadyFav() {
        // if user is logged in dont alert

        // if user is not logged in alert
        String message = "You already added this recipe to favorites";

        return message;
    }

    public String wrongPassword() {
        // if user is logged in dont alert

        // if user is not logged in alert
        String message = "Wrong password";

        return message;
    }

    public String messageSignup(User sessionUser) {
        // if user is logged in dont alert
        String message = "";

        // if user is not logged in alert
        if(sessionUser == null) {
            message = "you need to sign up first";
        }

        return message;
    }

}
