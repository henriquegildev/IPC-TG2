package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectMedIcon extends ListActivity {
    private ImageButton backButton;
    private ListView listView;
    private String nameMed[] = {
            "Kestine", "Paracetamol", "Ibuprofeno", "Voltaren", "Klacid"
    };

    private Integer imageid[] = {
            R.mipmap.med1,
            R.mipmap.med2,
            R.mipmap.med3,
            R.mipmap.med4,
            R.mipmap.med5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_med_icon);

        backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> goBack());

        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List of Med");

        ListView listView=(ListView)findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        CustomMedList customCountryList = new CustomMedList(this, nameMed, imageid);
        listView.setAdapter(customCountryList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getApplicationContext(),"You Selected "+nameMed[position-1]+ " as Country", Toast.LENGTH_SHORT).show();        }
        });

    }

    public void goBack() {
        super.finish();
    }
}