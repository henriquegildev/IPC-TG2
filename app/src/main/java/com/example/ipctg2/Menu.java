package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Menu extends AppCompatActivity {
    private ImageButton mainButton;
    private ImageButton menuButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //Initialize Home/Menu Buttons
        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(v -> openMain(v));

        menuButton = findViewById(R.id.menu_button2);
        menuButton.setOnClickListener(v -> closeMenu(v));

        //Initialize buttons for navigation in Menu
        TextView homeButton = findViewById(R.id.home_button);
        homeButton.setOnClickListener(v -> openMain(v));
        View viewHomeButton = findViewById(R.id.view_menu_1);
        viewHomeButton.setOnClickListener(v -> openHome(v));

        TextView medButton = findViewById(R.id.medicine_button);
        medButton.setOnClickListener(v -> openMeds(v));
        View viewMedButton = findViewById(R.id.view_menu_2);
        viewMedButton.setOnClickListener(v -> openMeds(v));

        TextView addMedsButton = findViewById(R.id.add_medicine_button);
        addMedsButton.setOnClickListener(v -> openAddMeds(v));
        View viewAddMedsButton = findViewById(R.id.view_menu_3);
        viewAddMedsButton.setOnClickListener(v -> openAddMeds(v));

        TextView settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(v -> openSettings(v));
        View viewSettingsButton = findViewById(R.id.view_menu_4);
        viewSettingsButton.setOnClickListener(v -> openSettings(v));

        TextView aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(v -> openAbout(v));
        View viewAboutButton = findViewById(R.id.view_menu_5);
        viewAboutButton.setOnClickListener(v -> openAbout(v));

    }

    //Top part
    public void openMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void closeMenu(View view) {
        super.finish();
    }

    //Bottom part
    public void openHome(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void openMeds(View view) {
        startActivity(new Intent(this, Medicine.class));
    }

    public void openAddMeds(View view) {
        startActivity(new Intent(this, AddMedicine.class));
    }

    public void openSettings(View view) {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    public void openAbout(View view) {
        startActivity(new Intent(this, About.class));
    }
}