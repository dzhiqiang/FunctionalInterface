package dzq;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunInterface_06 {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

//        integerList.forEach(integer -> System.out.println(integer));

        Consumer<Integer> before = integer -> System.out.println(integer);

        Consumer<Integer> after = integer -> System.out.println(integer * 2 + "andThen");

        integerList.forEach(before.andThen(after));

        integerList.forEach(integer -> {
            before.accept(integer);
            after.accept(integer);});
    }

}
