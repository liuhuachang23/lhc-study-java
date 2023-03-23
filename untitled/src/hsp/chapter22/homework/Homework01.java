package hsp.chapter22.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/22 19:39
 * @Description:
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        //1. 获取PrivateTest的Class对象
        Class<?> aClass = Class.forName("hsp.chapter22.homework.PrivateTest");
        //2. 创建对象
        Object o = aClass.newInstance();
        //3. 操作私有属性
        //3.1 先得name属性的对象
        Field name = aClass.getDeclaredField("name");
        //3.2 爆破
        name.setAccessible(true);
        //3.3 修改属性值
        name.set(o,"tom");
        //4. 操作public方法
        //4.1 得到getName方法对象
        Method getName = aClass.getMethod("getName");
        //4.2 调用
        Object reVal = getName.invoke(o);
        System.out.println(reVal);
    }

}

class PrivateTest {

    private String name = "helloKitty";

    public String getName() {
        return name;
    }
}