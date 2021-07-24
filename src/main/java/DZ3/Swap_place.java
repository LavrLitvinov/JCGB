package DZ3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Swap_place<T> {
    private T[] arrey;


    @Override
    public String toString() {
        return "Swap_place{" +
                "arrey=" + Arrays.toString(arrey) +
                '}';
    }

    public Swap_place(T... arrey) {
        this.arrey = arrey;
    }

    public T[] getArrey() {
        return arrey;
    }

    public void setArrey(T... arrey) {
        this.arrey = arrey;
    }

    public void swap_places(T... arrey) {
        // Для ввода хорошо бы создать отдельную делянку, но пока пусть так

        Scanner sc = new Scanner(System.in);
        int numberElemOne, numberElemTwo;
        String scs;


        while (true){
            if(arrey.length == 0 | arrey.length == 1){
                System.out.println("Для обмена нехватает элементов!");
                return;
            }
         //   scs = sc.nextLine();

            System.out.print("Введите номер первого обмениваемого элемента : ");
            scs = sc.nextLine();
          try{
                numberElemOne = Integer.parseInt(scs);
           } catch (Exception e) {
                System.out.println("Что-то не то ввели, попробуйте еще раз.");
                continue;
           }
           if(numberElemOne < 0 | numberElemOne >= arrey.length){
                System.out.println("Хорошая попаытка. НО! Это выходит за гарницы дозволенного!");
                continue;
            }

            break;
        }

        while (true) {
            System.out.print("Введите номер второго обмениваемого элемента : ");
              scs = sc.nextLine();
            try {
                numberElemTwo = Integer.parseInt(scs);
           } catch (Exception e) {
                System.out.println("Что-то не то ввели, попробуйте еще раз.");
                


               continue;
            }
            if (numberElemOne < 0 | numberElemTwo >= arrey.length) {
                System.out.println("Хорошая попаытка. НО! Это выходит за гарницы дозволенного!");
                continue;
            }
            if(numberElemTwo == numberElemOne){
                System.out.println("Шило на шило менять не буду. Номера элементов должны различаться");
                continue;
            }

            break;
        }

        System.out.println("Исходный массив: " + Arrays.toString(arrey));
        T buffer = arrey[numberElemOne];
        arrey[numberElemOne]= arrey[numberElemTwo];
        arrey[numberElemTwo] = buffer;
        System.out.println("Результат обмена: " + Arrays.toString(arrey));
    }



}



