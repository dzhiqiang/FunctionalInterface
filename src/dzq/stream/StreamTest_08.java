package dzq.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest_08 {

    public static void main(String[] args) {

        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 15);
        Student s3 = new Student("wangwu", 28);
        Student s4 = new Student("zhangsan", 20);

        List<Student> studentList = Arrays.asList(s1, s2, s3, s4);

        int sumAge = studentList.stream().collect(Collectors.summingInt(Student::getAge));

        System.out.println("sumAge = " + sumAge);
        //分组操作
        Map<String, Integer> map = studentList.stream().collect(Collectors.groupingBy(Student::getName, Collectors.summingInt(Student::getAge)));
        Map<String, List<Student>> mapStudent = studentList.stream().collect(Collectors.groupingBy(Student::getName));
        //分区
        Map<Boolean, List<Student>> partStudent = studentList.stream().collect(Collectors.partitioningBy((stu) -> stu.getAge() >= 20));

        System.out.println(partStudent);


        System.out.println(map);
        //("","","")
        String names = studentList.stream().map(Student::getName).collect(Collectors.joining(",", "(", ")"));
        System.out.println(names);
        Map<String, IntSummaryStatistics> mapSummary = studentList.stream()
                .collect(Collectors.groupingBy(Student::getName, Collectors.summarizingInt(Student::getAge)));
        System.out.println(mapSummary);
    }

}
