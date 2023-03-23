package hsp.chapter11.homework;

public class Homework03 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();

        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,20);

    }

}

interface ICalculate {
    double work(double n1, double n2);
}

class Cellphone {

    public void testWork(ICalculate iCalculate,double n1,double n2) {
        double result = iCalculate.work(n1, n2); //动态绑定
        System.out.println("计算后的结果是= " + result);
    }
}

