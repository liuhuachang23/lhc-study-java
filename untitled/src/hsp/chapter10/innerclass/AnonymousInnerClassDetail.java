package hsp.chapter10.innerclass;

//匿名内部类的使用细节和注意事项和局部内部类相似（地位都是局部变量）
public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();
        System.out.println("main Outer的hashcode=" + outer05);
    }
}

class Outer05{
    private int n1 = 99;
    public void f1(){
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符,因为它的地位就是一个局部变量
        //作用域:仅仅在定义它的方法或代码块中
        Person p = new Person(){
            private int n1 = 88;
            @Override
            public void hi() {
                //可以直接访问外部类的所有成员
                //如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员
                //使用 外部类名.this.成员名 访问
                System.out.println("匿名内部类重写了hi方法 hi=" + n1 + "外部的n1=" + Outer05.this.n1);
                //Outer05.this就是调用f1的对象 (outer05)
                System.out.println("Outer05.this hashcode= " + Outer05.this);
            }
        };
        p.hi();//动态绑定,运行类型是Outer05$1

        //也可以直接调用,匿名内部类本身也是返回对象
        //class 匿名内部类 extends Person{}
        new Person(){
            @Override
            public void hi() {
                System.out.println("匿名内部类重写了 hi 方法");
            }

            @Override
            public void ok(String str) {
                super.ok(str);  //调用父类（Person）的 ok()方法
            }
        }.ok("jack");

    }
}

class Person{ //类
    public void hi(){
        System.out.println("Person hi()");
    }
    public void ok(String str){
        System.out.println("Person ok()" + str);
    }
}