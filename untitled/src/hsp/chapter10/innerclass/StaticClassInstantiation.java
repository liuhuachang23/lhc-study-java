package hsp.chapter10.innerclass;

/*
 * 关于静态类的实例化问题
 *
 * */
public class StaticClassInstantiation {
    public static void main(String[] args) {

        //在外部其他类中去访问
        //不创建对象就可以访问的
        Outer.B();
        System.out.println(Outer.b);
        Outer.Inner.D();
        System.out.println(Outer.Inner.d);
        System.out.println("=======================");
        //需要创建对象才能访问的
        //第一种:在外部类的成员，需要创建外部类对象，来访问
        Outer outer = new Outer();
        System.out.println(outer.a);
        outer.A();
        System.out.println("-----------------------");
        //第二种：在静态内部类的成员，需要创建静态内部类的对象，来访问
        //（将静态内部类也当成外部类的成员，我们需要访问这个静态内部类里面的非静态成员，就需要将静态内部类实例化）
        System.out.println(new Outer.Inner().c);
        new Outer.Inner().C();
        System.out.println("=======================");

        outer.E();
        outer.F();

    }
}

//创建一个类
class Outer {//外部类

    int a = 1;
    static int b = 1;

    public void A() {
        System.out.println("外部类的普通方法...");
    }
    public static void B() {
        System.out.println("外部类的静态方法...");
    }

    //静态内部类
    static class Inner {
        int c = 10;
        static int d = 100;

        public void C() {
            System.out.println("静态内部类的普通方法...");
        }
        public static void D() {
            System.out.println("静态内部类的静态方法...");
        }
    }

    //在外部类访问静态内部类的静态成员,直接调用
    public void E(){
        System.out.println(Inner.d);
        Inner.D();
    }
    //在外部类访问静态内部类的非静态成员，也要将静态内部类实例化
    public void F(){
        Inner inner = new Inner();
        inner.C();
        System.out.println(inner.c);
    }

}

