package is.hi.hbv501g.freyr.Freyr.Utilities;

import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class addListsToModel {
    public static void ingredientsToModel(Model model){
        List<String> vegtableListTemp = Arrays.asList("artichoke", "arugula", "asparagus", "avocado", "basil", "beet", "broccoli", "burdock", "butternut", "cabbage", "caper", "capsicum", "carrot", "cauliflower", "celery", "chard", "chayote", "chickpea", "cilantro", "collard", "corn", "cress", "cucumber", "daikon", "dill", "dulse", "edamame", "eggplant", "endive", "fennel", "garlic", "ginger", "horseradish", "hummus", "jicama", "kale", "beans", "kohlrabi", "leek", "lentil", "mint", "mushroom", "okra", "olive", "onion", "parsley", "parsnip", "peas", "pickle", "pimiento", "porcini", "potato", "pumpkin", "radicchio", "radish", "rocket", "rosemary", "rutabaga", "sauerkraut", "scallion", "seaweed", "shallot", "soybeans", "spinach", "split peas", "squash", "tomatillo", "tomato", "turnip", "watercress", "yam", "zucchini");
        ArrayList<String> vegtableList = new ArrayList<String>();
        vegtableList.addAll(vegtableListTemp);
        model.addAttribute("vegetables", vegtableList);

        List<String> dairyListTemp = Arrays.asList("asiago", "brie", "butter", "buttermilk", "cheddar", "cream", "custard", "egg", "feta", "fontina", "frosting", "ghee", "gouda", "gruyere", "halloumi", "manchego", "margarine", "mascarpone", "milk", "mozzarella", "muenster", "neufchatel", "paneer", "parmesan", "provolone", "ricotta", "romano", "velveeta", "yogurt");
        ArrayList<String> dairyList = new ArrayList<String>();
        dairyList.addAll(dairyListTemp);
        model.addAttribute("dairyAndAlternatives", dairyList);

        List<String> fruitListTemp = Arrays.asList("apple", "apricot", "banana", "berries", "blackberry", "blueberry", "boysenberry", "cantaloupe", "cherry", "clementine", "coconut", "crabapples", "craisins", "cranberry", "currant", "date", "fig", "grape", "grapefruit", "guava", "honeydew", "kiwi", "kumquat", "lemon", "lime", "lingonberry", "lychee", "mandarin", "mango", "nectarine", "orange", "papaya", "passion fruit", "peach", "pear", "persimmons", "pineapple", "plantain", "plum", "pomegranate", "prunes", "quince", "raisin", "raspberry", "rhubarb", "star fruit", "strawberry", "sultanas", "tangelos", "tangerine", "watermelon");
        ArrayList<String> fruitList = new ArrayList<String>();
        fruitList.addAll(fruitListTemp);
        model.addAttribute("fruits", fruitList);

        List<String> meatListTemp = Arrays.asList("alligator", "bacon", "bologna", "bratwurst", "chorizo", "deer", "duck", "elk", "goose", "grouse", "ham", "lamb", "moose", "ostrich", "oxtail", "pancetta", "pastrami", "pepperoni", "pheasant", "pigeon", "pork", "prosciutto", "quail", "rabbit", "salami", "sausage", "snail", "soppressata", "spam", "sweetbread", "turkey","veal", "venison");
        ArrayList<String> meatList = new ArrayList<String>();
        meatList.addAll(meatListTemp);
        model.addAttribute("meats", meatList);

        List<String> seafoodListTemp = Arrays.asList("amberjack", " calamari", "anchovy", "barramundi", "bluefish", "carp", "catfish", "caviar", "clam", "cockle", "cod", "conch", "crab", "crawfish", "cuttlefish", "eel", "flounder", "grouper", "haddock", "halibut", "herring", "lobster", "mackerel", "marlin", "monkfish", "mussel", "octopus", "oyster", "perch", "pike", "pollock", "pompano", "prawns", "rockfish", "salmon", "sardines", "scallop", "shrimp", "sole", "squid", "sturgeon", "swordfish", "tilapia", "trout", "whitefish");
        ArrayList<String> seafoodAndFishList = new ArrayList<String>();
        seafoodAndFishList.addAll(seafoodListTemp);
        model.addAttribute("seafoodAndFish", seafoodAndFishList);

        List<String> nutsListTemp = Arrays.asList("almond", "almond meal", "almond paste", "cashew", "chestnut", "flax", "hazelnut", "macadamia", "macaroon", "peanut", "peanut butter", "pecan", "pine nut", "pistachio", "praline", "walnut" );
        ArrayList<String> nutsList = new ArrayList<String>();
        nutsList.addAll(nutsListTemp);
        model.addAttribute("nuts", nutsList);

        List<String> grainsAndBakingListTemp = Arrays.asList("bagel", "baguette", "barley", "biscuits", "bisquick", "bran", "bread", "breadsticks", "buckwheat", "cereal", "challah", "chips", "ciabatta", "cornbread", "cornflour", "cornmeal", "cornstarch", "couscous", "cracker", "croissants", "croutons", "flour", "gnocchi", "lasagne", "noodle", "pasta", "pierogi", "pita", "polenta", "popcorn", "pretzel", "quinoa", "ramen", "ravioli", "rice", "risotto", "rye", "saltines", "semolina", "spelt", "starch", "vermicelli", "wafer", "wheat", "yeast");
        ArrayList<String> grainsAndBakingList = new ArrayList<String>();
        grainsAndBakingList.addAll(grainsAndBakingListTemp);
        model.addAttribute("grainsAndBaking", grainsAndBakingList );

        List<String> sweetListTemp = Arrays.asList("butterscotch", "candy", "caramel", "chocolate", "cookies", "doritos", "doughnut", "fudge", "honey", "jam", "jello", "marshmallow", "molasses", "nutella", "oreo", "sugar");
        ArrayList<String> sweetList = new ArrayList<String>();
        sweetList.addAll(sweetListTemp);
        model.addAttribute("sweets", sweetList);

    }

    public static void mealKindsToModel(Model model){
        List<String> mealKindsTemp = Arrays.asList( "main course", "side dish", "dessert", "appetizer", "salad", "bread", "breakfast", "soup", "beverage", "sauce", "drink");
        ArrayList<String> mealKinds = new ArrayList<String>();
        mealKinds.addAll(mealKindsTemp);
        model.addAttribute("mealKinds", mealKinds);
    }
}
