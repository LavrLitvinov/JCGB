package DZ4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WordsMain {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("bronto", "apple", "swim",
                "jump", "city", "pig", "jump", "orange","swim", "jump", "pig", "bottom", "padding",
                "bronto"));
        HashMap<String, Integer> wordsCollect = new HashMap<>();
        ArrayList<String> uniqueWords = new ArrayList<>();


        for (String buff : words) {
            if (wordsCollect.containsKey(buff)) {
                int i = wordsCollect.get(buff);
                i+=1;
                wordsCollect.put(buff, i);
            } else {
                wordsCollect.put(buff,1);
            }

        }
        for (String buff: wordsCollect.keySet()){
            if(wordsCollect.get(buff) == 1){
                uniqueWords.add(buff);
            }
        }
        System.out.println();
        System.out.println("Уникальные слова:");
        System.out.println(uniqueWords);
        System.out.println();
        System.out.println("Общее распределение количества слов:");
        System.out.println(wordsCollect);


    }

}
