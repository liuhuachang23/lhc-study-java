package hsp.chapter12.stringbuffer;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/18 15:50 星期三
 * @Operating:
 * @Description: 分析一下程序，并要求画出内存分析图
 */
public class StringBufferExercise03 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a");
        StringBuffer b = new StringBuffer("b");
        operate(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    public static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
        System.out.println(y);
    }
}
