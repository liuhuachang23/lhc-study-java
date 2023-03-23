package hsp.chapter10.innerclass;
/*
* 成员内部类(定义在外部类的成员位置,没有static修饰)
*   1.可以直接访问外部类的所有成员,包括私有的
*   2.可以添加任意访问修饰符(public protected 默认 private),因为它的地位就是一个成员
*   3.作用域:和外部类的其他成员一样,为整个类体
*   4.成员内部类-->访问-->外部类成员(直接访问)
*   5.外部类-->访问-->成员内部类(创建对象,在访问)
*   6.外部其他类-->访问-->成员内部类(2种方式)
*   7.如果外部类和成员内部类的成员重名时,成员内部类访问的话,默认就近原则,如果想访问外部类成员,可以使用(外部类.this.成员)
*
* 补充：
*   1.成员内部类：不能含有static成员，但是可以访问外部类的所有成员包括static成员
*     原因：因为内部类是非static的，那么这个内部类就依赖于外部类的具体对象，所以这个内部类可以访问外部的非static成员
*   2.成员内部类：可以有常量,包括static修饰的常量 （例如：static final int b = 1;）
*     因为java中吧常量放在了内存中常量池，加载常量是不需要类加载的
*   
*
* */
public class MemberInnerClass01 {
    public static void main(String[] args) {

        Outer08 outer08 = new Outer08();

        //外部类-->访问-->静态内部类(创建对象,在访问)
        outer08.t1();
        System.out.println("===============================");
        //外部其他类使用成员内部类的2种方式
        //第一种:outer08.new Inner08()
        // (相当于吧 new Inner08() 当做是outer08的成员)
        Outer08.Inner08 inner081 = outer08.new Inner08();
        //或者 Outer08.Inner08 inner081 = new Outer08().new Inner08();
        inner081.say();
        //第二种:在外部类中,编写一个方法(可以理解为Outer类中的一个成员(Inner08)的get方法),可以返回Inner08对象
        //在调用这个方法:outer08.getInner08()
        Outer08.Inner08 inner082 = outer08.getInner08();
        inner082.say();
    }
}

class Outer08{
    private int n1 = 10;
    public String name = "张三";

    private void hi(){
        System.out.println("hi()方法...");
    }

    public class Inner08{
        private double sal = 99.8;
        private int n1 = 66;
        //不能含有static成员
        //static int n2 = 10;
        //可以有常量，包括static修饰的常量
        final int n3 = 100;
        final static int n4 = 20;

        public void say(){
            //Outer08.this 就是 outer08
            System.out.println("n1= " + n1 + " name= " + name + " 外部类的n1= " +Outer08.this.n1);
        }
    }

    //外部类-->访问-->成员内部类(创建对象,在访问)
    public void t1(){
        //使用成员内部类
        //创建成员内部类的对象,在调用相关方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }

    //在外部类中,编写一个方法,可以返回Inner08对象
    public Inner08 getInner08(){
        return new Inner08();
    }
}

class ASD{
    int a = 1;
    static int b = 1;
}