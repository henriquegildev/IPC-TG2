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
        imageView.setOnClickListener(v -> openMed1SideEffects(v));
    }

    private void openMed1SideEffects(View v) {
        startActivity(new Intent(this, Menu.class));
    }


    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }
    public void goBack() {
        super.finish();
    }
}