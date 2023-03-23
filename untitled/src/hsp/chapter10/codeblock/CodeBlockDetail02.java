package hsp.chapter10.codeblock;
//静态代码块，只能调用静态成员
//普通代码块可以使用任何成员
public class CodeBlockDetail02 {
    public static void main(String[] args) {
        C02 c02 = new C02();
    }
}

class C02 {
    private int n1 = 100;
    private static int n2 = 200;

    private void m1() {

    }

    private static void m2() {

    }

    static {
        //静态代码块，只能调用静态成员
        //System.out.println(n1); //错误
        System.out.println(n2); //可以
        //m1(); //错误
        m2(); //可以
    }

    {
        //普通代码块可以使用任何成员
        System.out.println(n1);
        System.out.println(n2);
        m1();
        m2();
    }
}

