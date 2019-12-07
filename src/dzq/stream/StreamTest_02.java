package dzq.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest_02 {

    public static void main(String[] args) {

        //来源于数组
        Stream<String> stream = Stream.of("hello", "jdk", "stream");

        stream.map(String::toUpperCase).forEach(System.out::println);

        stream.forEach(System.out::println);



    }

}
