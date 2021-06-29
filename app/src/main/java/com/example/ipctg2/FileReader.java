package com.example.ipctg2;

import android.util.Log;

import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileReader {
    /*
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("E:\\Program Files\\IntelliJ Project Files\\tp2-20435-po2\\FileTest.txt");
        Scanner scanner = new Scanner(file);
        String reader = "";
        fileReader(scanner);
    }
     */
    public int numLines;
    public int numCols;
    public DayMedicineCustomList dayMedicineCustomList;
    private String[] value;
    public String medName;
    public int medId;
    public int immuneNum;
    public FileReader(){}
    public void fileReader(String FilePath) throws FileNotFoundException {
        File file = new File(FilePath);
        Scanner scanner = new Scanner(file);
        ArrayList<String> listString = new ArrayList<>();
        String[] coordinates;
        //dayMedicineCustomList = new DayMedicineCustomList();


        System.out.println("Reading File");
        while(scanner.hasNextLine()){
            listString.add(scanner.nextLine());
        }
        try {
            int count = 0;
            for (int i = 0; i < listString.size(); i++) {
                if( listString.get(i).contains("name: ")){
                    count = 0;
                    value = listString.get(i).split(" ");
                    medName = value[1];
                }else if( !listString.contains("name: ")){
                    value = listString.get(i).split("\n");
                    Log.i(value[0], "value 0");
                    Log.i(value[1], "value 1");
                    Log.i(value[2], "value 2");
                    Log.i(value[3], "value 3");
                    Log.i(value[4], "value 4");
                }

            }

                //medName = value[1];


                //System.out.println(listString.get(count));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
