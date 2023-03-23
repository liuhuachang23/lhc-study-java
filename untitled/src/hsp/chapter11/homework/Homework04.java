package hsp.chapter11.homework;

public class Homework04 {
    public static void main(String[] args) {
        /*new Person("唐僧", new Vehicle() {
            @Override
            public void work() {
            }
        }).passRiver();*/

        Person person = new Person("唐僧", new Horse());
        person.passRiver();
        person.common();
        person.common();
        person.passRiver();
    }
}

//交通工具接口类
interface Vehicle {
    void work();
}

//马
class Horse implements Vehicle {
    @Override
    public void work() {
        System.out.println("骑白龙马");
    }
}

//船
class Boat implements Vehicle {
    @Override
    public void work() {
        System.out.println("做小船儿");
    }
}

//交通工具工厂
class Factory {

    //私有化构造器
    private Factory() {
    }

    //获取交通工具马
    //采用饿汉式创建马儿对象(马儿不换)
    private static Horse horse = new Horse();
    public static Horse getHorse() {
        return horse;
    }
    //获取交通工具船(船会换)
    public static Boat getBoat() {
        return new Boat();
    }
}

//人
class Person {
    private String name;
    private Vehicle vehicle;

    public Person(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public void passRiver(){
        if (!(vehicle instanceof Boat)){
            vehicle = Factory.getBoat();
        }
        vehicle.work();
    }

    public void common(){
        if (!(vehicle instanceof Horse)){
            vehicle = Factory.getHorse();
        }
        vehicle.work();
    }
}