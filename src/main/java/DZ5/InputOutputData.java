package DZ5;

import java.io.*;
import java.util.ArrayList;

public class InputOutputData {
    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

    public InputOutputData() {
    }

    public void saver(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write(rowToString(header));

            for(Integer[] row: data){
                writer.write(rowToString(row));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String rowToString(T[] row) {
        String rezuit = "";

        for (int i = 0; i < row.length; i++) {
            rezuit = rezuit + row[i].toString();
            if (i != row.length - 1) {
                rezuit += ";";
            }

        }
           rezuit += "\n";
           return rezuit;
    }

    public void loaderFile(String fileName){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> dataList = new ArrayList<>();
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null) {
                dataList.add(stringToDataRow(buffer));
            }
            data = dataList.toArray(new Integer[][]{{}});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Integer[] stringToDataRow(String str){

        String[] strings = str.split(";");
        Integer[] elements = new Integer[strings.length];

        for (int i = 0; i < strings.length; i++) {
            elements[i] = Integer.parseInt(strings[i]);
        }
        return elements;
    }


}
