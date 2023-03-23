package djb.section5.接口;

/*
* 接口和接口之间支持多继承,那么一个类可以同时实现多个接口吗?
*       可以
*       这种机制弥补了java中,类和类只支持单继承的缺陷.
* */
public class Test03 {
    public static void main(String[] args) {

        //使用多态
        E e =  new H();
        F f = new H();
        G g = new H();

        e.m1();
        f.m2();
        g.m3();

    }
}

//接口和接口

interface X{
}
interface Y{
}
interface Z extends X,Y{    //接口和接口支持多继承
}

//接口和类

interface E{
    void m1();
}
interface F{
    void m2();
}
interface G{
    void m3();
}
//一个类实现多个接口,类似于多继承
class H implements E,F,G{
    //实现E接口的m1
    public void m1(){
        System.out.println("M1");
    }
    //实现F接口的m2
    public void m2(){
        System.out.println("M2");
    }
    //实现G接口的m3
    public void m3(){
        System.out.println("M3");
    }
}