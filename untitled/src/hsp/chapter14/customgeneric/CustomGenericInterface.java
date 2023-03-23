package hsp.chapter14.customgeneric;

/*
 * 自定义泛型接口
 *
 * 基本语法
 *   interface 接口名<T, R ...>{
 *   }
 *
 * 注意细节
 * 1) 接口中, 静态成员也不能使用泛型(这个和泛型类规定一样)
 * 2) 泛型接口的类型, 在继承接口或者实现接口时确定
 * 3) 没有指定类型, 默认为Object
 *
 * */
public class CustomGenericInterface {
    public static void main(String[] args) {

    }
}

interface IUsb<U, R> {

    //1. 静态成员不能使用泛型
    //U name;

    //2.
    //普通方法中, 可以使用接口泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    //在jdk8中,可以在接口中使用默认方法, 也可以使用泛型
    default R method(U u) {
        return null;
    }
}

//2.1 在继承接口时 指定泛型接口的类型
interface IA extends IUsb<String, Double> {
}

//当我们去实现IA接口时,因为IA接口在继承IUsb时,指定了U=String, R=Integer
//在实现IUsb接口的方法时, 使用String替换了U, Integer替换了R
class AA implements IA {

    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }

    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}

//2.2 在实现接口时, 直接指定泛型接口的类型
//给U指定了Integer 给R指定了Float
//所以在实现IUsb接口方法时,会使用Integer替换U, Float替换R
class BB implements IUsb<Integer, Float> {

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}

//3. 没有指定类型, 默认为Object
//class CC implements IUsb {}
//等价于class CC implements IUsb<Object, Object>{}
//但是建议使用后面这种写法:
class CC implements IUsb<Object, Object>{

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void hi(Object o) {

    }

    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }
}
