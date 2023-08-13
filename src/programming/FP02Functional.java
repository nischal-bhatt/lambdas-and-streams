package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addNumbersUp(numbers);
        int sum1 = addNumbersUpWrong(numbers);
        int sum2 = another(numbers);
        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
        findSumOfOddNumbersSquaresInAList(numbers);

        System.out.println(9*9 + 13*13 + 15*15);

        distinctnums(numbers);
        sortWithComparator(numbers);
        sortWithComparator2(numbers);
        List<Integer> list = createListOfSquares(numbers);

        System.out.println(list);

    }

    private static List<Integer> createListOfSquares(List<Integer> numbers) {
        System.out.println(

        );

        return numbers
                .stream()
                .distinct() //it returns a stream so it is intermediate
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    private static void sortWithComparator2(List<Integer> numbers) {
        System.out.println();
        numbers
                .stream()
                .sorted(Comparator.comparing(x -> Integer.toString(x).length()))
                .forEach(System.out::println);
    }

    private static void sortWithComparator(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void distinctnums(List<Integer> numbers) {
        numbers
                .stream()
                .distinct()
                .forEach(System.out::println);

        numbers
                .stream()
                .sorted()
                .forEach(System.out::println);

    }

    private static void findSumOfOddNumbersSquaresInAList(List<Integer> numbers) {
        Integer reduce = numbers.stream()
                .filter(x -> x % 2 == 1)
                .map(a -> a *a)
                .reduce(0, (s, e) -> s + e); //doesnt return a stream so it is terminal
        System.out.println(reduce);
    }

    private static int another(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0,(x,y)-> x>y?x:y);
    }

    private static int addNumbersUpWrong(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0,(x,y)-> x);
    }

    private static int summer(int aggregate, int b){
        System.out.println(aggregate + " " + b);
        return aggregate + b;
    }

    private static int addNumbersUp(List<Integer> numbers) {
        return numbers
                .stream()
                .reduce(0,FP02Functional::summer);
                //.reduce(0, (a,b)-> a + b);
    }


}
