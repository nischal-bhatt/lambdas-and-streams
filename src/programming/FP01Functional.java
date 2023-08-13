package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("ARRR","BRRRB","RRRC","RRD","RE");
        printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
        printOddNumbersInListFunctional(numbers);
        printCourses(courses);
        onlyContainingRRR(courses);
        atLeast4Letters(courses);
        printSquaresOfNumbers(numbers);
        printNumOfChars(courses);

    }

    private static void printNumOfChars(List<String> courses) {
        System.out.println();
        courses
                .stream()
                .map(x -> x + " " + x.length())
                .forEach(System.out::println);
    }

    private static void printSquaresOfNumbers(List<Integer> numbers) {
        System.out.println(

        );
        numbers
                .stream()
                .filter(FP01Functional::isEven)
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    private static void atLeast4Letters(List<String> courses) {
        System.out.println();
        courses
                .stream()
                .filter(x -> x.length() >= 3)
                .forEach(System.out::println);
    }

    private static void onlyContainingRRR(List<String> courses) {
        System.out.println();
        courses
                .stream()
                .filter(x -> x.contains("RRR"))
                .forEach(System.out::println);
    }

    private static void printCourses(List<String> courses) {
        System.out.println();
        courses
                .stream()
                .forEach(System.out::println);
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        System.out.println();
        numbers
                .stream()
                .filter(x -> x %2 == 1)
                .forEach(System.out::println);
    }

    private static void print(int number) {
        System.out.println(number);
    }

    private static boolean isEven (int number) {
        return number % 2 == 0;
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        //What to do
        //convert the list into a stream
        //converting it into a sequence of numbers that come one after the other
        //when i get 12, what do i do with it -- and so on
        numbers.stream()
                .forEach(FP01Functional::print);

        //inside .forEach(print(number)) --> we cant do this because we dont want the
        // method to be immediately called
        // we want to define what needs to be done when we get a number
        // to define a behaviour we use something called a method reference

        numbers.stream()
                .forEach(number -> FP01Functional.print(number));

        numbers.stream()
                .forEach(System.out::println);

        // WHAT TO DO!
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        //What to do?
        System.out.println();
        numbers.stream()
                //filter - only allow even numbers
                // in method reference - we are not actually calling it - we are declaring that this is to be called
                // when the number is introduced
                //.filter(FP01Functional::isEven)
                .filter(number -> number % 2 == 0)
                // lambda expression is nothing but a method
                .forEach(System.out::println);
    }

}
