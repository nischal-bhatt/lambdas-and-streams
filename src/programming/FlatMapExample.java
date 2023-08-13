package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<String> courses = List.of("ABC","ORD","PWD");

        List<String> collect = courses
                .stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(collect);

        courses
                .stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

    }
}
