package djb.section6.string;

public class StringTest02 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";

        //分析结果是true还是false
        //true
        // 因为"hello"是存储再字符串常量池当中，所以"hello"不会新建（因为这个对象已经存在了）
        //所以栈中的s1和s2 存储的内存地址相同
        System.out.println(s1 == s2);

        String x = new String("xyz");
        String y = new String("xyz");

        //分析结果是true还是false
        //false
        //虽然"xyz"在字符串常量池当中只创建了一个对象，但现在在堆内存中new了两个对象（存储的内存地址相同）都指向字符串常量池中的xyz对象
        //而在栈中x，y的内存地址指向的是堆内存中的两个对象
        //所以x和y存储的内存地址不相同
        System.out.println(x == y);

        //String类已经重写了equals方法
        //true
        System.out.println(x.equals(y));

        String k = new String("testString");
        //为什么"testString"后面可以加"."
        //因为"testString"是一个String字符串对象，只要是对象都能调用方法
        System.out.println("testString".equals(k)); //相比于k.equals("testString")可以避免空指针异常

    }
}
