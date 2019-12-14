package dzq.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest_04{

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world", "hi zhangsan", "hello lisi", "hello");
        List<String> list1 = Arrays.asList("hi", "hello");
        System.out.println(list.stream().allMatch(str -> str.length() > 6));
        System.out.println("-----------------");
        System.out.println(list.stream().anyMatch(str -> str.length() > 6));
        System.out.println("-----------------");
        Stream.concat(list.stream(), list1.stream()).forEach(System.out::println);
        System.out.println("-----------------");
        System.out.println("count = " + list.stream().count());
        System.out.println("-----------------");
        list.stream().distinct().forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().filter(str -> str.length() > 5).forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().filter(str -> str.length() > 5).findAny().ifPresent(System.out::println);
        System.out.println("-----------------");
        list.stream().findFirst().ifPresent(System.out::println);
        System.out.println("-----------------");
        list.stream().flatMap(str -> Stream.of(str.split(" "))).forEach(System.out::println);
//        List<School> List<Student>
        System.out.println("-----------------");
        list.parallelStream().forEachOrdered(System.out::println);
        System.out.println("-----------------");
        Stream<String> stream = Stream.generate(() -> UUID.randomUUID().toString());
        stream.limit(100).forEach(System.out::println);
        System.out.println("-----------------");
        Stream<Integer> stream1 = Stream.iterate(0, (integer) -> integer + 2);
        stream1.limit(3).forEach(System.out::println);
        System.out.println("-----------------");
        Stream<Integer> stream2 = Stream.iterate(1, (integer) -> (integer + 1) % 2);
        stream2.limit(6).distinct().forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().max((o1, o2) -> o1.length() - o2.length()).ifPresent(System.out::println);
        System.out.println("-----------------");
        list.stream().min((o1, o2) -> o1.length() - o2.length()).ifPresent(System.out::println);
        System.out.println("-----------------");
        System.out.println(list.stream().noneMatch(str -> str.length() > 100));
        System.out.println("-----------------");
        list.stream().peek(System.out::println).filter(str -> str.length() > 5).forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().mapToInt(str -> {
            System.out.println("mapToInt" + str);
            return str.length();
        }).findFirst().ifPresent(System.out::println);
        System.out.println("-----------------");
        list.stream().mapToInt(String::length)
                .reduce((integer1, integer2) -> integer1 + integer2).ifPresent(System.out::println);
        System.out.println("-----------------");
        System.out.println(list.stream().mapToInt(String::length)
                .reduce(0, (integer1, integer2) -> integer1 + integer2));
        System.out.println("-----------------");
        List<String> stringList = list.stream().reduce(new ArrayList<String>(), (listStr, str1) -> {
            listStr.add(str1);
            return listStr;
        }, (listStr, list2) -> {
            listStr.addAll(list2);
            return listStr;
        });
        stringList.forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().skip(2).forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("-----------------");
        list.stream().sorted((o1,o2) -> o1.length() - o2.length()).forEach(System.out::println);



    }


}
