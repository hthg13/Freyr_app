package com.example.client.ui.Activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import com.example.client.MainActivity;
import com.example.client.R;
import com.example.client.data.entities.CookBook;
import com.example.client.data.entities.Recipe;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterCookBook;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterCreateRecipe;
import com.example.client.utilities.TokenStore;

public class CreateRecipeActivity extends AppCompatActivity {



    private ArrayList<String> ingredients = new ArrayList<String>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        System.out.println("Create Recipe Activity");


        Button addRecipe = (Button)findViewById(R.id.addRecipe);
        Button addLine = (Button)findViewById(R.id.addLine);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);





        mAdapter = new RecyclerAdapterCreateRecipe(ingredients, CreateRecipeActivity.this);
        recyclerView.setAdapter(mAdapter);


        addLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText qt = (EditText)findViewById(R.id.quantity);
                EditText unit = (EditText)findViewById(R.id.unit);
                EditText ingredient = (EditText)findViewById(R.id.ingredient);

                String toList = qt.getText().toString() + "  " + unit.getText().toString() + "  " + ingredient.getText().toString();
                System.out.println(toList);
                ingredients.add(toList);
                mAdapter.notifyDataSetChanged();

                qt.setText("");
                unit.setText("");
                ingredient.setText("");
            }
        });




        addRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicked");
                /*
                 * getUser()
                 * user.getCookbook()
                 *
                 */
                EditText t = (EditText) findViewById(R.id.title);
                EditText instruct = (EditText) findViewById(R.id.instructions);
                String title = t.getText().toString();
                String instructions = instruct.getText().toString();


                EditText q = (EditText) findViewById(R.id.quantity);
                EditText u = (EditText) findViewById(R.id.unit);
                EditText i = (EditText) findViewById(R.id.ingredient);
                String fullIngr = q.getText()+" "+u.getText()+" "+i.getText();

                Recipe r = new Recipe(title,1,"");
                r.setInstructions(instructions);
                r.setTitle(title);
                r.setIngredients((ArrayList<String>)ingredients.clone());
                System.out.println(ingredients.size());
                r.setImage("mynd");

                TokenStore.addRecipe(r);

                /*
                 *
                 * user.getCookbook().addRecipe
                 *
                 */
                t.setText("");
                instruct.setText("");
                q.setText("");
                u.setText("");
                i.setText("");
                ingredients.clear();
                mAdapter.notifyItemRangeRemoved(0,0);
                mAdapter.notifyDataSetChanged();

            }
        });

    }



}
