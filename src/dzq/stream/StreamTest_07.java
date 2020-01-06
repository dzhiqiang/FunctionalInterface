package dzq.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest_07 {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("hi", "hello", "world", "hi");
//        stream.parallel()
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

    public <T,A, R> R getResult(List<T> list, Collector<T, A, R> collector) {
        A a = collector.supplier().get();
        for (T t : list) {
            collector.accumulator().accept(a, t);
        }
        return collector.finisher().apply(a);
    }

    public <T,A, R> R getResultParallel(List<T> list, Collector<T, A, R> collector) {

        List<T> list1 = list.subList(0, list.size() / 2);
        A a1 = collector.supplier().get();
        List<T> list2 = list.subList(list.size() / 2, list.size());
        A a2 = collector.supplier().get();

        for (T t1 : list1) {
            collector.accumulator().accept(a1, t1);
        }

        for (T t2 : list2) {
            collector.accumulator().accept(a2, t2);
        }
        A a3 = collector.combiner().apply(a1, a2);
        return collector.finisher().apply(a3);
    }

    public <T,A, R> R getResultConcurrent(List<T> list, Collector<T, A, R> collector) {

        A a = collector.supplier().get();
        for (T t : list) {
            new Thread(() -> {
                collector.accumulator().accept(a, t);
            }).start();
        }
        return collector.finisher().apply(a);
    }


}
