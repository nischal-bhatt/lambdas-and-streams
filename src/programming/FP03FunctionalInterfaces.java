package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        Predicate<Integer> isEvenPredicate = x -> x %2 == 0;

        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer %2 == 0;
            }
        };

        //functional interface only has 1 abstract method

        Consumer<Integer> sout = System.out::println;

        numbers
                .stream()
                .filter(isEvenPredicate2)
                .filter(isEvenPredicate)
                .forEach(sout);

        Function<String,Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Function<String,Integer> function2 = x -> x.length();

        Integer aaa = function2.apply("abcasdadadadasdasdasdasdasd");
        Integer abc = function.apply("abcasdadadadasdasdasdasdasd");
        System.out.println(abc);
        System.out.println(aaa);
    }
}
