package dzq;

import java.util.function.Consumer;
import java.util.function.Function;

public class Student {
    //是不是相当于数据源
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String upperName() {
        return this.name.toUpperCase();
    }

    public void operName(Consumer<String> consumer) {
        consumer.accept(this.name);
    }

    public String functionName(Function<String, String> function) {
        return function.apply(this.name);
    }
}
