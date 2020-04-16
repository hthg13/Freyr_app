package com.example.client.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.client.R;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    static ArrayList<String> shoppingLists = new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater  menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_shopping_list_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
        });
    }
}
