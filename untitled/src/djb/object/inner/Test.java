package djb.object.inner;

/*
* 匿名内部类：
*
*   1.什么是内部类？
*       内部类：在类的内部又定义了一个新的类，被称为内部类。
*
*   2.内部类的分类：
*       静态内部类：类似于静态变量
*       实例内部类：类似于实例变量
*       局部内部类：类似于局部变量
*
*   3.使用内部类编写代码，可读性差，不建议使用，但是要学，才能看得懂别人写的内部类
*
*   4.匿名内部类是局部内部类的一种。
*       因这个类没有名字而得名，叫匿名内部类
*
* */

public class Test {

    //静态变量
    static String country;
    //静态内部类
    static class Inner1{
    }

    //实例变量
    int age;
    //实例内部类
    class Inner2{
    }

    //doSome方法
    public void doSome(){
        //局部变量
        int i = 100;
        //局部内部类
        class Inner3{
        }
    }

    //doOther方法
    public void doOther(){
        //doSome()方法中的局部内部类Inner3，在doOther()中不能用
    }

}