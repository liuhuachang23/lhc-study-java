package hsp.chapter22.homework;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/22 19:59
 * @Description:
 */
public class Homework02 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {
        //1. 获取File类的Class对象
        Class<File> fileClass = File.class;
        //2. 得到File类的所有构造器，并在控制台打印
        Constructor<?>[] declaredConstructors = fileClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors){
            System.out.println("File类的所有构造器：" + constructor);
        }
        //3. 得到这个构造器对象
        Constructor<File> constructor = fileClass.getConstructor(String.class);
        //4. 创建file对象
        File file = constructor.newInstance("d:\\aa.txt");
        //5. 得到 createNewFile() 方法对象
        Method createNewFile = fileClass.getDeclaredMethod("createNewFile");
        // 调用方法
        createNewFile.invoke(file);
        System.out.println("创建文件成功...");
    }
}
