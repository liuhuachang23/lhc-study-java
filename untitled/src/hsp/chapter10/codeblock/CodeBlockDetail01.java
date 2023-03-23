package hsp.chapter10.codeblock;

/*
 *1、static 代码块也叫静态代码块，作用是对类进行初始化，而且它随着类的加载而执行，并且只会执行一次
 *   如果是普通代码块，每创建一个对象，就会执行一次
 *2、类什么时候被加载：
 *   （1）创建对象实例时(new)
 *   （2）创建子类对象实例时（父类也会被加载，先加载父类，然后子类）
 *   （3）使用类的静态成员时（静态属性、静态方法）
 *3、普通的代码块。在创建对象实例时，会被隐式的调用
 *   被创建一次就会调用一次
 *   如果只是使用类的静态成员时，普通代码块不会执行
 *   (普通代码块 可以理解为 构造器的补充)
 * */
public class CodeBlockDetail01 {
    public static void main(String[] args) {

        //类被加载的情况举例
        //1.创建对象实例时(new)
        //BB bb = new BB();
        //2.创建子类对象时，父类也会被加载（先加载父类，然后子类）
        //AA aa = new AA();
        //3.使用类的静态成员时（静态属性，静态方法）
        System.out.println(Cat.n1);

        //static代码块 是在类加载时执行的，并且只会执行一次
        //普通代码块，在创建对象时会被隐式调用，并且创建一个对象，就会执行一次
        //DD dd = new DD();
        //DD dd1 = new DD();

        //如果只是使用类的静态成员
        //普通代码块不会被调用（因为没有创建对象）
        //静态代码块一定会执行
        //System.out.println(DD.n1);

    }
}

class DD {
    //静态属性
    public static int n1 = 8888;

    //静态代码块
    static {
        System.out.println("DD 的静态代码 1 块被执行...");
    }

    //普通代码块
    {
        System.out.println("DD 的普通代码块被调用...");
    }
}

class Animal {
    //静态代码块
    static {
        System.out.println("Animal 的静态代码 1 块被调用");
    }
}

class Cat extends Animal {
    //静态属性
    public static int n1 = 999;

    //静态代码块
    static {
        System.out.println("Cat 的静态代码块 1 被执行");
    }
}

class BB {
    //静态代码块
    static {
        System.out.println("BB 的静态代码块 1 被调用...");
    }
}

class AA extends BB {
    //静态代码块
    static {
        System.out.println("AA 的静态代码块 1 被调用");
    }
}
