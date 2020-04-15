package com.example.client.ui.Activities;


import android.os.AsyncTask;

import com.example.client.data.entities.Recipe;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RecipeMapper {

    private String baseUri = "https://spoonacular.com/recipeImages/";
    private String ingrURL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?number=30&ranking=1&ignorePantry=false&ingredients=";
    private String titleURL[] = {"https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search?number=30&offset=0&type=", "&query="};
    private String infoURL[] = {"https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/", "/information"};

    // Fa lista af uppskriftum eftir hráefnum
    public ArrayList<Recipe> getResultsIngr(ArrayList<String> ingr) throws UnirestException, JSONException, ExecutionException, InterruptedException {
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
    public ArrayList<Recipe> getResultsTitleType(String title, String type) throws UnirestException, JSONException, ExecutionException, InterruptedException {
        System.out.println(type);
        title = title.replaceAll("[ ]", "%20");
        type = type.replaceAll("[ ]","%20");
        System.out.println(title);
        System.out.println(this.titleURL[0]+type+this.titleURL[1]+title);

        String response = this.request(this.titleURL[0]+type+this.titleURL[1]+title);

        System.out.println(response);

        ArrayList<Recipe> recipes = this.resultsToRecipe(response);
        System.out.println(recipes.get(0).toString());

        return recipes;
    }

    // Recipe details, bætir líka við restinni af upplýsingum um uppskrift
    public Recipe getDetails(Recipe recipe) throws JSONException, UnirestException, ExecutionException, InterruptedException {

        int id = recipe.getId();
        String response = this.request(this.infoURL[0]+id+this.infoURL[1]);

        JSONObject obj = new JSONObject("{results :["+response+"]}");
        JSONArray r = obj.getJSONArray("results");
        recipe.setInstructions(r.getJSONObject(0).getString("instructions"));
        recipe.setReadyInMin(r.getJSONObject(0).getInt("readyInMinutes"));
        recipe.setServings(r.getJSONObject(0).getInt("servings"));

        JSONArray ingr = r.getJSONObject(0).getJSONArray("extendedIngredients");

        for(int i = 0; i<ingr.length(); i++){
            recipe.addIngredients(ingr.getJSONObject(i).getString("original"));
            System.out.println(ingr.getJSONObject(i).getString("original"));
        }
        System.out.println(recipe.getIngredients().size());

        return recipe;
    }

    // Draga út uppl sem við viljum úr svari frá api
    private ArrayList<Recipe> resultsToRecipe(String json) throws JSONException, InterruptedException, ExecutionException, UnirestException {

        ArrayList<Recipe> recipes = new ArrayList();
        JSONObject obj = new JSONObject(json);

        JSONArray r = obj.getJSONArray("results");
        for (int i = 0; i < r.length(); i++) {
            JSONObject element = r.getJSONObject(i);
            Recipe object = new Recipe("dsa",1,"dsa");
            object.setId(element.getInt("id"));
            object.setIndex(i);
            object.setTitle(element.getString("title"));

            //this.getDetails(object);

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

    private String request(String url) throws UnirestException, ExecutionException, InterruptedException {
       /* HttpResponse<String> response = Unirest.get(url)
                .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "95e63d77d8mshcd6163a94d2be7bp15c756jsn981c624f96fc")
                .asString();
        System.out.println(response);
        return response.getBody();*/
       HttpGetRequest a= new HttpGetRequest();
       String l =a.execute(url).get();
       System.out.println(l);
       return l;
    }

    public class HttpGetRequest extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "GET";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;
        @Override
        protected String doInBackground(String... params){
            String stringUrl = params[0];
            HttpResponse<String> response = null;
            try {
                response = Unirest.get(stringUrl)
                        .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                        .header("x-rapidapi-key", "95e63d77d8mshcd6163a94d2be7bp15c756jsn981c624f96fc")
                        .asString();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
            System.out.println(response);
            return response.getBody();
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
        }
    }
}

