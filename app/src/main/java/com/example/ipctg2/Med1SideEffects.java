package com.example.ipctg2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Med1SideEffects extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medsideeffects1);
        ImageButton backButton = findViewById(R.id.back_button2);
        backButton.setOnClickListener(v -> goBack());

        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
    }

    private void goBack() {
        super.finish();
    }
}
