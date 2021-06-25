package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView medButton = (TextView)findViewById(R.id.medicamentosButton);
        medButton.setOnClickListener(v -> openMeds(v));
        TextView addMedsButton = (TextView)findViewById(R.id.addMedsButton);
        addMedsButton.setOnClickListener(v -> openAddMeds(v));
        TextView settingsButton = (TextView)findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(v -> openSettings(v));
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