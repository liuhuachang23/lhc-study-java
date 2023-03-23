package hsp.chapter12.wrappertype;
/*
* 包装类型和String类型的转换
* */
public class WrapperVsString {
    public static void main(String[] args) {

        Integer ig = 100;
        String str = "123";
        //包装类 --> String
        //1、字符串拼接
        String str1 = ig + "";
        //2、包装类也有toString方法，直接调用也会返回一个String
        String str2 = ig.toString();
        //3、
        String str3 = String.valueOf(ig);

        //String --> 包装类
        Integer ig1 = Integer.parseInt(str);//Integer.parseInt(str) 返回的是一个int，然后自动装箱，变成Integer
        Integer ig2 = new Integer(str); //构造器

    }
}
