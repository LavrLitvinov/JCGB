package lesson5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExamples {

    public static void main(String[] args) {
        File file = new File("student");
        //Student student = new Student("Anton", "Ivanov", 15);
        //Student student2 = new Student("Anton2", "Ivanov2", 152);
//
        //try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
        //    objectOutputStream.writeObject(student);
        //    objectOutputStream.writeObject(student2);
        //} catch (FileNotFoundException exception) {
        //    exception.printStackTrace();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Student studentFromFile1 = (Student) objectInputStream.readObject();
            System.out.println(studentFromFile1);
            Student studentFromFile2 = (Student) objectInputStream.readObject();
            System.out.println(studentFromFile2);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
