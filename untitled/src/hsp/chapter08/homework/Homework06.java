package hsp.chapter08.homework;
//设计一个Dog类，有名字，有颜色和年龄属性，定义输出方法show()显示其信息。并创建对象，进行测试
//提升：this 属性
public class Homework06 {
    public static void main(String[] args) {

        Dog dog = new Dog("小八", "白色", 5);

        System.out.println("dog.name = " + dog.name + "\t dog.colour = " + dog.colour + "\t dag.age = " + dog.age);
    }
}

class Dog{
    String name;
    String colour;
    int age;

    public Dog(String name, String colour, int age){
        this.name = name;
        this.colour = colour;
        this.age = age;
    }
}
