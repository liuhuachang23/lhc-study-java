package hsp.chapter12.exception;

public class Exception01 {

    public static void main(String[] args) {
        System.out.println(method()); //3
    }

    public static int method() {
        int i = 1;

        try {
            i++; //i=2
            String[] names = new String[3];
            if (names[1].equals("tom")) { //空指针异常
                System.out.println(names[1]);
            }
            return 1;
        } catch (NullPointerException e) {
            return ++i; //i=3 => 保存到临时变量 temp=3
        } finally {
            ++i; // 4
            System.out.println("i= " + i); // 4
        }

    }
}

