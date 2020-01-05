package dzq.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest_07 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hi", "hello", "world", "hi");

//        List<String> stringList = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);


//        List<String> stringList = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

//        Set<String> stringSet = stream.collect(HashSet::new, HashSet::add, HashSet::addAll);

//        String str = stream.collect(StringBuffer::new, StringBuffer::append, StringBuffer::append).toString();

//        int size = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll).size();

//        System.out.println(size);
//        stringSet.forEach(System.out::println);

//        List<String> stringList = stream.collect(Collectors.toList());

        List<String> stringList = stream.collect(Collectors.toCollection(LinkedList::new));

        Set<String> set = stream.collect(Collectors.toSet());

        String str = stream.collect(Collectors.joining());



    }


}
