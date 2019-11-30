package dzq.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunInterface_13 {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("1", "2", "6");


        stringList.stream().map(Integer::parseInt).forEach(System.out::println);


    }


}
