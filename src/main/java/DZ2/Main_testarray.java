package DZ2;

public class Main_testarray {
    public static void main(String[] args)  {

        /*
  1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
   При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
   Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или
    текст вместо числа), надо бросить исключение MyArrayDataException с детализацией,
    в какой ячейке неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
   MyArrayDataException и вывести результат расчета.

   test     c,{"15","25","35","45"}

   */


        String array[][] = new String[][]{{"1", "2", "3p", "4"}, {"10", "20", "30", "40"}, {"13", "23", "33", "43"},
                {"16", "26", "36", "46"}};
        try {
            checkArrayDimension(array);
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            checkElementsArray(array);
        } catch (ArrayToStringException en){
            System.out.println(en.getMessage());
        }


        System.out.println("Массив просмотрен");

    }

    public static void checkArrayDimension(String[][] array) throws MyArrayDataException {
        int arrayRow = array.length;
        int arrayColumn = array[0].length;
        String massege;
        if (arrayRow != 4 | arrayColumn != 4) {
            massege = "Размер массива " + arrayRow + "X" + arrayColumn + ". Ожидался размер 4 х 4 .";
            throw new MyArrayDataException(massege);
        }

    }

    public static void checkElementsArray(String[][] array) throws ArrayToStringException {

        int m = array.length;
        int n = array[0].length;
        int [][] outputArray = new int[m][n];


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                try
                {
                    outputArray[i][j] = Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e){

                    String swearing = "Элемент массива [" + i + "][" + j + "] содержащий:  " +  array[i][j] +
                            " не может быть преобразован в число!";
                    throw new ArrayToStringException(swearing);

                }
            }
        }
    }


}
