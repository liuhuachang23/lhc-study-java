
package djb.object.inner;

/*
* 不使用匿名内部类
* */

public class Test2 {

    public static void main(String[] args){
        MyMath mm = new MyMath();
        ComputerImpl c = new ComputerImpl();
        mm.mySum( c ,100,100);
    }
}

//定义一个负责计算的接口
interface Compute{
    //抽象方法
    int sum(int a , int b);
}

//写一个实现Computer接口的实现类
class ComputerImpl implements Compute {

    public int sum(int a , int b){
        return a + b;
    }

}

//数学类
class MyMath{
    //数学求和方法
    public void mySum(Compute c , int x , int y){
        int retValue = c.sum(x,y);
        System.out.println(x + "+" + y + "=" + retValue);
    }
}

