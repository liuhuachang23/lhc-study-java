package hsp.chapter10.interface_;
/*
1.类型和类型之间的关系

    三种关系：is a （继承）  has a （关联）  like a（实现）

    is a :
        Cat is a Animal (猫是一个动物)
        凡是能够满足 is a 的表示"继承关系"

    has a :
        I has a Pen (我有一支笔)
        凡是能满足 has a 关系的表示"关联关系"
        关联关系通常以"属性"的形式存在.

    like a :
        cooker like a FoodMenu (厨师像一个菜单一样)
        凡是能满足 like a 关系的表示"实现关系"
        实现关系通常是: 类实现接口

2.接口和继承解决的问题不同
    继承的价值主要在于：解决代码的复用性和可维护性
    接口的价值主要在于：设计，设计好各种规范（方法），让其他类去实现这些方法，所以接口更加灵活


3.接口是对java单继承机制的一种补充

4.接口在一定程度上实现代码的解耦【接口规范性 + 动态绑定机制】
*/
public class ExtendsVsInterface {
    public static void main(String[] args) {
        littleMonkey littleMonkey = new littleMonkey("孙悟空");
        littleMonkey.climbing();
        littleMonkey.swimming();
        littleMonkey.flying();
    }
}

class OldMonkey{
    private String name;

    public OldMonkey(String name) {
        this.name = name;
    }

    public void climbing(){
        System.out.println(name + " 会爬树...");
    }

    public String getName(){
        return name;
    }
}

//接口
interface Fish_able{
    void swimming();
}

interface Bird_able{
    void flying();
}

//小猴子继承老猴子，实现·鸟和鱼的接口
class littleMonkey extends OldMonkey implements Fish_able,Bird_able{

    public littleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + " 通过学习，可以像鱼儿一样游泳");
    }

    @Override
    public void flying() {
        System.out.println(getName() + " 通过学习，可以像鸟儿一样飞翔");
    }
}
