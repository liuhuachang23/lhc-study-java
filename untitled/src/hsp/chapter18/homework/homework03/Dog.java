package hsp.chapter18.homework.homework03;

import java.io.Serializable;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 21:52
 * @Description:
 */
public class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    //SerialVersionUID 序列化的版本号，可以提高兼容性
    private static final long SerialVersionUID = 1L;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

}
