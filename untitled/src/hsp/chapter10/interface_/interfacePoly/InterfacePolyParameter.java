package hsp.chapter10.interface_.interfacePoly;

public class InterfacePolyParameter {
    public static void main(String[] args) {

        //接口的多态体现
        //接口类型的变量if01 可以指向 实现了IF接口类的对象实例
        IF if01 = new Monster();
        IF if02 = new Car();

        //继承体现了多态
        AAA a1 = new BBB();
        a1 = new CCC();
    }
}

interface IF {
}

class Monster implements IF {
}

class Car implements IF {
}

class AAA {
}

class BBB extends AAA {
}

class CCC extends AAA {
}
