package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class About extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        backButton = (ImageButton) findViewById(R.id.back_button4);
        backButton.setOnClickListener(v -> goBack());

        menuButton = (ImageButton) findViewById(R.id.menu_button6);
        menuButton.setOnClickListener(v -> openMenu());
    }

    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }

    public void goBack() {
        super.finish();
    }
}
