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

        import java.util.ArrayList;
        import java.util.List;

public class IngredientSearchPageTwoActivity extends AppCompatActivity {
    private ArrayList<String> userChoices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search_fruit_and_dairy);

        Button toMeatAndMore = (Button)findViewById(R.id.to_meat_and_more);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        userChoices = (ArrayList<String>) bundle.getSerializable("ingredients");

        toMeatAndMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //incredibly ugly but gets the job done, could not find a better way
                if(((CheckBox)findViewById(R.id.apple)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.apple)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.apricot)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.apricot)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.banana)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.banana)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.berries)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.berries)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.blackberry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.blackberry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.blueberry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.blueberry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.boysenberry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.boysenberry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cantaloupe)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cantaloupe)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cherry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cherry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.clementine)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.clementine)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.coconut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.coconut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.crabapples)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.crabapples)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.craisins)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.craisins)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cranberry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cranberry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.currant)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.currant)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.date)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.date)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.fig)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.fig)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.grape)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.grape)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.grapefruit)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.grapefruit)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.guava)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.guava)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.honeydew)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.honeydew)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.kiwi)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.kiwi)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.kumquat)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.kumquat)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lemon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lemon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lime)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lime)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lingonberry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lingonberry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lychee)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lychee)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mandarin)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mandarin)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mango)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mango)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.nectarine)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.nectarine)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.orange)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.orange)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.papaya)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.papaya)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.passion_fruit)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.passion_fruit)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.peach)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.peach)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pear)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pear)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.persimmons)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.persimmons)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pineapple)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pineapple)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.plantain)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.plantain)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.plum)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.plum)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pomegranate)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pomegranate)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.prunes)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.prunes)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.quince)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.quince)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.raisin)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.raisin)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.raspberry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.raspberry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rhubarb)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rhubarb)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.star_fruit)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.star_fruit)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.strawberry)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.strawberry)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sultanas)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sultanas)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.tangelos)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.tangelos)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.tangerine)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.tangerine)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.watermelon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.watermelon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.asiago)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.asiago)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.brie)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.brie)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.butter)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.butter)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.buttermilk)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.buttermilk)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cheddar)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cheddar)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cream)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cream)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.custard)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.custard)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.feta)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.feta)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.fontina)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.fontina)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.frosting)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.frosting)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ghee)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ghee)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.gouda)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.gouda)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.gruyere)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.gruyere)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.halloumi)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.halloumi)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.manchego)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.manchego)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.margarine)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.margarine)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mascarpone)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mascarpone)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.milk)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.milk)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mozzarella)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mozzarella)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.muenster)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.muenster)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.neufchatel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.neufchatel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.paneer)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.paneer)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.parmesan)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.parmesan)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.provolone)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.provolone)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ricotta)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ricotta)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.romano)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.romano)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.velveeta)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.velveeta)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.yogurt)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.yogurt)).getText().toString());
                }


                Intent results = new Intent(IngredientSearchPageTwoActivity.this, IngredientSearchPageThreeActivity.class);
                results.putExtra("ingredients", userChoices);
                IngredientSearchPageTwoActivity.this.startActivity(results);


            }
        });
    }
}
