package dzq;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FunInterface_11 {

    public static void main(String[] args) {

        Optional<String> optional = Optional.of("dzq");

        System.out.println(optional.get());

        Optional<String> optionalNullable = Optional.ofNullable(null);
        System.out.println("----------------------");
        System.out.println(optionalNullable.isPresent() ? optionalNullable.get() : "jdk");
        System.out.println("----------------------");
        optionalNullable.ifPresent(str -> System.out.println(str));
        System.out.println("----------------------");
        optional.filter(str -> str.equals("dzq1")).ifPresent(str -> System.out.println(str + "fuhe"));
        System.out.println("----------------------");
        optional.map(str -> str.length()).ifPresent(integer -> System.out.println(integer * 2));

        Optional<Integer> optionalInteger = optional.flatMap(str -> Optional.ofNullable(str.length()));
        System.out.println("----------------------");
        System.out.println(optionalNullable.orElse("jdknull"));
        System.out.println("----------------------");
        System.out.println(optionalNullable.orElseGet(() -> "JDKNULL"));

        System.out.println(optionalNullable.orElseThrow(() -> new NullPointerException()));

        Optional<Student> max = new School().getMaxStudent();
        max.ifPresent(student -> System.out.println(student.getName()));

        Student student = max.orElseThrow(() -> new NullPointerException());



    }

}
