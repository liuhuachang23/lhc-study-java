package djb.integer;
/*
* 关于Integer类的构造方法，有两个：
*       Integer(int)
*       Integer(String)
* */
public class IntegerTest03 {
    public static void main(String[] args) {
        //Java9之后就不建议使用了

        //将数字100转换为Integer包装类型（int --> Integer）
        Integer x = new Integer(100);
        System.out.println(x); //100
        //将String类型的数字，转换为Integer包装类型（String --> Integer）
        Integer y = new Integer("123");
        System.out.println(y); //123

        //其他的包装类也是一样，照葫芦画瓢

        //double（基本数据类型） ---> Double（Double包装类）
        Double d = new Double(1.23);
        System.out.println(d); //1.23
        //String（引用数据类型） ---> Double（Double包装类）
        Double e = new Double("3.14");
        System.out.println(e); //3.14
    }
}
