package hsp.chapter10.singleton;
/*
* 单例设计模式
*   1.所谓单例设计模式,就是采取一定的方法保证在整个的软件系统中,
*     对某个类只能存才在一个对象实例,并且该类只能提供一个取得其对象实例的方法
*   2.单例设计模式分为:饿汉式 和 懒汉式
*
* 单例设计模式的实现
*  1) 构造器私有化 (防止直接new)
*  2) 类的内部创建对象
*  3) 向外提供一个静态公共方法(getInstance)
* */

//单例设计模式的实现 <饿汉式>
//如何确保我们只能创建一个GirlFriend对象
//  1) 构造器私有化 (防止直接new)
//  2) 类的内部创建对象
//  3) 向外提供一个静态公共方法 返回gf对象

//饿汉式 存在的弊端:
//类加载就开始创建对象
//对象,通常是重量级的对象,恶汉模式可能造成创建了对象,但是没有使用
public class SingleTon01 {
    public static void main(String[] args) {
        System.out.println(GirlFriend.getInstance());
    }
}

class GirlFriend{

    private String name;

    //1) 构造器私有化 (防止直接new)
    private GirlFriend(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }


    //2) 类的内部创建对象
    //为了可以在静态方法中,返回gf对象,需要将其修饰为static
    private static GirlFriend gf = new GirlFriend("小红花");

    //3) 向外提供一个静态公共方法 返回gf对象
    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }


}