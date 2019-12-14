package dzq.stream;

import dzq.functionalinterface.Student;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest_05 {

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student(20, "lisi")
                , new Student(18, "lisi")
                , new Student(50, "zhangsan")
                , new Student(28, "wangwu")
                , new Student(40, "zhaoliu"));

        studentList.stream().sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
        System.out.println("-------------------");
        studentList.stream().sorted(Comparator.comparingInt(Student::getAge))
                .forEach(System.out::println);

        System.out.println("-------------------");
        studentList.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getAge))
                .forEach(System.out::println);

        System.out.println("-------------------");
        studentList.stream().sorted(Comparator.comparing(Student::getName).reversed())
                .forEach(System.out::println);



    }


}
