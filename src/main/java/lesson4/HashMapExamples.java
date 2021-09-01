package lesson4;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapExamples {
    public static void main(String[] args) {
        //HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        ////hashMap.put(1, "One");
        //System.out.println(hashMap);
        ////hashMap.put(1, "Two");
        //System.out.println(hashMap);

        HashMap<Integer, String> passports = new HashMap<>();
        passports.put(1234, "Ирина");
        passports.put(2344, "АНдрей");
        passports.put(11234, "Антон");
        passports.put(12134, "Оксана");
        //System.out.println(passports);

        //passports.remove(2344);
        //System.out.println(passports);
//
        //System.out.println(passports.get(11234));

        System.out.println(passports);

        for (Integer passportNum: passports.keySet()) {
            if (passportNum == 12134) {
                passports.remove(passportNum);
            }
            //System.out.println(passports.get(passportNum));
        }

        System.out.println(passports);

        //for (String name: passports.values()) {
        //    System.out.println(name);
        //}
    }
}
