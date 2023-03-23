package hsp.chapter14.generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericExercise02 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("jack", 10000, new MyDate(1995, 12, 20)));
        list.add(new Employee("jack", 18000, new MyDate(1999, 12, 11)));
        list.add(new Employee("tom", 30000, new MyDate(1997, 11, 22)));
        list.add(new Employee("tom", 10000, new MyDate(1997, 8, 22)));
        list.add(new Employee("mary", 9000, new MyDate(2000, 5, 8)));
        list.add(new Employee("mary", 12000, new MyDate(2000, 5, 2)));

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName().compareTo(o2.getName()) != 0) {
                    return o1.getName().compareTo(o2.getName());
                }
                //下面是对birthday的比较,我们最好吧这个比较,发在MyDate类完成
                /*
                if (o1.getBirthday().getYear() - o2.getBirthday().getYear() != 0) {
                    return o1.getBirthday().getYear() - o2.getBirthday().getYear();
                }
                if (o1.getBirthday().getMonth() - o2.getBirthday().getMonth() != 0) {
                    return o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                }
                if ((o1.getBirthday().getDay() - o2.getBirthday().getDay() != 0)) {
                    return o1.getBirthday().getDay() - o2.getBirthday().getDay();
                }
                return 0;
                */
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        //遍历
        for (Employee e: list) {
            System.out.println(e);
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        if (year - o.year != 0) {
            return year - o.year;
        }
        if (month - o.month != 0) {
            return month - o.month;
        }
        if (day - o.day != 0) {
            return day - o.day;
        }
        return 0;
    }
}
