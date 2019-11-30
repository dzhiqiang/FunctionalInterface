package dzq.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FunInterface_08 {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "dzq/functionalinterface";

        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> 1;

        Supplier<List<String>> supplier2 = () -> new ArrayList<>();

        Supplier<List<String>> supplier3 = ArrayList::new;

        List<String> nameList = new Student(20, "zhangsan").supplierTest(() -> new ArrayList<>(),
                (list, name) -> {
                    list.add(name);
                    return list;
                });
        nameList.forEach(name -> System.out.println(name));

        Student student = new Student(21, "fuzhi").supplierTest(() -> new Student(),
                (stu, name) -> {
                    stu.setName(name);
                    return stu;
                });

        System.out.println(student.getName());



    }

    private static List<Student> createStudentList() {

        Student s1 = new Student(18, "zhangsan");
        Student s2 = new Student(25, "lisi");
        Student s3 = new Student(60, "wangwu");
        return Arrays.asList(s1, s2, s3);
    }

}
