package lesson5;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class StreamsExamples {
    public static void main(String[] args) {
        String tempString = "кот";
        System.out.println(Arrays.toString(tempString.getBytes()));
        System.out.println(Charset.defaultCharset());
        //00000000 10101010 11111111  2^8 = 256
        //1 = 1   127 = 127  128 = -128  -48   (-128 48)   128 + (128-48) = 208
        System.out.println((byte) 208);
        System.out.println(Charset.availableCharsets());

        File file = new File("our_example.txt");

        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
            outputStream.write("кот".getBytes());
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (OutputStream outputStream1 = new FileOutputStream(file, true)) {
            outputStream1.write(65);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //long time = System.currentTimeMillis();
        //try (OutputStream outputStream2 = new FileOutputStream("fimembs.txt")) {
        //    for (int i = 0; i < 5 * 1024 * 1024; i++) {
        //        outputStream2.write(65);
        //    }
        //} catch (FileNotFoundException exception) {
        //    exception.printStackTrace();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //System.out.println("Время на запиись 5 мегабайт: " + (System.currentTimeMillis() - time));

        long time = System.currentTimeMillis();
        try (OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream("fimembs.txt"))) {
            for (int i = 0; i < 5 * 1024 * 1024; i++) {
                outputStream2.write(65);
                outputStream.flush();
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Время на запиись 5 мегабайт c буферизацией: " + (System.currentTimeMillis() - time));

        try (InputStream inputStream = new FileInputStream("1.txt")) {
            for (int i = 0; i < new File("1.txt").length(); i++) {
                System.out.println(i + ":" + (char) inputStream.read());
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = null;

        try (InputStream inputStream = new FileInputStream("1.txt")) {
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Создали строку с нужной кодировкой: " + new String(bytes, UTF_8));
    }
}
