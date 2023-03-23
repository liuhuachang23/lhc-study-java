package hsp.chapter14.customgeneric;
/*
 * 自定义泛型方法
 *
 * 基本语法
 *   修饰符<T, R, ...>返回类型 方法名(参数列表){
 *   }
 *
 * 注意细节
 * 1) 泛型方法, 可以定义在普通类中, 也可以定义在泛型类中
 * 2) 当泛型方法被调用时, 类型会确定
 * 3) public void hi(T t){}
 *    该方法不是泛型方法(修饰符后面没有<T..>), 只是使用了泛型
 *
 * */

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class CustomMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        //2. 当调用方法时, 传入参数, 编译器就会确定类型
        car.fly("宝马", 100); //T=String, R=Integer
        car.fly("宝马", 10.1); //T=String, R=Double

        Fish<String, ArrayList> fish = new Fish<>();
        fish.eat(11.3f, new ArrayList()); //U=Float, R=ArrayList
    }
}

//1. 泛型方法可以定义在普通类中,也可以定义在泛型类中
class Car { //普通类

    public void run() {
    } //普通方法

    //<T, R> 就是泛型
    //提供给 fly使用的
    public <T, R> void fly(T t, R r) { //泛型方法
        System.out.println(t.getClass());
        System.out.println(r.getClass());
    }
}

class Fish<T, R> { //泛型类
    public void run() {
    } //普通方法

    //<U, M> 就是泛型
    //方法中既可以使用类定义的泛型,也可以使用声明的泛型
    public <U> void eat(U u, R r) { //泛型方法
        System.out.println(u.getClass());
        System.out.println(r.getClass());
    }

    //该方法不是泛型方法, 修饰符后面没有<T..>
    //只是使用了类声明的 泛型
    public void hi(T t){

    }
}