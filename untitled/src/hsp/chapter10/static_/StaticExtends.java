package hsp.chapter10.static_;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/9 20:36
 * @Description: 关于静态属性，静态方法的继承问题
 * 1.静态属性和静态方法可以被子类继承
 * 2.静态属性和静态方法不能被子类重写
 */
public class StaticExtends {
    public static void main(String[] args) {

        //1.静态属性和静态方法可以被继承
        BB.m1(); //父类的静态m1()被调用
        System.out.println(BB.i); //30

        //2.静态属性和静态方法不能被子类重写
        AA aa = new CC();
        aa.m1(); //父类的静态m1()被调用
        System.out.println(aa.i); // 30
    }
}

class AA{

    static int i = 10;


    public static void m1(){
        i = 30;
        System.out.println("父类的静态m1()被调用");
    }
}

class BB extends AA{

}

class CC extends AA{

    static int i = 20;

    public static void m1(){
        System.out.println("子类的静态m1()被调用");

    }
}
