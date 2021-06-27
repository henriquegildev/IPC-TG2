package com.example.ipctg2;

import java.util.ArrayList;

public class Medicine {
    private String medicineName;
    private int mAmount;
    private int[] pillAmount;
    public Medicine(String name, int num) {
        medicineName = name;
        mAmount = num;
    }

    public String getName() {
        return medicineName;
    }

    public int getAmount() {
        return mAmount;
    }

    private static int lastMedsId = 0;

    public static ArrayList<Medicine> createMedsList(int numMeds) {
        ArrayList<Medicine> medicine = new ArrayList<Medicine>();

        for (int i = 1; i <= numMeds; i++) {
            medicine.add(new Medicine("Comprimido " + ++lastMedsId, i));
        }

        return medicine;
    }
}