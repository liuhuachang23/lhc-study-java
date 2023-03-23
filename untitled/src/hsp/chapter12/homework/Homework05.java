package hsp.chapter12.homework;

/**
 * @author 刘华昌
 * @version 1.0
 */
public class Homework05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a.name == b.name);
        String s4 = new String("hspedu");
        String s5 = "hspedu";

        System.out.println(s1 == s4);
        System.out.println(s4 == s5);

        //解析：
        //1. 底层会创建一个StringBuilder sb = new StringBuilder()
        //2. 执行 sb.append("hello"); append是在原来字符串上追加的
        //3. 执行 sb.append("hspedu");
        //4. 调用 String t1 = sb.toString() 将StringBuilder转换位String
        //5. 最后其实是 t1 指向 堆 中的对象(String) value[] --在指向--> 池中 "hellohspedu"
        String t1 = "hello" + s1; //t1指向堆中 对象(String) value[]
        String t2 = "hellohspedu"; //t2指向常量池中 "hellohspedu"
        System.out.println(t1 == t2);
        System.out.println(t1.intern() == t2);


    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

}
