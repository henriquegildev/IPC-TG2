package com.example.ipctg2;

import java.util.ArrayList;

public class MedicineObject {
    private String medicineName;
    private int mAmount;
    private int[] pillAmount;
    public MedicineObject(String name, int num) {
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

    public static ArrayList<MedicineObject> createMedsList(int numMeds) {
        ArrayList<MedicineObject> medicine = new ArrayList<MedicineObject>();

        for (int i = 1; i <= numMeds; i++) {
            medicine.add(new MedicineObject("Comprimido " + ++lastMedsId, i));
        }

        return medicine;
    }
}