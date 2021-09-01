package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Oleg", 21, Person.Position.ENGINEER));
        personList.add(new Person("Anton", 54, Person.Position.MANAGER));
        personList.add(new Person("Oksana", 23, Person.Position.DIRECTOR));
        personList.add(new Person("Aleksey", 43, Person.Position.ENGINEER));
        personList.add(new Person("Andrey", 23, Person.Position.MANAGER));
        personList.add(new Person("Oleg", 32, Person.Position.ENGINEER));

        //Выбрать инженеров и и отсортировать их по возрасту

        System.out.println(personList.stream()
                .filter(p -> p.getPosition() == Person.Position.ENGINEER)
                .sorted((p1, p2) -> p1.getAge() - p2.getAge())
                .collect(Collectors.toList()));

        Optional<Integer> sumAges = personList.stream()
                .map(p -> p.getAge())
                .reduce((p1, p2) -> p1 + p2);

        if (sumAges.isPresent()) {
            System.out.println("Все прошло ок!");
        }

        Stream<Integer> integerStream = Stream.of();
        Optional<Integer> optionalInteger = integerStream.reduce((a1, a2) -> a1 + a2);

        if (optionalInteger.isPresent()) {
            System.out.println("Результат: " + optionalInteger.get());
        }

        Stream.of("123", "1234", "123", "345345")
                .distinct()
                .forEach(p -> System.out.println(p));

        Stream.of("123", "1234", "123", "345345")
                .collect(Collectors.toSet());

        Integer[][] integers = new Integer[][] {{1, 2, 3}, {4, 3, 2}};

        Stream.of(integers)
                .flatMap(a -> Stream.of(a))
                .forEach(System.out::println);
    }
}
