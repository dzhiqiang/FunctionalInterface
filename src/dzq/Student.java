package dzq;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Student {
    //是不是相当于数据源
    private int age;

    private String name;

    public Student(){

    }

    public Student(int age,String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //内部处理的思想例子
//    public String upperName() {
//        return this.name.toUpperCase();
//    }
//
//    public void operName(Consumer<String> consumer) {
//        consumer.accept(this.name);
//    }
//
//    public String functionName(Function<String, String> function) {
//        return function.apply(this.name);
//    }

    public <T> T supplierTest(Supplier<T> supplier, BiFunction<T, String, T> biFunction) {
        return biFunction.apply(supplier.get(), this.name);
    }

}
