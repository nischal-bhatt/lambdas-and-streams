package programming;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.*;
import java.util.stream.IntStream;

public class FP03FunctionalInterfacesBehaviourParameterization {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        Function<Integer,String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return Integer.toString(integer);
            }
        };


       String x =  executeFunction(function,56);
        System.out.println(x);
        String y = executeFunction(y2 -> Integer.toString(y2),245);
        System.out.println(y);

        Supplier<Integer> supplier = () ->new Random().nextInt();


        System.out.println(supplier.get());

    }

    private static String executeFunction(Function<Integer, String> function, int xxx) {
        //passing behaviour as argument!
        return function.apply(xxx);
    }
}
