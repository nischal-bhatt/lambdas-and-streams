package programming;

import java.util.ArrayList;
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

        List<List<Integer>> integers
                = new ArrayList<>();
        integers.add(List.of(2,3,5));
        integers.add(List.of(1,11,9));
        integers.add(List.of(2,2,22));

        List<Integer> collect1 = integers
                .stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println(collect1);

    }
}
