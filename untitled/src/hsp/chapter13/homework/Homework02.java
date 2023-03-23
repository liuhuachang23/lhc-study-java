package hsp.chapter13.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"all"})
public class Homework02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Car car = new Car("宝马", 400000);
        Car car1 = new Car("宾利", 1000000);
        Car car2 = new Car("保时捷", 12000000);
        list.add("jack");
        list.add("mary");
        list.add("luck");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.contains(car));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        ArrayList list1 = new ArrayList();
        list1.add("jack");
        System.out.println(list.containsAll(list1));
        System.out.println(list);


    }
}

class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}