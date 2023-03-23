package djb.object.inner;

 /*匿名内部类*/

public class Test3 {
    public static void main(String[] args){
        MyMath2 mm = new MyMath2();
        mm.mySum(new Compute2() {
            public int sum(int a, int b) {
                return a + b;
            }
        },100,200);
    }
}

//定义一个负责计算的接口
interface Compute2{
    //抽样方法
    int sum(int a , int b);
}

//数学类
class MyMath2{
    //数学求和方法
    public void mySum(Compute2 c , int x , int y){
        int retValue = c.sum(x,y);
        System.out.println(x + "+" + y + "=" + retValue);
    }
}
