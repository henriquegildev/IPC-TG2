package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Menu extends AppCompatActivity {
    private ImageButton menuButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        TextView medButton = (TextView)findViewById(R.id.medicamentosButton);
//        medButton.setOnClickListener(v -> openMeds(v));
//        TextView addMedsButton = (TextView)findViewById(R.id.addMedsButton);
//        addMedsButton.setOnClickListener(v -> openAddMeds(v));
//        TextView settingsButton = (TextView)findViewById(R.id.settingsButton);
//        settingsButton.setOnClickListener(v -> openSettings(v));

        menuButton = (ImageButton) findViewById(R.id.menu_button2);
        menuButton.setOnClickListener(v -> closeMenu(v));

        //Creates a larger clickable area than a TextView, while not showing up in the users Screen
        View viewMedButton = (View) findViewById(R.id.view4);
        viewMedButton.setOnClickListener(v -> openMeds(v));

        View viewAddMedsButton = (View) findViewById(R.id.view5);
        viewAddMedsButton.setOnClickListener(v -> openAddMeds(v));

        View viewSettingsButton = (View) findViewById(R.id.view6);
        viewSettingsButton.setOnClickListener(v -> openSettings(v));

    }

    //TODO:
    // Vê se gostas de como o menu funciona;
    // Vê o funcionamento do "menuButton";
    // Implementa o logotipo como uma ImageButton, e redireciona para a página principal.

    public void closeMenu(View view){
        super.finish();
    }
    public void openMeds(View view){
        startActivity(new Intent(this, Medicamentos.class));
    }
    public void openAddMeds(View view){
        startActivity(new Intent(this, Adicionar_Medicamentos.class));
    }
    public void openSettings(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

}