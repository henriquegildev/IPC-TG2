package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.net.Inet4Address;

public class Medicine extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton menuButton;
    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    String selectedMedicine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> goBack());

        menuButton = findViewById(R.id.menu_button);
        menuButton.setOnClickListener(v -> openMenu());

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(v -> openMed1SideEffects());

        imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(v -> openMed2SideEffects());

        imageView3 = findViewById(R.id.imageView3);
        imageView3.setOnClickListener(v -> openMed3SideEffects());
    }

    private void openMed3SideEffects() {
        startActivity(new Intent(this, Med3SideEffects.class));
    }

    private void openMed2SideEffects() {
        startActivity(new Intent(this, Med2SideEffects.class));
    }

    private void openMed1SideEffects() {
        startActivity(new Intent(this, Med1SideEffects.class));
    }


    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }

    public void goBack() {
        super.finish();
    }
}