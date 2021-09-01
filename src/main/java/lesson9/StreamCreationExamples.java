package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationExamples {
    public static void main(String[] args) {
        IntStream.range(1, 10)
                .forEach(System.out::print);

        System.out.println(Stream.iterate(5, x -> x + 5)
                .limit(100)
                .collect(Collectors.toList()));

        List<String> stringList = new ArrayList<>();
        IntStream.range(1, 10)
                .forEach(i -> stringList.add("test " + i));
    }
}
