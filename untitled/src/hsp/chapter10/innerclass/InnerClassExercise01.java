package hsp.chapter10.innerclass;
//匿名内部类的最佳实践
//1.当做实参传递,简洁高效
public class InnerClassExercise01 {
    public static void main(String[] args) {
        //传统方法:创建一个类,实现接口
        //f1(new Picture());

        //方法2：将匿名内部类当做实参传递,简洁高效
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一幅名画...");
            }
        });
    }

    //静态方法,形参是接口类型
    public static void f1(IL il){
        il.show();
    }
}

//接口
interface IL{
    void show();
}

//传统方法实现IL类：
//类-->实现-->编程领域(硬编码)
//硬编码:这个修改了,那么所有的Picture类将修改
//所以我们一般不采用这种传统方式
class Picture implements IL{

    @Override
    public void show() {
        System.out.println("这是一幅名画...");
    }
}

