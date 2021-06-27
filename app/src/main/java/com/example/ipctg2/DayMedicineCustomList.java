package com.example.ipctg2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DayMedicineCustomList extends ArrayAdapter {
    private String[] medNames;
    private Integer[] imageid;
    private Activity context;

    public DayMedicineCustomList(Activity context, String[] medNames, Integer[] imageid) {
        super(context, R.layout.row_main_icon_name_check, medNames);
        this.context = context;
        this.medNames = medNames;
        this.imageid = imageid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_main_icon_name_check, null, true);
        TextView textViewNameMed = row.findViewById(R.id.textView_med_name2);
        ImageView medIcon = row.findViewById(R.id.imageid2);

        textViewNameMed.setText(medNames[position]);
        medIcon.setImageResource(imageid[position]);
        return row;
    }
}
