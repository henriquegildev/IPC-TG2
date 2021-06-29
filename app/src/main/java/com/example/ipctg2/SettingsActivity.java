package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class SettingsActivity extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backButton = (ImageButton) findViewById(R.id.back_button3);
        backButton.setOnClickListener(v -> goBack());

        menuButton = (ImageButton) findViewById(R.id.menu_button5);
        menuButton.setOnClickListener(v -> openMenu());

    }

    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }
    public void goBack() {
        super.finish();
    }
}