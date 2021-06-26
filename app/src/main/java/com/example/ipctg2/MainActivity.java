package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton menu_button;
    ArrayList<String> listStrings = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_button = (ImageButton) findViewById(R.id.menu_button);
        menu_button.setOnClickListener(v -> openMenu(v));

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listStrings);
    }

    //TODO:
    // LER O CÓDIGO PARA PERCEBERES O QUE EU FIZ
    // LER O ÚLTIMO COMMIT
    // ---------------------------------------
    // Implement a way to add to View medicine in list;
    // Implement a way to read values from JSON file. Load those values to a List;
    // Implementa o logotipo como uma ImageButton, e redireciona para a página principal.

    public void openMenu(View view) {
        startActivity(new Intent(this, Menu.class));
    }

    public void addItems(View view){
        listStrings.add("Clicked");
        adapter.notifyDataSetChanged();
    }

}