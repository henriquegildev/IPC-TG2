package com.example.ipctg2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomMedList extends ArrayAdapter {
    private String[] medNames;
    private Integer[] imageid;
    private Activity context;

    public CustomMedList(Activity context, String[] medNames, Integer[] imageid) {
        super(context, R.layout.row_icons_med_items, medNames);
        this.context = context;
        this.medNames = medNames;
        this.imageid = imageid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_icons_med_items, null, true);
        TextView textViewNameMed = row.findViewById(R.id.textView_med_name);
        ImageView medIcon = row.findViewById(R.id.imageid);

        textViewNameMed.setText(medNames[position]);
        medIcon.setImageResource(imageid[position]);
        return  row;
    }
}
