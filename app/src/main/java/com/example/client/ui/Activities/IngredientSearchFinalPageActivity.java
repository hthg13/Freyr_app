package com.example.client.ui.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client.MainActivity;
import com.example.client.R;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterCookBook;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterSearch;
import com.example.client.utilities.RecipeMapper;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class IngredientSearchFinalPageActivity extends AppCompatActivity {
    private ArrayList<String> userChoices = new ArrayList<>();
    private RecipeMapper recipeMapper = new RecipeMapper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search_grain_baking_and_sweets);

        Button toMeatAndMore = (Button)findViewById(R.id.search_by_ingredients);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        userChoices = (ArrayList<String>) bundle.getSerializable("ingredients");

        toMeatAndMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //incredibly ugly but gets the job done, could not find a better way
                if(((CheckBox)findViewById(R.id.bagel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bagel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.baguette)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.baguette)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.barley)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.barley)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.biscuits)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.biscuits)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.bisquick)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bisquick)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.bran)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bran)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.bread)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bread)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.breadsticks)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.breadsticks)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.buckwheat)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.buckwheat)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cereal)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cereal)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.challah)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.challah)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.chips)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.chips)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ciabatta)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ciabatta)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cornbread)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cornbread)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cornflour)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cornflour)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cornmeal)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cornmeal)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cornstarch)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cornstarch)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.couscous)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.couscous)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cracker)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cracker)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.croissants)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.croissants)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.croutons)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.croutons)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.flour)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.flour)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.gnocchi)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.gnocchi)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lasagne)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lasagne)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.noodle)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.noodle)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pasta)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pasta)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pierogi)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pierogi)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pita)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pita)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.polenta)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.polenta)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.popcorn)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.popcorn)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pretzel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pretzel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.quinoa)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.quinoa)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ramen)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ramen)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ravioli)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ravioli)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rice)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rice)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.risotto)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.risotto)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rye)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rye)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.saltines)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.saltines)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.semolina)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.semolina)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.spelt)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.spelt)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.starch)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.starch)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.vermicelli)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.vermicelli)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.wafer)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.wafer)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.wheat)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.wheat)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.yeast)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.yeast)).getText().toString());
                }


                if(((CheckBox)findViewById(R.id.butterscotch)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.butterscotch)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.candy)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.candy)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.caramel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.caramel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.chocolate)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.chocolate)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cookies)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cookies)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.doritos)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.doritos)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.doughnut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.doughnut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.fudge)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.fudge)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.honey)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.honey)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.jam)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.jam)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.jello)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.jello)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.marshmallow)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.marshmallow)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.molasses)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.molasses)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.nutella)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.nutella)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.oreo)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.oreo)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sugar)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sugar)).getText().toString());
                }

                System.out.println("User Checked:");
                for(String item : userChoices){
                    System.out.println(item);
                }

                ArrayList<Recipe> recipes = null;
                try {
                    recipes = recipeMapper.getResultsIngr(userChoices);
                } catch (UnirestException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent results = new Intent(IngredientSearchFinalPageActivity.this, SearchResultsActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("recipes",recipes);
                System.out.println(recipes.size());
                results.putExtras(b);
                IngredientSearchFinalPageActivity.this.startActivity(results);



            }
        });
    }
}
