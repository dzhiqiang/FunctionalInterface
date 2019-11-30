package dzq.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest_01 {

    public static void main(String[] args) {

        //来源于数组
        Stream<String> stream = Stream.of("hello", "jdk", "stream");
        //0个中间操作
        stream.forEach(System.out::println);
        System.out.println("--------------");
        Stream<String> stream1 = Arrays.stream(new String[]{"dzq"});
        stream1.forEach(System.out::println);

        Stream<String> stream2 = Stream.of("1", "2", "3");
        System.out.println("--------------");
        stream2.map(str -> {
            System.out.println("没有终止操作");
            return Integer.parseInt(str);
        }).forEach(System.out::println);


        IntStream intStream = IntStream.of(1, 2, 3);

        intStream.sum();






    }

}
