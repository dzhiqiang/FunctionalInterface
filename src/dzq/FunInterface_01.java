package dzq;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunInterface_01 {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("--------------");

        for (int i = 0; i < integerList.size(); i++) {

            System.out.println(integerList.get(i));

        }

        System.out.println("-----------------");

        for (int i : integerList) {
            System.out.println(i);
        }

        integerList.forEach(integer -> System.out.println(integer));

    }

}
