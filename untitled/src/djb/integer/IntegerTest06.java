package djb.integer;
/*
* 总结一下之前遇到的异常：
*   空指针异常：NullPointerException
*   类型转换异常：ClassCastException
*   数组下标越界：ArrayIndexOutOfBoundException
*   数字格式化越界：NumberFormatException
*   算数异常：ArithmeticException
* Integer类当中有哪些常用的方法
*
* */
public class IntegerTest06 {
    public static void main(String[] args) {

        //手动装箱
        Integer x = new Integer(1000);

        //手动拆箱
        int y = x.intValue();
        System.out.println(y);

        //编译可以通过，符合java语法
        //运行报错，不是一个数字不可以包装成一个Integer
        //java.lang.NumberFormatException
        //Integer a = new Integer("中文");

        //重点方法
        //static int parseInt(String s)
        //静态方法，传参String，返回int
        //String --转换为--> int
        int retValue = Integer.parseInt("123");
        System.out.println(retValue + 100); //223
        //实际用途：网页上输入的100实际上是"100"字符串，后台数据库中要
        //求存储100数字，此时java程序需要将"100"字符串转化为100数字

        //照葫芦画瓢
        double reValue2 = Double.parseDouble("3.14");
        System.out.println(reValue2+ 1); //4.140000000000001(精度问题)

        float reValue3 = Float.parseFloat("1.0");
        System.out.println(reValue3 + 1); //2.0

        //-----------------------------------------以下内容作为了解-----------------------------------------

        //static String toBinaryString(int i)
        //静态的：将十进制转换为二进制字符串
        String binaryString = Integer.toBinaryString(2);
        System.out.println(binaryString); // "10"

        //static String toOctalString(int i)
        //静态的：将十进制转换成八进制字符串
        String octalString = Integer.toOctalString(8);
        System.out.println(octalString); // "10"

        //static String toHexString(int i)
        //静态的：将十进制转换成十六进制字符串
        String hexString = Integer.toHexString(16);
        System.out.println(hexString); // "10"

        //valueOf方法：

        //static Integer valueOf(int i)
        //静态的：int --> Integer
        Integer i1 = Integer.valueOf(100);
        System.out.println(i1);

        //static Integer valueOf(String s)
        //静态的：String --> Integer
        Integer i2 = Integer.valueOf("100");
        System.out.println(i2);

    }
}
