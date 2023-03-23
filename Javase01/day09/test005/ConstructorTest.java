package com.test005;

/*
 * 关于java类中的构造方法:
 *   1.构造方法又被称为构造函数/构造器/Constructor
 *   2.构造方法语法结构:
 *      [修饰符列表] 构造方法名 (形式参数列表){
 *          构造方法体;
 *      }
 *   3.回顾普通方法的语法结构;
 *      [修饰符列表] 返回值类型 方法名(形式参数列表){
 *          方法体;
 *      }
 *   4.对于构造方法来说,"返回值类型"不需要指定,并且不能写void,
 *   只要写上void,那么这个方法就变成普通方法了.
 *
 *   5. 对于构造方法来说,构造方法的方法名必须与类名保持一致.
 *
 *   6.构造方法的作用:
 *      通过构造方法的调用,可以创建对象.
 *
 *   7.构造方法怎么用:
 *      -普通方法调用:
 *          方法修饰符中有static: 类名.方法名(实参列表)
 *          方法修饰符中无static: 引用.方法名(实参列表)
 *      -构造方法调用:
 *          new 构造方法名(实参列表)
 *
 *   8.构造方法调用执行后,有返回值吗?
 *      每一个构造方法实际上执行结束之后都有返回值,但是这个"return值;" 这样的语句不需要写,构造方法结束时java程序自动返回值.
 *      并且返回值类型是构造方法所在类的类型.由于构造方法的返回值类型就是类本身,所以构造方法的返回值不需要写.
 *
 *   9.当一个类中没有定义任何返回值的话,系统默认給该系统提供一个无参数的构造方法,这个构造方法称为缺省构造器.
 *
 *   10.当一个类显示的将构造方法定义出来了,那么系统则不再默认为这个类提供缺省构造器.建议开发中手动的为当前类提供无参数构造方法.
 *      因为无参数构造方法太常用了
 *
 *   11.
 *  */

import com.test005.User;

public class ConstructorTest {
    public static void main(String[] args){
        //创建User对象
        //调用User类的构造方法完成对象的创建
        //以下程序创建了4个对象,只要构造的函数调用就会创建对象,并且一定是在"堆内存"中开辟内存空间.
        User u1 = new User();
        User u2 = new User(10);
        User u3 = new User("zhangsan");
        User u4 = new User(10,"zhangsan");

        //对比一下普通方法的调用:

        //方法修饰符中有static: 类名.方法名(实参列表)
        ConstructorTest.doSome(); //ConstructorTest.可以省略,因为该类在

        //方法修饰符中无static: 引用.方法名(实参列表)
        //doOther方法在ConstructorTest类当中,所以要创建ConstructorTest对象
        //创建ConstructorTest对象,调用无参数构造方法
        //一个类中没有任何构造方法的话,系统默认提供一个无参数构造器
        ConstructorTest t = new ConstructorTest();
        t.doOther();
    }
    public static void doSome(){
        System.out.println("do some!");
    }
    public void doOther(){
        System.out.println("do other!");
    }

}
