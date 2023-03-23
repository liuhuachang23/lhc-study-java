package hsp.chapter22.reflection;

import java.lang.reflect.Field;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/22 18:29
 * @Description: 演示反射操作属性
 */
public class ReflectionAccessField {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        //得到Student类对应的 Class对象
        Class<?> stuClass = Class.forName("hsp.chapter22.reflection.Student");
        //创建对象
        Object o = stuClass.newInstance();
        System.out.println(o.getClass());
        //1.使用反射，获取public属性对象
        Field age = stuClass.getField("age");
        //2.通过反射来 修改属性值
        age.set(o, 18);
        System.out.println(o); //Student[age=18，name=null]
        System.out.println(age.get(o)); //18

        //3. 使用反射，来获取private属性对象
        Field name = stuClass.getDeclaredField("name");
        //4.爆破，可以操作private属性
        name.setAccessible(true);
        //5.通过反射，修改属性值
        name.set(o, "吴小文");
        System.out.println(o); //Student[age=18，name=吴小文]
        System.out.println(name.get(o)); //吴小文
        //o（对象） 可以替换为 null，因为name是静态属性，name属于类中所有对象，无需指定对象
        name.set(null, "吴小文~");
        System.out.println(o); //Student[age=18，name=吴小文~]
        System.out.println(name.get(null)); //吴小文~
    }

}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student[age=" + age + "，name=" + name + "]";
    }
}