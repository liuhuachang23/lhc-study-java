package hsp.chapter12.homework;
/**
 * 编写方法: 完成输出格式要求的字符串
 * 编写java程序，输入形式为： Han shun Ping的人名，以Ping,Han .S的形式打印
 *       出来    。其中.S是中间单词的首字母
 * 思路分析
 * (1) 对输入的字符串进行 分割split(" ")
 * (2) 对得到的String[] 进行格式化String.format（）
 * (3) 对输入的字符串进行校验即可
 */
public class Homework03 {
    public static void main(String[] args) {
        String name = "Han Shun Ping";
        printName(name);
    }

    public static void printName(String str) {

        if (str == null) {
            System.out.println("名字不能为空");
        }

        String[] s = str.split(" ");
        if (s.length != 3) {
            System.out.println("输入的名字格式不正确");
        }

        char c = s[1].charAt(0);

        String format = String.format("%s,%s .%c", s[2], s[0], c);
        System.out.println(format);

    }
}
