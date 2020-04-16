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

public class IngredientSearchPageThreeActivity extends AppCompatActivity {
    private ArrayList<String> userChoices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_search_meat_fish_nuts);

        Button toMeatAndMore = (Button)findViewById(R.id.to_grains_and_more);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        userChoices = (ArrayList<String>) bundle.getSerializable("ingredients");

        toMeatAndMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //incredibly ugly but gets the job done, could not find a better way
                if(((CheckBox)findViewById(R.id.alligator)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.alligator)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.bacon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bacon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.bologna)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bologna)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.bratwurst)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bratwurst)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.chorizo)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.chorizo)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.deer)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.deer)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.duck)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.duck)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.egg)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.egg)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.elk)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.elk)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.goose)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.goose)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.grouse)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.grouse)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ham)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ham)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lamb)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lamb)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.moose)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.moose)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.ostrich)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.ostrich)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.oxtail)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.oxtail)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pancetta)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pancetta)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pastrami)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pastrami)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pepperoni)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pepperoni)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pheasant)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pheasant)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pigeon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pigeon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pork)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pork)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.prosciutto)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.prosciutto)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.quail)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.quail)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rabbit)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rabbit)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.salami)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.salami)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sausage)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sausage)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.snail)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.snail)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.soppressata)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.soppressata)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.spam)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.spam)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sweetbread)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sweetbread)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.turkey)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.turkey)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.veal)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.veal)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.venison)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.venison)).getText().toString());
                }


                if(((CheckBox)findViewById(R.id.amberjack)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.amberjack)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.calamari)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.calamari)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.anchovy)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.anchovy)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.barramundi)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.barramundi)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.bluefish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.bluefish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.carp)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.carp)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.catfish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.catfish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.caviar)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.caviar)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.clam)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.clam)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cockle)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cockle)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cod)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cod)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.conch)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.conch)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.crab)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.crab)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.crawfish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.crawfish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cuttlefish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cuttlefish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.eel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.eel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.flounder)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.flounder)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.grouper)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.grouper)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.haddock)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.haddock)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.halibut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.halibut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.herring)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.herring)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.lobster)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.lobster)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mackerel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mackerel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.marlin)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.marlin)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.monkfish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.monkfish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.mussel)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.mussel)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.octopus)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.octopus)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.oyster)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.oyster)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.perch)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.perch)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pike)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pike)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pollock)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pollock)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pompano)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pompano)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.prawns)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.prawns)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.rockfish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.rockfish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.salmon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.salmon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sardines)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sardines)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.scallop)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.scallop)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.shrimp)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.shrimp)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sole)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sole)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.squid)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.squid)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.sturgeon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.sturgeon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.swordfish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.swordfish)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.tilapia)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.tilapia)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.trout)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.trout)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.whitefish)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.whitefish)).getText().toString());
                }


                if(((CheckBox)findViewById(R.id.almond)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.almond)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.almond_meal)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.almond_meal)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.almond_paste)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.almond_paste)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.cashew)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.cashew)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.chestnut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.chestnut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.flax)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.flax)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.hazelnut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.hazelnut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.macadamia)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.macadamia)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.macaroon)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.macaroon)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.peanut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.peanut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.peanut_butter)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.peanut_butter)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pecan)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pecan)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pine_nut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pine_nut)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.pistachio)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.pistachio)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.praline)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.praline)).getText().toString());
                }
                if(((CheckBox)findViewById(R.id.walnut)).isChecked()){
                    userChoices.add(((CheckBox)findViewById(R.id.walnut)).getText().toString());
                }


                Intent results = new Intent(IngredientSearchPageThreeActivity.this, IngredientSearchFinalPageActivity.class);
                results.putExtra("ingredients", userChoices);
                IngredientSearchPageThreeActivity.this.startActivity(results);


            }
        });
    }
}
