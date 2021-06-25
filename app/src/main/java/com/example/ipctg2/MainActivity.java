package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton menu_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_button = (ImageButton) findViewById(R.id.menu_button3);
        menu_button.setOnClickListener(v -> openMenu(v));
    }

    public void openMenu(View view) {
        startActivity(new Intent(this, Menu.class));
    }
}