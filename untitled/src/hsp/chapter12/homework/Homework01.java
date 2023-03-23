package hsp.chapter12.homework;

import java.util.Calendar;

//1.将字符串中指定部分进行反转.比如将"abcdef"反转为"aedcbf"
public class Homework01 {

    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("===交换前===");
        System.out.println(str);
        try {
            str = reverse(str, 3, 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("===交换后===");
        System.out.println(str);
    }

    public static String reverse(String str, int start, int end) {

        //对输入的参数做一个验证
        //设计思路:
        //先写出正确的情况,在取反
        if (!(str != null && start >= 0 && start < end && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        char temp;
        /*for (int i = start; i < end / 2 + 1; i++) {
            temp = chars[i];
            chars[i] = chars[end - i + 1];
            chars[end - i + 1] = temp;
        }*/
        //代码优化,换一种思路去交换,更好理解
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        return String.valueOf(chars);
    }

}
