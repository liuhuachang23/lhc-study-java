package hsp.chapter07.poly_.dynamic_;
/**
 * @Auther: 刘华昌
 * @Date: 2022/4/9 15:40
 * @Description: java动态绑定
 */
public class DynamicBinding {
    public static void main(String[] args) {
        //a 的编译类型 A, 运行类型 B
        A a = new B();//向上转型
        //当调用对象的方法时，动态绑定
        System.out.println(a.sum());// 40
        System.out.println(a.sum1());// 30
    }
}

class A {//父类
    public int i = 10;
    //动态绑定机制:

    public int sum() {//父类sum()
        return getI() + 10;
    }

    public int sum1() {//父类sum1()
        return i + 10;
    }

    public int getI() {//父类getI
        return i;
    }
}

class B extends A {//子类
    public int i = 20;

    public int sum() {
       return i + 20; // 20 + 20
    }

    public int getI() {//子类getI()
        return i;
    }

    public int sum1() {
        return i + 10; // 20 + 10
    }
}
