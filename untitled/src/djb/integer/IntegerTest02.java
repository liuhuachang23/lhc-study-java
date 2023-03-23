package djb.integer;
/*
1、8种基本数据类型对应的包装类名

    基本数据类型              包装类型
----------------------------------------------------------------------
    byte                    java.lang.Byte          （父类是Number）
    short                   java.lang.Short         （父类是Number）
    int                     java.lang.Integer       （父类是Number）
    long                    java.lang.Long          （父类是Number）
    float                   java.lang.Float         （父类是Number）
    double                  java.lang.Double        （父类是Number）
    boolean                 java.lang.Boolean       （父类是Object）
    char                    java.lang.Character     （父类是Object）

2、现在只讲Integer，其他的照葫芦画瓢

3、八种包装类其中有六个都是数字对应的包装类，他们的父类都是Number，可以先研究一下Number中公共的方法：
   Number是一个抽象类，无法实例化对象
   Number类中有这样的方法:
        byte byteValue() 返回指定号码作为值 byte ，这可能涉及舍入或截断。
        abstract double doubleValue() 返回指定数字的值为 double ，可能涉及四舍五入。
        abstract float floatValue() 返回指定数字的值为 float ，可能涉及四舍五入。
        abstract int intValue() 返回指定号码作为值 int ，这可能涉及舍入或截断。
        abstract long longValue() 返回指定数字的值为 long ，可能涉及四舍五入或截断。
        short shortValue() 返回指定号码作为值 short ，这可能涉及舍入或截断。

        这些方法其实所有的数字包装类的子类都有，这些方法就是负责拆箱

*/
public class IntegerTest02 {
    public static void main(String[] args) {

        //123这个基本数据类型，进行构造方法的包装达到了：基本数据类型向引用数据类型的转换
        //基本数据类型---->引用数据类型（装箱）
        Integer i = new Integer(123);

        //将引用数据类型---->基本数据类型（拆箱）
        float f = i.floatValue();
        System.out.println(f); //123.0

        //将引用数据类型---->基本数据类型（拆箱）
        int retValue = i.intValue();
        System.out.println(retValue);

        System.out.println();
    }
}
