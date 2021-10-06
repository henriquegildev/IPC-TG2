package com.example.ipctg2;

import android.icu.text.DateFormat;

import java.util.Date;
import java.util.ArrayList;

public class MedicineObject {
    private String medicineName;
    private int mAmount;
    private boolean tookPill;
    private String beginDate;
    private String endDate;
    private int[] pillAmount;
    private Integer[] imageid = {
            R.mipmap.med1,
            R.mipmap.med2,
            R.mipmap.med3,
            R.mipmap.med4,
            R.mipmap.med5,
    };

    public MedicineObject(String name, int id, boolean taken, String startDate, String finishDate) {
        this.medicineName = name;
        this.mAmount = id;
        this.tookPill = taken;
        this.beginDate = startDate;
        this.endDate = finishDate;
    }

    public String getName() {
        return medicineName;
    }

    public int getAmount() {
        return mAmount;
    }

    private static int lastMedsId = 0;

    public static ArrayList<MedicineObject> createMedsList(int[] defaultPills, String[] name, boolean taken) {
        ArrayList<MedicineObject> medicine = new ArrayList<MedicineObject>();
        String currentTimeString = DateFormat.getTimeInstance(DateFormat.DAY_OF_WEEK_IN_MONTH_FIELD).format(new Date());
        String nextTimeString = "30-07-2021";
        String startDate = currentTimeString;
        String finishDate = nextTimeString;

        for (int i = 1; i <= defaultPills.length; i++) {
            medicine.add(new MedicineObject(name[i], ++lastMedsId, false, startDate, finishDate));
        }

        return medicine;
    }
}