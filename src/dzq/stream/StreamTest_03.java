package dzq.stream;

import java.util.stream.Stream;

public class StreamTest_03 implements AutoCloseable{



    public static void main(String[] args) {

        try (StreamTest_03 streamTest_03 = new StreamTest_03()) {
            System.out.println("streamTest_03" + streamTest_03);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("close");
    }
}
