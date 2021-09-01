package lesson9.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal("Рыба", false, false));
        animalList.add(new Animal("Кот", true, true));
        animalList.add(new Animal("Лягушка", true, false));
        animalList.add(new Animal("Черепаха", false, true));

        //printAnimals(animalList, new CheckIsJumper());

        printAnimals(animalList, new CheckAble() {
            @Override
            public boolean test(Animal animal) {
                return animal.isCanRun();//анонимный класс
            }
        });

        printAnimals(animalList, a -> a.isCanRun());
    }

    private static void printAnimals(List<Animal> animalList, CheckAble checkAble) {
        for (Animal animal : animalList) {
            if (checkAble.test(animal)) {
                System.out.println(animal);
            }
        }
    }
}
