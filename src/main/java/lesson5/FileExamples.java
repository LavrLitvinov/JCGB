package lesson5;

import java.io.File;
import java.io.IOException;

public class FileExamples {
    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");
        System.out.println(file.exists());
        file.createNewFile();
        System.out.println(file.length());

        //file.deleteOnExit();
        file.delete();

        File filePath = new File("1");
        filePath.mkdir();
        File filePath2 = new File("2/1/4/5");
        filePath2.mkdirs();

        System.out.println(filePath.length());
        for (File fileTemp : filePath.listFiles()) {
            System.out.println(fileTemp.getName());
        }
    }
}
