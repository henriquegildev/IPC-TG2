package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

public class SelectMedIcon extends ListActivity {
    private ImageButton backButton;
    private ListView listView;
    private String nameMed[] = {
            "Kestine", "Paracetamol", "Ibuprofeno", "Voltaren", "Klacid"
    };

    private Integer imageid[] = {
            R.drawable.med1,
            R.drawable.med2,
            R.drawable.med3,
            R.drawable.med4,
            R.drawable.med5,
    };

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