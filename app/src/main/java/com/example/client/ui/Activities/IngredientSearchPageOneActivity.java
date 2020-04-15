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
        import com.example.client.ui.Activities.IngredientSearchPageTwoActivity;

        import java.util.ArrayList;
        import java.util.List;

public class IngredientSearchPageOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search_vegetables);

        Button toFruitAndDairy = (Button)findViewById(R.id.to_fruits_and_dairy);

        toFruitAndDairy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> userChoices = new ArrayList<>();

                //incredibly ugly but gets the job done, could not find a better way
                if(((CheckBox)findViewById(R.id.artichoke)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.artichoke)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.arugula)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.arugula)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.asparagus)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.asparagus)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.avocado)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.avocado)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.basil)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.basil)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.beet)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.beet)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.broccoli)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.broccoli)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.burdock)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.burdock)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.butternut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.butternut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cabbage)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cabbage)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.caper)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.caper)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.capsicum)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.capsicum)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.carrot)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.carrot)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cauliflower)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cauliflower)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.celery)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.celery)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.chard)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.chard)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.chayote)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.chayote)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.chickpea)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.chickpea)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cilantro)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cilantro)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.collard)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.collard)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.corn)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.corn)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cress)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cress)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cucumber)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cucumber)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.daikon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.daikon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.dill)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.dill)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.dulse)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.dulse)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.edamame)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.edamame)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.eggplant)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.eggplant)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.endive)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.endive)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.fennel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.fennel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.garlic)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.garlic)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ginger)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ginger)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.horseradish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.horseradish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.hummus)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.hummus)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.jicama)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.jicama)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.kale)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.kale)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.beans)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.beans)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.kohlrabi)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.kohlrabi)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.leek)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.leek)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lentil)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lentil)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mint)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mint)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mushroom)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mushroom)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.okra)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.okra)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.olive)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.olive)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.onion)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.onion)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.parsley)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.parsley)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.parsnip)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.parsnip)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.peas)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.peas)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pickle)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pickle)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pimiento)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pimiento)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.porcini)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.porcini)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.potato)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.potato)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pumpkin)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pumpkin)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.radicchio)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.radicchio)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.radish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.radish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rocket)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rocket)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rosemary)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rosemary)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rutabaga)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rutabaga)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sauerkraut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sauerkraut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.scallion)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.scallion)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.seaweed)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.seaweed)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.shallot)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.shallot)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.soybeans)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.soybeans)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.spinach)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.spinach)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.split_peas)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.split_peas)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.squash)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.squash)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.tomatillo)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.tomatillo)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.tomato)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.tomato)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.turnip)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.turnip)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.watercress)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.watercress)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.yam)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.yam)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.zucchini)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.zucchini)).getText().toString());
                }

                Intent results = new Intent(IngredientSearchPageOneActivity.this, IngredientSearchPageTwoActivity.class);
                results.putExtra("ingredients", userChoices);
                IngredientSearchPageOneActivity.this.startActivity(results);


            }
        });
    }
}
