package dzq.functionalinterface;

public class FunInterface_03 {

    public static void main(String[] args) {

        test(() -> {
            System.out.println("hello functionalinterface");
        });
        test(()->{
            System.out.println("hello functionalinterface1");
            System.out.println("hello functionalinterface2");
            System.out.println("hello functionalinterface3");
            System.out.println("hello functionalinterface4");
        });
    }


    public static void test(FunInterface_02 funInterface_02) {
        funInterface_02.test();
    }

}
