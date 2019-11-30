package dzq.functionalinterface;

import java.util.function.*;

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

    public void soutAge(int age){
        System.out.println(age);
    }

    public int methodReferenceTest(Function<String,Integer> function) {
        return function.apply(this.name);
    }
    public String methodReferenceTest1(BiFunction<String,String,String> biFunction) {
        return biFunction.apply(this.name, this.name);
    }


    public boolean methodReferenceTest2(BiPredicate<String,String> predicate) {
        return predicate.test(this.name, this.name);
    }

    public Student methodReferenceTest3(BiFunction<Integer, String, Student> biFunction) {
        return biFunction.apply(this.age + 1, this.name + "methodReferenceTest3");
    }

    public void methodReferenceTest4(BiConsumer<Integer, String> biConsumer) {
        biConsumer.accept(this.age + 1, this.name + "methodReferenceTest3");
    }
}
