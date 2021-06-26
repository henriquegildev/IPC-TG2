package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.MultiAutoCompleteTextView;

public class Adicionar_Medicamentos extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton menuButton;
    private ImageButton mainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_medicamentos);

        mainButton = (ImageButton) findViewById(R.id.main_button);
        mainButton.setOnClickListener(v -> openMain());

        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> goBack());

        menuButton = (ImageButton) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(v -> openMenu());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, MedicineList);
        MultiAutoCompleteTextView textView = findViewById(R.id.editTextTextPersonName);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    //TODO:
    // Aproximar o design da activity ao que temos no moqups;
    // Tenta implementar uma Lista de imagens, estilo menu dropdown;
    // Depois implementa-se o alterar a imagem do outro lado;
    // -----
    // Tenta implementar um calendário que dê para selecionar a data.

    public void openMain() {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }
    public void goBack() {
        super.finish();
    }

    //TODO:
    // Search for JSON file with Medicine, maybe a medicine API;
    // Read from JSON file;
    // Load values from JSON to String array.
    private static final String[] MedicineList = new String[] {
            "Kestine", "Paracetamol", "Ibuprofeno", "Voltaren", "Klacid"
    };
}
