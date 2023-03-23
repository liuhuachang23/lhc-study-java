package hsp.chapter12.stringbuffer;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        //需要看源码，底层调用的是 AbstractStringBuilder 的 appendNull,将 null 变成一个字符数组传入 {'n','u','l','l'}
        sb.append(str);
        System.out.println(sb.length()); //4
        System.out.println(sb); //null

        //下面的构造器会抛出空指针异常
        //底层源码 super(s.length() + 16)，s 就是 sb1 == null，null.length()，空指针异常
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
