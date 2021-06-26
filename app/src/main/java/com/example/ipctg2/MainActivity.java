package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ImageButton menu_button;
    private ListView listView;
    ArrayList<String> listStrings = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set time
        TextView actualTimeString = findViewById(R.id.currentTime);
        displayTime(actualTimeString);

        menu_button = findViewById(R.id.menu_button3);
        menu_button.setOnClickListener(v -> openMenu(v));

        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listStrings);
    }

    public void openMenu(View view) {
        startActivity(new Intent(this, Menu.class));
    }

    public void addItems(View view){
        listStrings.add("Clicked");
        adapter.notifyDataSetChanged();
    }


    public void displayTime(TextView time){
        Thread timeThread = new Thread(){
            public void run(){
                try{
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Sets current time from moment of creation
                                String currentTimeString = DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());
                                time.setText(currentTimeString);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timeThread.start();
    }
}