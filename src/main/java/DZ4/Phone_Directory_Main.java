package DZ4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Phone_Directory_Main {
    private HashMap<String, ArrayList<Integer>> phoneDirectory;



    public static void main(String[] args) {
           HashMap<String, ArrayList<Integer>> phoneDirectory = new HashMap<>();

        addPhone("Иванов", 123123123,phoneDirectory);
        addPhone("Петров", 123123122,phoneDirectory);
        addPhone("Сидоров", 123123134, phoneDirectory);
        addPhone("Иванов", 1231231890, phoneDirectory);

        getPhone("Иванов", phoneDirectory);
        getPhone("Кольев",phoneDirectory);
        getPhone("Сидоров",phoneDirectory);
        getPhone("Петров",phoneDirectory);

        addPhone("Кольев", 98112318, phoneDirectory);

        getPhone("Иванов", phoneDirectory);
        getPhone("Кольев",phoneDirectory);
        getPhone("Сидоров",phoneDirectory);
        getPhone("Петров",phoneDirectory);


    }

    public static void addPhone(String key, int phone,HashMap<String, ArrayList<Integer>> phoneDirectory) {

        ArrayList<Integer> current = phoneDirectory.get(key);
        if(current == null){
            current = new ArrayList<Integer>();
            phoneDirectory.put(key, current);
        }
        current.add(phone);

    }

    public static void getPhone(String key, HashMap<String, ArrayList<Integer>> phoneDirectory){
        if (!phoneDirectory.containsKey(key)){
            System.out.println("Такой фамилии нет");
        } else {
            System.out.println(phoneDirectory.get(key));
        }
    }


}

