package DZ5;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        InputOutputData inputOutputData = new InputOutputData();
        inputOutputData.loaderFile("test.txt");

        System.out.println(Arrays.toString(inputOutputData.getHeader()));
        System.out.println(Arrays.deepToString(inputOutputData.getData()));

        inputOutputData.saver("test-2.txt");
    }

}
