package djb.section6.string;
/*
* 分析以下程序创建了几个对象
* */
public class StringTest03 {
    public static void main(String[] args) {
        /*
        * 一共创建了3个
        *   方法区中字符串常量池中有一个："hello"
        *   堆内存当中有两个Sting对象
        * */
        String s1 = new String("hello");
        String s2 = new String("hello");
    }
}
