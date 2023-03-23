package hsp.chapter10.interface_;
/*
* 接口的使用细节
*   1)接口不能被实例化
*   2)接口中的所以方法都是public方法，接口中的抽象方法，可以不用abstract修饰（可以省略）
*   3）一个普通的类实现接口，就必须吧接口中的所有方法都实现
*   4）抽象类实现接口，可以不用实现接口的方法
*   5）接口中的属性访问形式：接口名.属性名
*   6）接口不能继承其他的类，但是可以继承其他的多个接口
*       interface A extends B,C{}
*   7）接口的修饰符只能是public 和 默认 （这一点和类一样）
* */
public class InterfaceDetail01 {
    public static void main(String[] args) {

    }
}

interface A{
    int i = 1; //常量
    void work1();
}
interface B extends A{
    void work2();
}

class C implements B{

    @Override
    public void work1() {
    }

    @Override
    public void work2() {
    }
}