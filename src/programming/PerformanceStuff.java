package programming;

import java.util.List;

public class PerformanceStuff {



    public static void main(String[] args) {
        List<String> courses
                = List.of("Spring","Spring Boot","API","Microservices",
                "AWS","PCF","Azure","Docker","Kubernetes");
        courses.stream()
                .peek(System.out::println)
                .filter(course -> course.length()>11)
                //intermediate ops are lazy -- they only execute if there
                // is a terminal operation at the end
                .map(String::toUpperCase)
                .peek(System.out::println)
                .findFirst();

        System.out.println();
        for (int i =0; i<courses.size(); i++) {
            System.out.println(courses.get(i));
            if (courses.get(i).length() > 11) {
                System.out.println(courses.get(i).toUpperCase());
                break;
            }
        }

        System.out.println();
        courses.stream()
                .peek(System.out::println)
                .filter(course -> course.length()>11)
                //intermediate ops are lazy -- they only execute if there
                // is a terminal operation at the end
                .map(String::toUpperCase)
                .peek(System.out::println)

                 ;
    }
}
