package dzq.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest_09 {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        stringList.stream().map(item -> item).forEach(System.out::println);

    }

}
