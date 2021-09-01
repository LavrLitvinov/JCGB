package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganizationStreamExamples {
    public static void main(String[] args) {
        List<Organization> organizations = new ArrayList<>();
        organizations.add(new Organization(1, "Yandex", Arrays.asList(
                new Worker("Oleg", 55, 100, "Engeneer"),
                new Worker("Anton", 25, 120, "Manager"),
                new Worker("Elena", 35, 140, "Engeneer"))));

        organizations.add(new Organization(1, "Sber", Arrays.asList(
                new Worker("Oleg", 55, 100, "Engeneer"),
                new Worker("Anton", 25, 160, "Manager"),
                new Worker("Elena", 35, 123, "Engeneer"),
                new Worker("Dmitry", 63, 1140, "Director"),
                new Worker("Oksana", 12, 1450, "Engeneer"))));

        organizations.add(new Organization(1, "Mail", Arrays.asList(
                new Worker("Oleg", 55, 100, "Engeneer"),
                new Worker("Anton", 41, 120, "Manager"),
                new Worker("Kseniya", 124, 140, "Engeneer"))));

        //Вернуть уникальные имена сотрудников компаний, где > 3 сотрудников
        System.out.println(organizations.stream()
                .filter(o -> o.getWorkerList().size() > 3)
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .map(w -> w.getName())
                .distinct()
                .collect(Collectors.toList()));

        //Создать Map, где ключ - название должности, значение - список сотрудников на этой должности
        System.out.println(organizations.stream()
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .collect(Collectors.groupingBy(w -> w.getPosition())));

        Map<String, List<Worker>> workersMap = organizations.stream()
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .collect(Collectors.groupingBy(w -> w.getPosition()));

        //Создать Map, где ключ - должность, а значение - средняя зарплата
        Map<String, Double> salaryRating = organizations.stream()
                .map(o -> o.getWorkerList())
                .flatMap(w -> w.stream())
                .collect(Collectors.groupingBy(w -> w.getPosition(), Collectors.averagingDouble(f -> f.getSalary())));

        System.out.println(salaryRating);

    }

}
