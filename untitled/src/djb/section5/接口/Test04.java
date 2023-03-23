package djb.section5.接口;
/*
* 继承和实现都存在的话,代码怎么写
*       先写 extends 在写implements
* */
public class Test04 {
    public static void main(String[] args) {

        //创建对象
        Flyable f = new Cat();
        f.fly();

        Flyable f2 = new Pig();
        f2.fly();

        Flyable f3 = new Fish();
        f3.fly();
    }
}

class Animal{

}

//接口(一对翅膀)
interface Flyable{
    void fly();
}

//动物类:猫类
//Flyable是一个接口,通过接口查到猫身上,实现飞翔
class Cat extends Animal implements Flyable{
    public void fly(){
        System.out.println("猫起飞");
    }
}

//蛇类
// 没有实现Flyable接口,不能飞
class Snake extends Animal{

}
//猪
//实现Flyable接口,可以飞
class Pig extends Animal implements Flyable{
    public void fly(){
        System.out.println("我是一只会飞的猪");
    }
}

//鱼
//没有继承Animal,默认继承Object类
class Fish implements Flyable{
    public void fly(){
        System.out.println("我是会飞的鱼");
    }
}