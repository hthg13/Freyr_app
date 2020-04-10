package com.example.client.ui.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


import com.example.client.R;

public class CreateRecipeActivity extends AppCompatActivity {


    private LinearLayout ingrView;
    private LinearLayout layout;

    private ArrayList<String> ingredients;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        System.out.println("Create Recipe Activity");



        Button addRecipe = (Button)findViewById(R.id.addRecipe);
        
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

                /*
                 *  Eftir að gera:
                 *   Þannig að hægt se að bæta við fleiri ingredients
                 *   dálkum, ítra í gegnum það og ná í quantity, unit, ingr
                 *   t.d. 2 tsp laukur
                 *
                 *   for now bara hafa eitt til að sjá þetta virka
                 */

                EditText q = (EditText) findViewById(R.id.quantity);
                EditText u = (EditText) findViewById(R.id.unit);
                EditText i = (EditText) findViewById(R.id.ingredient);
                String fullIngr = q.getText()+" "+u.getText()+" "+i.getText();

                //Búa til recipe

//                Recipe r = new Recipe();
//                r.setInstructions(instructions);
//                r.setTitle(title);
//                r.setIngredients(fullIngr);

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
            }
        });

    }



}
