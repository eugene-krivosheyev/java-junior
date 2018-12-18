package demo.exceptionsdemo;

public class ExceptionsDemo {
    public static void main(String[] args) {
        try {
            bl();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bl() throws Exception {
        dal();
        // nop
    }

    private static void dal() throws Exception {
        boolean isOpened = false;
        if (!isOpened) {
            throw new Exception("file.error");
        }
        //
    }
}
