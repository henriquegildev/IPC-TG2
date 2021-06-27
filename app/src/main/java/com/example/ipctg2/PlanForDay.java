package com.example.ipctg2;


import android.graphics.Typeface;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlanForDay extends AppCompatActivity {
    private ImageButton backButton;
    private String nameIcon[] = {"Kestine", "Paracetamol", "Ibuprofeno", "Voltaren", "Klacid"};

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
        setContentView(R.layout.activity_plan_for_day);

        backButton = findViewById(R.id.back_button2);
        backButton.setOnClickListener(v -> goBack());

        TextView textView = new TextView(this);
        textView.setTypeface(Typeface.DEFAULT_BOLD);


        ListView listView = findViewById(android.R.id.list);
        listView.addHeaderView(textView);

        CheckBox checkBox = new CheckBox(this);
        checkBox.findViewById(R.id.checkBox);
        boolean checked = PreferenceManager.getDefaultSharedPreferences(this)
                .getBoolean("checkBox", false);
        checkBox.setChecked(checked);

        // For populating list data
        DayMedicineCustomList customDayMedicineList = new DayMedicineCustomList(this, nameIcon, imageid);
        listView.setAdapter(customDayMedicineList);

        listView.setOnItemClickListener((adapterView, view, position, l) -> {
            if(checkBox.isChecked() == true){
                Toast.makeText(getApplicationContext(),"Medicine "+nameIcon[position-1]+ " marked NOT TAKEN ", Toast.LENGTH_SHORT).show();
            }else if(checkBox.isChecked() == false){
                Toast.makeText(getApplicationContext(),"Medicine "+nameIcon[position-1]+ " marked as TAKEN ", Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkBox:
                PreferenceManager.getDefaultSharedPreferences(this).edit()
                        .putBoolean("checkBox1", checked).commit();
                break;
        }
    }


    public void goBack() {
        super.finish();
    }
}
