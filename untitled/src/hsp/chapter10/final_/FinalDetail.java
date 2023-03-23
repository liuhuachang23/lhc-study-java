package hsp.chapter10.final_;

/*
 * final使用细节
 *
 * <final修饰属性>
 *   1.final修饰的属性称为常量(一般用 XX_XX_XX 来命名
 *   2.final 修饰的属性在定义时,必须赋初始值,并且以后不能在修改 (例子:FinalExercise01)
 *       赋初始值可以在
 *       (1)定义时赋值
 *       (2)构造器中赋值(如果是静态的这种方式不能用)
 *       (3)代码块中赋值(静态在静态代码块,普通在普通代码块)
 *
 * <final修饰类>
 *   1.final类不能被继承,但是可以实例化对象
 *   2.String类 和 8种包装类 都被final修饰了
 *
 * <final修饰方法>
 *   1.不是final类,若含有final修饰的方法,该方法可以被继承,但是不能被重写
 *   2.final不能修饰构造方法(构造器)
 *       final方法是约束子类不能覆盖，但是构造方法本身不允许子类继承。谈不上覆盖。
 *       （构造方法不是通过覆盖得到的，所以没必要用final修饰）
 *
 * <final搭配static>
 *   1.final 和 static 往往搭配使用效率更高,不会导致类加载,底层编译器做了优化处理
 *
 * */
public class FinalDetail {
    //final 和 static 往往搭配使用效率更高,不会导致类加载,底层编译器做了优化处理
    public static void main(String[] args) {
        //这个是static单独使用，static代码块被调用了（类加载了）
        System.out.println(AAA.num);
        //final和static搭配使用，static代码块没有被调用（类没有被加载）
        System.out.println(BBB.num);
    }
}

class AAA {
    public final static int num = 1000;

    static {
        System.out.println("BBB 的静态代码块被执行");
    }
}

class BBB {
    public final static int num = 2000;

    static {
        System.out.println("BBB 的静态代码块被执行");
    }
}




