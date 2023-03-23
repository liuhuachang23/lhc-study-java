package hsp.chapter14.customgeneric;

/*
 * 自定义泛型
 *
 * 基本语法
 *  class 类名<T,R...>{ //表示可以有多个泛型
 *     成员
 *  }
 *
 * 注意细节
 * 1) 普通成员可以使用泛型(属性,方法)
 * 2) 使用泛型的数组,不能初始化
 * 3) 静态方法和静态属性不能使用类的泛型
 * 4) 泛型的类型,是在创建对象时确定的(因为创建对象时,需要指定确定类型)
 * 5) 如果在创建对象时,没有指定类型,默认为Object
 *
 * */
@SuppressWarnings({"all"})
public class CustomGeneric_ {
    public static void main(String[] args) {
        //T=Double, R=String, M=Integer
        Tiger<Double, String, Integer> g = new Tiger<>("john");
        g.setT(10.9); //ok
        //g.setT("yy"); //错误 T=Double
        System.out.println(g); //Tiger{name='john', t=10.9, r=null, m=null}

        Tiger g2 = new Tiger("john"); //默认 T=Object, R=Object, M=Object
        g2.setT("yy"); // ok
        System.out.println(g2); //Tiger{name='john', t=yy, r=null, m=null}
    }
}

//解读:
//1. Tiger 后面是泛型, 所以我们吧 Tiger 就称为自定义泛型类
//2. T, R, M 等单个的大写字母为泛型的标识符
//3. 泛型标识符可以有多个,表示有多个泛型
//4. 普通成员可以使用泛型 (属性, 方法)
//5. 静态方法和静态属性不能使用泛型
class Tiger<T, R, M> {
    String name;
    T t; // 属性可以使用泛型
    R r;
    M m;

    //2. 使用泛型的数组,不能初始化
    //因为数组在new的时候,无法确定数组(T)的类型, 就无法在内存中开辟空间
    //T [] ts = new T[8] //报错

    //3.静态方法和静态属性不能使用泛型
    //因为静态和类相关的,在类加载时,对象还没有创建
    //所以静态方法和静态属性使用了泛型,JVM就无法完成初始化
    //public static void m1(M m){}

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(String name, T t, R r, M m) { //构造器可以使用泛型
        this.name = name;
        this.t = t;
        this.r = r;
        this.m = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) { //方法可以使用泛型
        this.t = t;
    }

    public R getR() { //返回值类型可以使用泛型
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", t=" + t +
                ", r=" + r +
                ", m=" + m +
                '}';
    }
}
