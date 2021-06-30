package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton menu_button;
    private ListView listView;
    ArrayList<MedicineObject> medList = new ArrayList<>();
    private String[] nameIcon = {"Kestine", "Paracetamol", "Ibuprofeno"};
    private String[] nameIcon2 = {"Voltaren", "Klacid"};
    private String filePath = "C:\\Git\\IPC-TG2\\app";

    //TODO:
    // SE HOUVER TEMPO!
    // ARRANJAR ICONS MAIS ESTILISTICOS PARA OS MEDICAMENTOS,
    // INVÉS DE SEREM IMAGENS REAIS, FICA ESTRANHO..

    private Integer[] imageid = {
            R.mipmap.med1,
            R.mipmap.med2,
            R.mipmap.med3,
    };
    private Integer[] imageid2 = {
            R.mipmap.med4,
            R.mipmap.med5,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set time
        TextView actualTimeString = findViewById(R.id.currentTime);
        displayTime(actualTimeString);
        menu_button = findViewById(R.id.menu_button3);
        menu_button.setOnClickListener(v -> openMenu(v));

        View viewMorning = findViewById(R.id.view);
        View viewEvening = findViewById(R.id.view2);
        viewMorning.setOnClickListener(v -> openMorningMeds(v));
        viewEvening.setOnClickListener(v -> openEveningMeds(v));

        listView = findViewById(android.R.id.list);
        ListView listView2 = findViewById(R.id.list2);
        //listView.addHeaderView(textView);
        // For populating list data
        DayMedicineCustomList customDayMedicineList = new DayMedicineCustomList(this, nameIcon, imageid);
        listView.setAdapter(customDayMedicineList);
        DayMedicineCustomList customDayMedicineList2 = new DayMedicineCustomList(this, nameIcon2, imageid2);
        listView2.setAdapter(customDayMedicineList2);
        //CheckBox checkBox = findViewById(R.id.checkBox);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this.getApplicationContext(), "You Selected " + nameIcon[position - 1], Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openMenu(View view) {
        startActivity(new Intent(this, Menu.class));
    }
    public void openMorningMeds(View view) { startActivity(new Intent(this, PlanForDay.class)); }
    public void openEveningMeds(View view) {
        startActivity(new Intent(this, PlanForDay.class));
    }

    public int getPosition(){
        return 0;
    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked
        int i = listView.getCheckedItemPosition();
        System.out.println(i + " " + "ischecked: " + checked);
    }
    public void displayTime(TextView time){
        Thread timeThread = new Thread(){
            public void run(){
                try{
                    while (!isInterrupted()){
                        runOnUiThread(() -> {
                            //Sets current time from moment of creation
                            String currentTimeString = DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());
                            time.setText(currentTimeString);
                        });
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timeThread.start();
    }
}