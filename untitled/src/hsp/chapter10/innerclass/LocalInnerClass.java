package hsp.chapter10.innerclass;
//局部内部类
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02的hashcode=" + outer02);
    }
}

class Outer02{//外部类
    private int n1 = 100;
    private void m2(){
        System.out.println("Outer02 m2");
    } //私有方法

    public void m1(){//方法
        //1.局部内部类是定义在外部类的局部位置，通常在方法
        //3.不能添加访问修饰符，但是可以使用final修饰(局部变量不能添加访问修饰符,可以使用final修饰)
        //4.作用域：仅仅在定义它的方法或代码块中
        final class Inner02{
            //2可以直接访问外部类的所有成员，包含私有的
            private int n1 = 200;
            //5.局部内部类可以直接访问外部类的成员：n1 m2()
            //7.如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员
            //使用 外部类名.this.成员名 访问
            public void f1(){
                System.out.println("n1= " + n1 + " 外部类的n1= " + Outer02.this.n1);
                m2();
                System.out.println("Outer02.this hashcode=" + Outer02.this);
            }
        }
        //6.外部类在方法中，可以创建Inner02对象，如何调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}