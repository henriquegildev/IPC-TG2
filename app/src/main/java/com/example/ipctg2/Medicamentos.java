package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.net.Inet4Address;

public class Medicamentos extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);

        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> goBack());

        menuButton = (ImageButton) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(v -> openMenu());
    }

    //TODO:
    // Organizar esta confusão;
    // Aproximar ao que desenhámos no moqups;
    // Implementa o logotipo como uma ImageButton, e redireciona para a página principal.

    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }
    public void goBack() {
        super.finish();
    }
}