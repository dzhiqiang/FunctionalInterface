package dzq.functionalinterface;

import java.util.Arrays;
import java.util.List;

public class FunInterface_07 {

    public static void main(String[] args) {

        List<Student> studentList = createStudentList();

        studentList.stream().filter(student -> student.getAge() > 18)
                .forEach(student -> System.out.println(student.getName()));

        studentList.stream().filter(student -> student.getName().equals("zhangsan"))
                .forEach(student -> System.out.println(student.getName() + "," + student.getAge()));

    }

    private static List<Student> createStudentList() {

        Student s1 = new Student(18, "zhangsan");
        Student s2 = new Student(25, "lisi");
        Student s3 = new Student(60, "wangwu");
        return Arrays.asList(s1, s2, s3);
    }

}
