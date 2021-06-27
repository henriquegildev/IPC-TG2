package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ImageButton menu_button;
    private ListView listView;
    ArrayList<MedicineObject> medList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set time
        TextView actualTimeString = findViewById(R.id.currentTime);
        displayTime(actualTimeString);
        menu_button = findViewById(R.id.menu_button3);
        menu_button.setOnClickListener(v -> openMenu(v));

    }

    public void openMenu(View view) {
        startActivity(new Intent(this, Menu.class));
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