package djb.object.hashcode方法;

/*
*   hashCode方法：
*       在Object中的hashCode方法是怎样的？
*           public native int hashCode();
*
*           这个方法不是抽象方法，带有native关键字，底层调用C++程序。
*
*       hashCode() 方法返回的是哈希码：
*           实际上就是一个java对象的内存地址，经过哈希计算，得出的一个值。
*           所有hashCode()方法的执行结果可以等同看做一个java对象的内存地址。
*
* */
public class Test {
    public static void main(String[] args) {

        Object o = new Object();
        int hashCodeValue = o.hashCode();

        System.out.println(hashCodeValue);  //21685669

        MyClass mc = new MyClass();
        int hashCodeValue2 = mc.hashCode();
        System.out.println(hashCodeValue2); //2133927002
    }
}

class MyClass{
}
