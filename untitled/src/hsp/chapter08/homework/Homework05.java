package hsp.chapter08.homework;
//定义一个圆类Circle，定义属性：半径，提供显示圆周长功能的方法，提供显示圆面积的方法
public class Homework05 {
    public static void main(String[] args) {

        //创建对象
        Circle circle = new Circle(4);
        //调用方法计算圆的周长
        double c = circle.perimeter();
        //调用方法计算圆的面积
        double s = circle.area();
        System.out.println("半径为 " + circle.r + " 的圆的周长为 " + c + "面积为 " + s);
    }
}

class Circle{
    //
    double r;

    public Circle(double r){
        this.r = r;
    }
    public double perimeter(){
        return 2*r*3.14;
    }

    public double area(){
        return r*r*3.14;
    }
}
