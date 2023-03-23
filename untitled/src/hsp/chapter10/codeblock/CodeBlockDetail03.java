package hsp.chapter10.codeblock;

//构造器的最前面其实隐含了 super() 和 调用普通代码块
//静态相关的代码块，属性初始化，在类加载时，就执行完毕
public class CodeBlockDetail03 {
    public static void main(String[] args) {
        /*
        AAA 的普通代码块...
        AAA() 构造器被调用...
        BBB 的普通代码块...
        BBB 的构造器被调用...
        */
        new BBB();
    }
}

class AAA {
    //普通代码块
    {
        System.out.println("AAA 的普通代码块...");
    }

    //构造器
    public AAA() {
        //(1)super()
        //(2)调用本类的普通代码块
        System.out.println("AAA() 构造器被调用...");
    }
}

class BBB extends AAA {
    {
        System.out.println("BBB 的普通代码块...");
    }

    public BBB() {
        //(1)super
        //(2)调用本类的普通代码块
        System.out.println("BBB 的构造器被调用...");
    }
}
