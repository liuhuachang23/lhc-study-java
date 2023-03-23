package hsp.chapter12.homework;
/**
 * 输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
 * 思路分析
 * (1) 遍历字符串，如果 char 在 '0'~'9' 就是一个数字
 * (2) 如果 char 在 'a'~'z' 就是一个小写字母
 * (3) 如果 char 在 'A'~'Z' 就是一个大写字母
 * (4) 使用三个变量来记录 统计结果
 */
public class Homework04 {

    public static void main(String[] args) {
        String s = "qwdADDq2324ww";
        char[] chars = s.toCharArray();
        int ACount = 0;
        int aCount = 0;
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                ACount++;
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                aCount++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                num++;
            }
        }

        System.out.println(" 大写字母= " + ACount + " 小写字母= " + aCount + " 数字= " + num);

    }
}
