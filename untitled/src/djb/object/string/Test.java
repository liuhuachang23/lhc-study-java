package djb.object.string;

/*
 * 1、java语言当中的字符串String 已经重写了 toString()方法 和 equals
 *
 * 2. 比较两个字符串不能使用"==",必须使用equals
 *
 *  大结论：
 *      java中比较基本数据类型是否相等，使用"=="
 *      java中比较所有的引用数据类型是否相等，使用equals方法
 *
 * */

public class Test {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "abc";

        String s3 = new String("Test1");
        String s4 = new String("Test1");

        //比较两个字符串用equals
        //String类已经重写equals方法了
        System.out.println(s3.equals(s4)); //结果为true，可以证明String重写了equals方法

        //String类 已经重写了toString()方法
        String x = new String("动力节点");
        System.out.println(x.toString()); //输出结果为 动力节点  说明String类 已经重写了toString()方法
    }
}
