package com.test005;
/*
* 1.构造方法的作用：
*   *创建对象
*   *对象的同时，初始化实例变量的内存空间。
*
* 2.成员变量之实例变量，属于对象级别的变量，这种变量必须有对象才能有实例变量。
*   实例变量没有手动赋值的时候，系统默认赋值。
*
* 3.那么这个系统默认赋值是在什么时候完成的呢？
*       *是在类加载的时候吗？
*             不是. 因为类加载的时候只加载了代码片段，还没来的来得及创建对象。所以此时实例变量并没有初始化。
*       *实际上，实例变量的内存空间是在构造方法执行过程中完成开辟的，完成初始化
*        系统在默认赋值的时候，也是在构造方法执行过程当中完成的赋值。
* */
public class ConstructorTest02 {
    public static void main(String[] args){

        /*
            怎么查看访问的是那个属性，查看访问的是那个方法？
                按ctrl键，鼠标移动到查看的元素上，出现下划线单击。
            在一个类中元素过多，想快速查看
                在当前类中使用 ctrl + o 快捷键，然后输入要查找的元素名称
        */
        //创建对象
        Account act1 = new Account();

        System.out.println("账号" + act1.getActno()); //null
        System.out.println("余额" + act1.getBalance()); //0.0

        Account act2 = new Account("110");

        System.out.println("账号" + act2.getActno()); //110
        System.out.println("余额" + act2.getBalance()); //0.0

        Account act3 = new Account(100.0);

        System.out.println("账号" + act3.getActno()); //null
        System.out.println("余额" + act3.getBalance()); //100.0

        Account act4 = new Account("110",100.0);

        System.out.println("账号" + act4.getActno()); //100
        System.out.println("余额" + act4.getBalance()); //100.0


    }
}
