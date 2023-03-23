package djb.section5.接口;

/*
* 接口的基础语法:
*   1.类和类之间叫继承,类和接口之间叫实现(可以看做继承)
*       继承使用extend关键字完成
*       实现使用implements关键字完成
*   2.当一个抽象的类实现接口的话,必须将接口中所有的抽象方法全部实现(重写/覆盖)
* */
public class Test02 {
    public static void main(String[] args) {

        //使用多态
        MyMath2 mm = new MyMathImpl();
        //调用接口里面的方法(面向接口编程)
        System.out.println(mm.sum(1,2));
        System.out.println (mm.sub(2,3));

    }
}

//接口(完全抽象的/特殊的抽象类)
interface MyMath2{
    double PI = 3.1415926;
    int sum(int a, int b);
    int sub(int a,int b);
}

//编写一个实现类(这个类是"非抽象"的类)
class MyMathImpl implements MyMath2 {

    //实现(覆盖/重写)接口中的方法
    public int sum (int a,int b){
        return a + b;
    }
    public int sub (int a,int b){
        return a - b;
    }
}