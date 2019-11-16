package dzq;

import java.util.Arrays;
import java.util.List;

public class FunInterface_04 {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("1", "2", "6");

        for (String str : stringList) {
            System.out.println(Integer.parseInt(str) * 2);
        }

        stringList.forEach(str -> System.out.println(Integer.parseInt(str) * 2));
        //控制着数据源
        stringList.stream().map(str -> Integer.parseInt(str)).forEach(integer -> System.out.println(integer * 2));





    }




}
