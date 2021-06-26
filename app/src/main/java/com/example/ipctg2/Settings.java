package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Settings extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> goBack());

        menuButton = (ImageButton) findViewById(R.id.menu_button);
        menuButton.setOnClickListener(v -> openMenu());
    }
    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }
    public void goBack() {
        super.finish();
    }
}