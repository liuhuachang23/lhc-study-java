package djb.section6.string;

/*
 * 关于String类中的构造方法
 *   String s = new String("");
 *   String s = "";
 *   String s = new String(char数组);
 *   String s = new String(char数组,起始下标,长度);
 *   String s = new String(byte数组);
 *   String s = new String(byte数组,起始下标,长度);
 **/
public class StringTest04 {
    public static void main(String[] args) {

        //创建字符串对象最常用的一种方式
        String s1 = "hello";
        System.out.println(s1);

        String s6 = new String("hello world!");
        System.out.println(s6);

        //这里只掌握常用的构造方法

        //将byte数组转换成字符串
        byte[] bytes = {97, 98, 99}; // 97是a，98是b，99是c
        String s2 = new String(bytes);
        //String类已经重写了toString()方法
        //引用自动调用toString()
        //输出结果：abc
        System.out.println(s2);

        //将byte数组中的一部分转换成字符串
        //String（字节数组，数组元素下标的起始位置，长度）
        String s3 = new String(bytes, 1, 2);
        System.out.println(s3);

        //将char数组全部转换成字符串
        char[] chars = {'2','1','3','2'};
        String s4 = new String(chars);
        System.out.println(s4);

        //将char数组中的一部分转换成字符串
        String s5 = new String(chars, 2, 3);
        System.out.println(s5);

    }
}
