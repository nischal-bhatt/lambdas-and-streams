package programming;

import java.util.function.Function;

interface Abc {
    public Integer countChars(String x);
}

public class HigherOrderFunctions {

    public static void main(String[] args) {
        Abc abc = x -> x.length();

        System.out.println(calc(abc,"NISH"));

        System.out.println(calcF((x)->x+17,27));
        Function<Integer, Integer> integerIntegerFunction = higherOrder(3);
        Integer apply = integerIntegerFunction.apply(23);
        System.out.println(apply);

        System.out.println(higherOrder(4).apply(12));
        System.out.println(higherOrder(2).apply(3));
    }

    private static int calc(Abc abc,String x) {
        return abc.countChars(x);
    }

    private static int calcF(Function<Integer,Integer> a,int r) {
        return a.apply(r);
    }

    private static Function<Integer,Integer> higherOrder(int ty) {

        return (x) -> x * ty;
    }


}
