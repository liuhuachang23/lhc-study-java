package hsp.chapter08.homework;
/*
将对象作为参数传递给方法

    题目要求:
        (1)定义一个Circle1类,包含一个double型的radius属性代表圆的半径,findArea()方法返回圆的面积
        (2)定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下；
            public void printAreas(Circle c, int times)  //方法签名
        (3)在printAreas方法中打印输出1到times之间的每一个整数半径值，以及对应的面积
            例如：times为5，则输出半径1，2，3，4，5，以及对应的圆面积
        (4)在main方法中调用printAreas()方法，调用完毕后输出当前半径值，程序运行结果如图：
            Radius          Area
            1.0             3.141592653589793
            2.0             12.5663...
            3.0             28.2743...
            4.8             50.2654...
            5.0             78.5398...
*/

public class Homework09 {
    public static void main(String[] args) {

        Circle1 circle = new Circle1();
        PassObject passObject = new PassObject();
        passObject.printAreas(circle ,5);
    }
}

class Circle1{

    double radius;

    public double findAreas(){
        double Areas = Math.PI*radius*radius;
        return Areas;
    }

    //添加setRadius方法，修改半径值
    public void setRadius(double radius){
        this.radius = radius;
    }
}

class PassObject{
    public void printAreas(Circle1 c, int times){
        //打印表头
        System.out.println("Radius\tArea");
        for (double i = 1; i <= times ; i++) {
            //调用setRadius方法，修改半径值
            c.setRadius(i);
            System.out.println( i + "\t\t" + c.findAreas());
        }
    }
}
