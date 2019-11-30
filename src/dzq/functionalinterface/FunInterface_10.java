package dzq.functionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FunInterface_10 {

    public static void main(String[] args) {

        BinaryOperator<Integer> binaryOperator = BinaryOperator.maxBy((first, second) -> first - second);

        System.out.println(binaryOperator.apply(1, 2));

        

    }

    public int biFunctionTest(int first, int second, BinaryOperator<Integer> biFunction, Function<Integer, Integer> after) {
        return biFunction.andThen(after).apply(first, second);
    }

}
