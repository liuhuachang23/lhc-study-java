package hsp.chapter22.classload_;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/21 21:31
 * @Description: 类加载-连接(准备)阶段
 */
public class ClassLoad02 {
    public static void main(String[] args) {

    }
}

class A{
    // 属性-成员变量-字段
    //发现 类加载的连接阶段，属性是如何处理的
    public int n1 = 10; //实例属性，不是静态属性，因此在连接阶段，是不会分配内存的
    public static int n2 = 20; //静态属性，分配内存 默认初始化 0 （20 是 要到后面 初始化阶段）
    public static final int n3 = 30; //是static final 常量，他和静态变量不一样，一旦赋值就不可变，所以默认初始值 30


}
