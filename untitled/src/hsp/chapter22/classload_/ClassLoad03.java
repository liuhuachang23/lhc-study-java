package hsp.chapter22.classload_;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/21 21:54
 * @Description: 类加载-初始化阶段
 */
public class ClassLoad03 {
    public static void main(String[] args) {
        //分析 类加载的5个阶段（详细讲解初始化阶段）
        //1. 加载阶段：加载B类，并生成 B的Class对象
        //2. 连接阶段
        //   1）验证阶段：确保 Class文件的字节流中包含的信息符合当前虚拟机的要求
        //   2）准备阶段： num = 0;
        //   3）解析阶段：虚拟机将 常量池的 符号引用 替换为 直接引用
        //4. 初始化阶段：
            //1）依次自动收集类中所有静态变量的赋值动作 和静态代码块中的语句，并合并
            /*
                生成一个<clinit>()方法 来完成 收集、合并
                Clinit() {
                    System.out.println("B 静态代码块被执行");
                    num = 300;
                    static int num = 100;
                }
                合并：
                    System.out.println("B 静态代码块被执行");
                    static int num = 100;

             */

        System.out.println(B.num); //使用类的静态属性 会导致类加载

        //创建对象也会导致 类加载
        //就是多了一步 执行构造器
        B b = new B();

        //类加载时，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) { //正因为有这个机制,才能保证某个类在内存中只有一份Class对象
                //...
            }
        }
         */
    }
}

class B{

    static{
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    public B(){
        System.out.println("B 的构造器被执行");
    }

}