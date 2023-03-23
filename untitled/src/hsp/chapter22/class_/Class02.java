package hsp.chapter22.class_;

import hsp.chapter22.zoon.Car;

import java.lang.reflect.Field;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/21 09:14
 * @Description: Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "hsp.chapter22.zoon.Car";
        //1.获取到 Car类 对应的类对象
        //<?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
        //cls：显示cls对象，是哪一个类的Class对象
        System.out.println(cls); //class hsp.chapter22.zoon.Car
        //cls.getClass： cls运行类型
        System.out.println(cls.getClass()); //class java.lang.Class

        //2.得到包名
        System.out.println(cls.getPackage().getName()); //hsp.chapter22.zoon

        //3.得到全类名
        System.out.println(cls.getName()); // hsp.chapter22.zoon.Car

        //4.通过cls 创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car); //Car{brand='保时捷', price=2900000, color='黑色'}

        //5.通过反射获取属性(只能得到public的,怎么得到私有的后面讲)
        //1）获取属性（字段）的 class对象，即属性对象
        Field brand = cls.getField("brand");
        //2）属性对象.get(对象) 获取 属性值
        System.out.println(brand.get(car)); // 保时捷

        //6.通过反射给属性(字段)赋值
        //属性对象.set(对象, 值)
        brand.set(car, "五菱宏光");
        System.out.println(brand.get(car)); // 五菱宏光

        //7.遍历car中所有的属性(字段)
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.print(f.getName() + " "); //属性字段 brand price color
        }


    }
}
