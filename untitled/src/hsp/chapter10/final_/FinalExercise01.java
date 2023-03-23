package hsp.chapter10.final_;



//final修饰的属性(常量)的三种赋值方式
//1.定义时赋值
//2.构造器中赋值(如果是静态的这种方式不能用)
//3.代码块中赋值(静态在静态代码块,普通在普通代码块)
public class FinalExercise01 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println("面积 = " + circle.calArea());
    }
}

class Circle {
    private double radius;

    //1.定义时赋值
    //private final double PI = 3.14;

    //定义时没赋值
    private final double PI ;

    //2.构造器 中赋值
    public Circle(double radius) {
        this.radius = radius;
        //PI = 3.14;
    }

    //3.代码块中赋值
    {
        PI = 3.14;
    }

    //求面积方法
    public double calArea() {
        return PI * radius * radius;
    }
}
