package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;

public class SelectMedIcon extends AppCompatActivity {
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_med_icon);

        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> goBack());
    }

    public void goBack() {
        super.finish();
    }
}