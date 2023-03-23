package djb.integer;
/*
* 1、java中为8种基本数据类型又对应准备了8种包装类，8种包装类属于引用数据类型，父类是Object
* 2、思考：为什么要再提供8种包装类
*   因为8种基本数据类型不够用
*   所以又提供了8种包装类
* */
public class IntegerTest01 {
    public static void main(String[] args) {
        //需求：调用doSome()方法的时候需要传一个数字进去
        //但是数字属于基本数据类型，而doSome()方法参数的类型是Object
        //所以doSome()方法无法接收基本数据类型的数字
        //可以传一个数字对应的包装类进去
        MyInt myInt = new MyInt(100);
        doSome(myInt);
    }

    public static void doSome(Object obj){
        System.out.println(obj);
    }
}
