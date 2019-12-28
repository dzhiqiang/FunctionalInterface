package dzq.stream;

import dzq.functionalinterface.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest_06 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hi", "hello", "world");

        List<String> stringList = stream.collect(Collectors.toList());

//        List<String> stringList = stream.collect(() -> new ArrayList<>()
//                , (list, str) -> list.add(str), (list1, list2) -> list1.addAll(list2));

//        List<String> stringList = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        stringList.forEach(System.out::println);

    }


}
