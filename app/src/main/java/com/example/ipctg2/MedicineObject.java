package com.example.ipctg2;

import android.icu.text.DateFormat;

import java.time.Instant;
import java.util.Date;
import java.util.ArrayList;

public class MedicineObject {
    private String medicineName;
    private int mAmount;
    private boolean tookPill;
    private String beginDate;
    private String endDate;
    private int[] pillAmount;
    public MedicineObject(String name, int id, boolean taken, String startDate, String finishDate) {
        medicineName = name;
        mAmount = id;
        tookPill = taken;
        beginDate = startDate;
        endDate = finishDate;
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
        String nextTimeString = DateFormat.getDateTimeInstance().toString();
        String startDate = currentTimeString;
        String finishDate = nextTimeString;

        for (int i = 1; i <= defaultPills.length; i++) {
            medicine.add(new MedicineObject(name[i], ++lastMedsId, false, startDate, finishDate));
        }

        return medicine;
    }
}