package com.example.ipctg2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;

public class AddMedicine extends AppCompatActivity {
    private ImageButton backButton;
    private ImageButton menuButton;
    private Button buttonAddMedicine;
    private View changeiconview;
    ImageButton selectDate1;
    ImageButton selectDate2;
    TextView date1;
    TextView date2;
    DatePickerDialog datePickerDialog;
    public int year;
    public int month;
    public int dayOfMonth;
    Calendar calendar;

    ImageButton userChooseTime;
    TextView select_med_take_hour;
    TimePickerDialog timePickerDialog;
    int currentHour;
    int currentMinute;
    String amPm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> goBack());

        menuButton = findViewById(R.id.menu_button4);
        menuButton.setOnClickListener(v -> openMenu());

        changeiconview = findViewById(R.id.change_icon_view);
        changeiconview.setOnClickListener(v -> openSelectMedIcon(v));

        buttonAddMedicine = findViewById(R.id.button_add_medicine);
        buttonAddMedicine.setOnClickListener(v -> saveMedInfo(v));


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, MedicineList);
        MultiAutoCompleteTextView textView = findViewById(R.id.editTextTextPersonName);
        textView.setAdapter(adapter);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        selectDate1 = findViewById(R.id.user_select_start_date);
        date1 = findViewById(R.id.select_med_start_date);

        selectDate2 = findViewById(R.id.user_select_finish_date);
        date2 = findViewById(R.id.select_med_finish_date);

        selectDate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(AddMedicine.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date1.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        selectDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(AddMedicine.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date2.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        userChooseTime = findViewById(R.id.user_select_hour);
        select_med_take_hour = findViewById(R.id.select_med_take_hour);

        userChooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(AddMedicine.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        select_med_take_hour.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });

        Button add_medicine = findViewById(R.id.button_add_medicine);
        add_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddMedicine.this.getApplicationContext(), "Medicine Added with success.", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void openMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void openSelectMedIcon(View view) {
        Intent intent = new Intent(this, SelectMedicineIcon.class);
        startActivity(intent);
    }

    public void openMenu() {
        startActivity(new Intent(this, Menu.class));
    }

    public void goBack() {
        super.finish();
    }


    // EditText editText = findViewById(R.id.editText);


    public void saveMedInfo(View view) {
//        String saveMedInfo;
//        String text = editText.getText().toString();
//
//        if (text.length()==0){
//            Toast.makeText(this, "Missing data", Toast.LENGTH_SHORT).show();
//        }else{
//            text
//        }
    }

    //TODO:
    // Search for JSON file with Medicine, maybe a medicine API;
    // Read from JSON file;
    // Load values from JSON to String array.
    private static final String[] MedicineList = new String[]{
            "Kestine", "Paracetamol", "Ibuprofeno", "Voltaren", "Klacid"
    };

}
