package com.example.client.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.client.R;
import com.example.client.data.entities.ShoppingList;
import com.example.client.ui.Activities.Adapters.RecyclerAdapterCreateRecipe;
import com.example.client.utilities.TokenStore;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    static ArrayList<String> shoppingLists = new ArrayList<>();
    static ArrayAdapter arrayAdapter;


    private ArrayList<String> ingredients = new ArrayList<String>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater  menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_shopping_list_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if(item.getItemId()==R.id.add_shopping_list){
            Intent intent= new Intent(getApplicationContext(),ShoppingListEditorActivity.class);

            startActivity(intent);
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
/*
        ListView listView =(ListView) findViewById(R.id.listView);
        shoppingLists.add("test");

        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingLists);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(getApplicationContext(),ShoppingListEditorActivity.class);
                intent.putExtra("shoppinglistId",position);
                startActivity(intent);
            }
        });*/
        ingredients = TokenStore.getList();


        Button addRecipe = (Button)findViewById(R.id.addRecipe);
        Button addLine = (Button)findViewById(R.id.a);

        recyclerView = (RecyclerView) findViewById(R.id.res);
        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);





        mAdapter = new RecyclerAdapterCreateRecipe(ingredients, ShoppingListActivity.this);
        recyclerView.setAdapter(mAdapter);


        addLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText ingredient = (EditText)findViewById(R.id.ed);

                String toList = ingredient.getText().toString();
                System.out.println(toList);
                ingredients.add(toList);

                mAdapter.notifyDataSetChanged();

                ingredient.setText("");

            }
        });


    }
}
