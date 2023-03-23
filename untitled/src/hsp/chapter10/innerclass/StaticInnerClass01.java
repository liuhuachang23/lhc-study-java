package hsp.chapter10.innerclass;

import com.sun.org.apache.bcel.internal.generic.NEW;

/*
 * 静态内部类(定义在外部类的成员位置,并且有static修饰)
 * 1.可以直接访问外部类的所有静态成员,包括私有的,但不能直接访问非静态成员
 * 2.可以添加任意访问修饰符(public protected 默认 private),因为它的地位就是一个成员
 * 3.作用域:和外部类的其他成员一样,为整个类体
 * 4.静态内部类-->访问-->外部类成员(比如属性),直接访问
 * 5.外部类-->访问-->静态内部类
 *      1）访问 静态内部类的静态成员 类名.静态成员（包括属性和方法）
 *      2）访问 静态内部类的非静态成员 先创建对象 引用.非静态成员（包括属性和方法）
 * 6.外部其他类-->访问-->静态内部类
 *      1）访问 静态内部类的静态成员 外部类名.静态内部类名.静态内部类的静态成员（包括属性和方法）
 *      2）访问 静态内部类的非静态成员 (2种方法)
 *
 * 7.如果外部类和静态内部类的成员重名时,静态内部类访问的话,默认就近原则,如果想访问外部类成员,可以使用(外部类.成员)
 *
 * 补充：静态内部类：可以有非静态成员，但是不能访问外部类的非静态成员
 *      原因：这个内部类被声明为static，即该内部类属于外部类的范畴，不依赖于外部类的具体对象，那么该内部类只
 *            能访问外部类的static方法，因为外部类的非static方法依赖于外部类的具体对象
 * */
public class StaticInnerClass01 {
    public static void main(String[] args) {

        Outer10 outer10 = new Outer10();
        //外部类-->访问-->静态内部类(创建对象,在访问)
        outer10.m1();
        System.out.println("================================");
        //外部其他类-->访问-->静态内部类(前提是满足访问控制权限)
        // 1）访问 静态内部类的静态成员: 外部类名.静态内部类名.静态内部类的静态成员（包括属性和方法）
        System.out.println(Outer10.Inner10.name);
        // 2）访问 静态内部类的非静态成员 (两种方式)
        // 方式1
        // 因为静态内部类,是可以通过类名直接访问
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        //方式2
        //编写一个非静态方法,可以返回静态内部类的对象实例
        Outer10.Inner10 inner101 = outer10.getInner101();
        inner101.say();
        //或者编写一个静态方法,可以返回静态内部类的对象实例(相比于上面,这个不需要创建Outer10对象,程序运行更快捷)
        Outer10.Inner10 inner102 = Outer10.getInner102();
        inner102.say();
    }
}

class Outer10 {

    private int n1 = 10;
    private static String name = "张三";

    private static void cry() {
    }

    static class Inner10 {
        static String name = "贾宝玉";
        public void say() {
            //访问外部类的静态属性,直接Outer.name(而不是Outer.this.name)
            System.out.println("内部类name= " + name + " 外部类name= " + Outer10.name);
            cry();
        }
    }

    //外部类-->访问-->静态内部类
    public void m1() {
        //1）访问 静态内部类的静态成员 类名.静态成员（包括属性和方法）
        System.out.println(Inner10.name);
        //2）访问 静态内部类的非静态成员 先创建对象 引用.非静态成员（包括属性和方法）
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    //外部其他类-->访问-->静态内部类
    //编写一个(可以理解为Outer类中的一个成员(Inner08)的get方法,可以返回静态内部类的对象实例
    public Inner10 getInner101() {
        return new Inner10();
    }

    public static Inner10 getInner102() {
        return new Inner10();
    }

}