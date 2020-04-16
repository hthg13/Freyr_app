package com.example.client.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.client.MainActivity;
import com.example.client.R;
import com.example.client.data.entities.ShoppingList;

public class ShoppingListEditorActivity extends AppCompatActivity {
    private int shoppinglistId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_editor);

        EditText editText = (EditText) findViewById(R.id.editText4);
        Intent intent =getIntent();
        shoppinglistId= intent.getIntExtra("shoppinglistId",-1);

        if (shoppinglistId != -1){
            editText.setText(ShoppingListActivity.shoppingLists.get(shoppinglistId));
        }
        else{
            ShoppingListActivity.shoppingLists.add("");
            shoppinglistId=ShoppingListActivity.shoppingLists.size()-1;
        }
       /* editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ShoppingListActivity.shoppingLists.set(shoppinglistId, String.valueOf(s));
                ShoppingListActivity.arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/
    }
}
