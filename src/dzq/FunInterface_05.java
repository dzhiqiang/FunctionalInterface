package dzq;

import java.util.Arrays;
import java.util.List;

public class FunInterface_05 {

    public static void main(String[] args) {

        //内部处理,直接处理name，因为我管理者name
        Student student = new Student("jdk");

//        String name = student.getName();
//        System.out.println(name.toUpperCase());

//        System.out.println(student.upperName());
        //内部处理
        student.operName(name -> System.out.println(name.substring(0,1).toUpperCase() + name.substring(1)));





    }




}
