package hsp.chapter12.string;

//String 是一个final类，代表不可变的字符串序列
//字符串是不可变的，一个字符串对象一旦被分配，其内容不可变
public class StringExercise02 {
    public static void main(String[] args) {
        //下面这段代码创建了几个对象

        //2个
        String s1 = "hsp";
        s1 = "hah";

        //2个?
        String string = new String();
        string = "hsp";
        string = "hha";

        //1一个
        //编译器,会做优化,判断创建的常量池对象,是否有引用指向
        //优化等价-->String a = "helloabc";
        String s2 = "hello" + "abc";

        //3个
        String a = "hello";
        String b = "abc";
        String c = a + b;
        //分析：String c = a + b;
        //1. 先创建一个StringBuilder sb = new StringBuilder()
        //2. 执行 sb.append("hello");
        //3. 执行 sb.append("abc"); append是在原来字符串上追加的
        //4. 调用 String c = sb.toString()
        //5. 最后其实是 c 指向 堆 中的对象(String) value[] --在指向--> 池中 "helloabc"
        //结论:
        // String s = "abc" + "cd"; 常量相加 , 看的是池
        // String c1 = a + b; 变量相加,是在堆中
        // String c2 = "abc" + b; 也当成变量相加，在堆中
        String d = "helloabc";
        System.out.println(c == d); // F
        System.out.println(s2 == d); // T


    }
}
