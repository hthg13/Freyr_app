package com.example.client.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.utilities.RecipeMapper;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecipeMapper recipeMapper = new RecipeMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button titleSearch = (Button)findViewById(R.id.string_search_button);



        titleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText string_title_input  = (EditText)findViewById(R.id.string_title_input);
                String user_input = ((EditText)findViewById(R.id.string_title_input)).getText().toString();
                ArrayList<String> userChoices = new ArrayList<>();

                //need to find a more compact way to do this
                if(((CheckBox)findViewById(R.id.is_appetizer)).isChecked()){
                    userChoices.add("appetizer");
                }
                if(((CheckBox)findViewById(R.id.is_main_course)).isChecked()){
                    userChoices.add("main course");
                }
                if(((CheckBox)findViewById(R.id.is_dessert)).isChecked()){
                    userChoices.add("dessert");
                }
                if(((CheckBox)findViewById(R.id.is_breakfast)).isChecked()){
                    userChoices.add("breakfast");
                }
                if(((CheckBox)findViewById(R.id.is_lunch)).isChecked()){
                    userChoices.add("lunch");
                }
                if(((CheckBox)findViewById(R.id.is_dinner)).isChecked()){
                    userChoices.add("dinner");
                }
                if(((CheckBox)findViewById(R.id.is_sauce)).isChecked()){
                    userChoices.add("sauce");
                }
                if(((CheckBox)findViewById(R.id.is_beverage)).isChecked()){
                    userChoices.add("beverage");
                }
                if(((CheckBox)findViewById(R.id.is_appetizer)).isChecked()){
                    userChoices.add("side dish");
                }

                //No recipie database yet so we settle on printing the recived data for now
                System.out.println("User Checked:");
                for(String item : userChoices){
                    System.out.println(item);
                }


                ArrayList<Recipe> recipes = null;
                try {
                    recipes = recipeMapper.getResultsTitleType(string_title_input.getText().toString(),userChoices.get(0));
                } catch (UnirestException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent results = new Intent(SearchActivity.this, SearchResultsActivity.class);
                
                Bundle b = new Bundle();
                b.putParcelableArrayList("recipes",recipes);
                System.out.println(recipes.size());
                results.putExtras(b);
                SearchActivity.this.startActivity(results);

            }
        });
    }
}
