package lesson4.hw3;


import java.util.Arrays;

public class Main {

/*    Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    Даны классы: Fruit, Apple extends Fruit, Orange extends Fruit.
--- Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
--- Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
--- Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
--- Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
--- Не забываем про метод добавления фрукта в коробку.
            */
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple(1));
        appleBox.addFruit(new Apple(1));
        appleBox.addFruit(new Apple(1));
        System.out.println(appleBox.getWeight());

        Box<Apple> appleBox2 = new Box<>();
        appleBox.addFruit(new Apple(1));
        appleBox.addFruit(new Apple(1));

        appleBox.pourOver(appleBox2);
        System.out.println(appleBox.getFruitList());
        System.out.println(appleBox2.getFruitList());
    }

    public static void changeArrElements(Object[] array, int a, int b) {
        Object tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
