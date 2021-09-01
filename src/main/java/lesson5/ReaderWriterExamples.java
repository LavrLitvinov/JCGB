package lesson5;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterExamples {
    public static void main(String[] args) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("1.txt"), UTF_8)) {
            int x;
            while ((x = inputStreamReader.read()) != -1) {
                System.out.println(x);
                System.out.print((char) x);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt"))) {
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Student> studentArrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))) {
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                String[] studentParamsArray = tempString.split(" ");
                studentArrayList.add(new Student(studentParamsArray[0], studentParamsArray[1],
                        Integer.parseInt(studentParamsArray[2])));
            }  //Oleg Tikhonov 29
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(studentArrayList);

        try (PrintWriter printWriter = new PrintWriter("new_students.csv")) {
            for (Student student : studentArrayList) {
                printWriter.println(student.toString());
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

}
