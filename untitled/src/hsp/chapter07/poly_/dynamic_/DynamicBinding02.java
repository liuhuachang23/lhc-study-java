package hsp.chapter07.poly_.dynamic_;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/9 15:40
 * @Description: java动态绑定
 * 这里相对于上一个例题做了改动：将 子类的 sum() 和 sum1() 去掉了
 */
public class DynamicBinding02 {
    public static void main(String[] args) {
        //a 的编译类型 A, 运行类型 B
        A1 a1 = new B1();//向上转型
        System.out.println(a1.sum());// 40 -> 30
        System.out.println(a1.sum1());// 30-> 20
    }
}
class A1 {//父类
    public int i = 10;
    //动态绑定机制:

    public int sum() {//父类sum()
        //此时getI还是有动态绑定，调用的是子类的getI()
        return getI() + 10; // 20 + 10
    }

    public int sum1() {//父类sum1()
        //当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用
        return i + 10;//10 + 10
    }

    public int getI() {//父类getI
        return i;
    }
}

class B1 extends A1 {//子类
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

    public int getI() {//子类getI()
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}