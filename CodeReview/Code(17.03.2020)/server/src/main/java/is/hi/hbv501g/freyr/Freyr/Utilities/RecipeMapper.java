package is.hi.hbv501g.freyr.Freyr.Utilities;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import is.hi.hbv501g.freyr.Freyr.Entities.Recipe;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


public class RecipeMapper {

    private String baseUri = "https://spoonacular.com/recipeImages/";
    private String ingrURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?number=30&ranking=1&ignorePantry=false&ingredients=";
    private String titleURL[] = {"https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=30&offset=0&type=", "&query="};
    private String infoURL[] = {"https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/", "/information"};

    // Fa lista af uppskriftum eftir hráefnum
    public ArrayList<Recipe> getResultsIngr(ArrayList<String> ingr) throws UnirestException {
        String ingredients = "";
        // Útbúa streng sem bætist við ingrURL
        if(ingr.size()==1){
            ingredients = ingr.get(0);
        }
        else {
            for (int i = 0; i < ingr.size(); i++) {
                if (i == ingr.size()-1){
                    String ingredient = ingr.get(i);
                    if(i != ingr.size()-1) {
                        ingredients += ingredient+"%2C";
                    }
                    else {
                        ingredients += ingredient;
                    }
                        //ingredients+=ingredient;
                }
                /*else {
                    String ingredient = ingr.get(i);
                    ingredient = ingredient.replaceAll("[ ]", "%20");
                    System.out.println(ingredient);
                    ingredients += ingredient + ",";
                }*/
            }
        }

        // GET request
        String response = this.request(this.ingrURL+ingredients);
        System.out.println("MAPPER"+response);

        ArrayList<Recipe> recipes = this.resultsToRecipe("{results :"+response+"}");
        //System.out.println(recipes.get(0).toString());
        return recipes;
    }

    // Fá lista eftir nafni
    public ArrayList<Recipe> getResultsTitleType(String title, String type) throws UnirestException {
        System.out.println(type);
        title = title.replaceAll("[ ]", "%20");
        type = type.replaceAll("[ ]","%20");
        System.out.println(title);

        String response = this.request(this.titleURL[0]+type+this.titleURL[1]+title);

        System.out.println(response);

        ArrayList<Recipe> recipes = this.resultsToRecipe(response);
        //System.out.println(recipes.get(0).toString());
        return recipes;
    }

    // Recipe details, bætir líka við restinni af upplýsingum um uppskrift
    public Recipe getDetails(Recipe recipe) throws UnirestException {

        int id = recipe.getId();
        String response = this.request(this.infoURL[0]+id+this.infoURL[1]);

        JSONObject obj = new JSONObject("{results :["+response+"]}");
        JSONArray r = obj.getJSONArray("results");
        recipe.setInstructions(r.getJSONObject(0).getString("instructions"));
        recipe.setReadyInMinutes(r.getJSONObject(0).getInt("readyInMinutes"));
        recipe.setServings(r.getJSONObject(0).getInt("servings"));

        JSONArray ingr = r.getJSONObject(0).getJSONArray("extendedIngredients");

        for(int i = 0; i<ingr.length(); i++){
            recipe.setIngredients(ingr.getJSONObject(i).getString("original"));
        }
        System.out.println(recipe.getIngredients().size());

        return recipe;
    }

    // Draga út uppl sem við viljum úr svari frá api
    private ArrayList<Recipe> resultsToRecipe(String json){

        ArrayList<Recipe> recipes = new ArrayList();
        JSONObject obj = new JSONObject(json);
        JSONArray r = obj.getJSONArray("results");
        for (int i = 0; i < r.length(); i++) {
            JSONObject element = r.getJSONObject(i);
            Recipe object = new Recipe();
            object.setId(element.getInt("id"));
            object.setIndex(i);
            object.setTitle(element.getString("title"));

            if(element.has("image")){
                //Mismunandi hvort þarf að bæta við baseUri eða ekki
                if(element.getString("image").contains("https") ){
                object.setImage(element.getString("image"));
                } else{
                object.setImage(baseUri+element.getString("image"));
                }
            }


            recipes.add(object);
        }

        return recipes;
    }

  /*

 /// Óþarft held ég

    private ArrayList<Recipe> ingrResultsToRecipe(String json) {
        ArrayList<Recipe> recipes = new ArrayList();
        JSONObject obj = new JSONObject(json);
        JSONArray r = obj.getJSONArray("results");
        for (int i = 0; i < r.length(); i++) {
            JSONObject element = r.getJSONObject(i);
            Recipe object = new Recipe();
            object.setId(element.getInt("id"));
            object.setTitle(element.getString("title"));
            object.setImage(element.getString("image"));
            recipes.add(object);
        }
        System.out.println(recipes.get(0).toString());
        return recipes;
    }*/

    private String request(String url) throws UnirestException {
        HttpResponse<String> response = Unirest.get(url)
                .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "95e63d77d8mshcd6163a94d2be7bp15c756jsn981c624f96fc")
                .asString();
        return response.getBody();
    }


}

