package hsp.chapter13.map;

import java.util.*;

@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1001, new Employee("jack", 15000, 1001));
        map.put(1002, new Employee("tom", 18000, 1002));
        map.put(1003, new Employee("mary", 20000, 1003));

        //第一种 entrySet
        Set set = map.entrySet();
        // 1.增强for
        for (Object o : set){
            Map.Entry entry = (Map.Entry) o;
            Employee employee = (Employee) entry.getValue();
            if (employee.getSal() > 18000){
                System.out.println(entry.getKey()+ "-" + entry.getValue());
            }
        }
        //2.迭代器
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            Map.Entry entry = (Map.Entry) o;
            Employee employee = (Employee) entry.getValue();
            if (employee.getSal()>15000){
                System.out.println(entry.getKey() + "-" + employee);
            }
        }
        System.out.println();

        //第二种 使用kaySet

        Set keySet = map.keySet();
        for (Object key : keySet){
            Employee employee = (Employee) map.get(key);
            if (employee.getSal() > 18000){
                System.out.println(key + "-" + map.get(key));
            }

        }
    }
}

class Employee{
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.sal, sal) == 0 &&
                id == employee.id &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sal, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}