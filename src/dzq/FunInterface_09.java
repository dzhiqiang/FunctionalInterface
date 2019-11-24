package dzq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunInterface_09 {

    public static void main(String[] args) {

        FunInterface_09 funInterface_09 = new FunInterface_09();

        System.out.println(funInterface_09.biFunctionTest(1, 2, (first, second) -> first * second, first -> first * 2));



    }

    public int biFunctionTest(int first, int second, BinaryOperator<Integer> biFunction, Function<Integer, Integer> after) {
        return biFunction.andThen(after).apply(first, second);
    }

}
