package programming;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Course {
    private String name;
    private String id;

    public Course(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("R", "1"),
                new Course("B", "2"),
                new Course("C", "3"),
                new Course("D", "44"),
                new Course("D1","44"));

        boolean b = courses.stream()
                .allMatch(course -> course.getName().length() == 1);

        boolean b1 = courses.stream()
                .anyMatch(course -> course.getId().length() > 1);
        boolean b2 = courses.stream()
                .anyMatch(course -> course.getId().length() > 2);
        boolean b3 = courses.stream()
                .noneMatch(course -> course.getId().length() > 5);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        Comparator<Course> courseComparator = Comparator.comparing(Course::getName).reversed();
        Comparator<Course> courseComparator1 = Comparator.comparing(c->c.getName());
        List<Course> collect = courses.stream().sorted(courseComparator1).collect(Collectors.toList());

        System.out.println(collect);

        List<Course> c1 = courses.stream()
                .takeWhile(c -> c.getName().equals("R")).collect(Collectors.toList());
        List<Course> c2 = courses.stream()
                .dropWhile(c -> !c.getName().equals("C")).collect(Collectors.toList());
        System.out.println(c1);
        System.out.println(c2);

        Optional<Course> max = courses.stream()
                .max(Comparator.comparing(x -> x.getId()));

        System.out.println(max.get());

        Course test = max.orElse(new Course("test", "6"));
        System.out.println(test);

        System.out.println(courses.stream().filter(x->x.getName().equals("RY"))
                .findFirst().orElse(new Course("JYU","879")));

        long sum = courses
                .stream()
                .map(c -> Integer.valueOf(c.getId()))
                        .count();
        //.reduce(0,(a,b22)-> a+b22);

        System.out.println(sum);


        Map<String, List<Course>> collect1 = courses.stream().collect(Collectors.groupingBy(Course::getId));
        Map<String, List<String>> collect2 = courses.stream().collect((Collectors.groupingBy(Course::getId,
                Collectors.mapping(Course::getName, Collectors.toList()))));
        System.out.println(collect1);
        System.out.println(collect2);
    }
}
