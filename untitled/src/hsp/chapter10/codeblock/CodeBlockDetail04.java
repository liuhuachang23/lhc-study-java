package hsp.chapter10.codeblock;

/*
 *创建一个子类对象时（静态代码块、静态属性初始化、普通代码块、普通属性初始化、构造方法）的调用顺序
 * */
public class CodeBlockDetail04 {
    public static void main(String[] args) {
        //程序执行顺序:
        //1.进行类的加载 (先加载父类,后加载子类)
        //2.创建对象(子类构造器开始)
        new B02();

    }
}

class A02 { //父类

    private static int n1 = getVl01();

    static {
        System.out.println("A01 的第一个静态代码块..."); //2
    }

    {
        System.out.println("A02 的第一个普通代码块..."); //5
    }

    public int n3 = getVal02();

    public static int getVl01() {
        System.out.println("getVal01"); //1
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02"); //6
        return 10;
    }

    public A02() {
        //隐藏
        //super
        //普通代码块、普通属性 的初始化...
        System.out.println("A02 的构造器");  //7
    }
}

class B02 extends A02 {
    private static int n3 = getVl03();

    static {
        System.out.println("B02 的一个静态代码块..."); //4
    }

    private int n5 = getVal04();

    {
        System.out.println("B02 的一个普通代码块..."); //9
    }

    public static int getVl03() {
        System.out.println("getVl03"); //3
        return 10;
    }

    public int getVal04() {
        System.out.println("getVl04"); //8
        return 10;
    }

    public B02() {
        //super
        //普通代码块、普通属性 的初始化
        System.out.println("B02 的构造器"); //10
    }
}



