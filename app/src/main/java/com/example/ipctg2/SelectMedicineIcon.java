package com.example.ipctg2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelectMedicineIcon extends AppCompatActivity {
    private ImageButton backButton;
    private String nameIcon[] = {
            "Icon1", "Icon2", "Icon3", "Icon4", "Icon5"
    };

    //TODO:
    // SE HOUVER TEMPO!
    // ARRANJAR ICONS MAIS ESTILISTICOS PARA OS MEDICAMENTOS,
    // INVÉS DE SEREM IMAGENS REAIS, FICA ESTRANHO..

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

        backButton = findViewById(R.id.back_button2);
        backButton.setOnClickListener(v -> goBack());

        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setText("List of Pill Icons");

        ListView listView = findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        // For populating list data
        CustomMedicineList medicineCustomList = new CustomMedicineList(this, nameIcon, imageid);
        listView.setAdapter(medicineCustomList);

        listView.setOnItemClickListener((adapterView, view, position, l) -> Toast.makeText(getApplicationContext(),"You Selected "+nameIcon[position-1]+ " as Pill Icon ", Toast.LENGTH_SHORT).show());

    }

    public void goBack() {
        super.finish();
    }
}