package dzq;

import java.util.Arrays;
import java.util.List;

public class FunInterface_12 {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

        integerList.forEach(System.out::println);

        integerList.forEach(new Student()::soutAge);

    }

}
