package dzq.functionalinterface;

import java.util.Arrays;
import java.util.List;

public class FunInterface_14 {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("jdk", "lamdba");

        stringList.stream().map(String::toUpperCase).forEach(System.out::println);

        Student student = new Student(20, "jdk");

        student.methodReferenceTest(String::length);

        student.methodReferenceTest1((str1, str2) -> str1.concat(str2));

        student.methodReferenceTest1(String::concat);

        student.methodReferenceTest2((str1, str2) -> str1.startsWith(str2));

        student.methodReferenceTest2(String::startsWith);

        student.methodReferenceTest3(Student::new);

        student.methodReferenceTest4(Student::new);

    }


}
