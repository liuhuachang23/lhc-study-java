package hsp.chapter12.wrappertype;

public class Integer01 {
    public static void main(String[] args) {

        //演示 int <---> Integer (装箱和拆箱)

        //jdk5之前是手动装箱和拆箱
        //手动装箱 int --> Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = integer.valueOf(n1);
        //手动拆箱 Integer --> int
        int i1 = integer.intValue();

        //jdk5之后支持自动装箱和拆箱
        int n2 = 200;
        //自动装箱
        Integer integer2 = n2; //底层调用的是 Integer.valueOf(n2)
        //自动拆箱
        int i2 = integer2; //底层调用的是 intValue()方法


    }
}
