package djb.object.tostring;
/*
* 关于Object类中的toString方法
*
*   1.源代码长什么样子？
*       public String toString() {
*           return this.getClass().getName() + "@" + Integer.toHexString(hashCode());
*       }
*       源代码上toString()方法的默认实现是：
*           类名@对象的内存地址转换为十六进制的形式
*
*   2. SUNG公司设计toString()方法的目的是什么？ 作用是什么？
*       toString()方法的设计目的是：通过调用这个方法可以将一个"java对象"转换成"字符串表示形式"
*
*   3.其实SUN公司开发java语言的时候，建议所有的子类都去重写toString()方法。
*   toString()方法应该是一个简介的、详实的、易阅读的。
* */
public class toString {

    public static void main(String[] args) {
        MyTime t1 = new MyTime(1970,1,1);
        String s1 = t1.toString();

        //MyTime类重写toString()方之前的结果
        System.out.println(s1);  //MyTime@14ae5a5

        //MyTime类重写toString()方之后的结果
        System.out.println(s1);  //1970年1月1日

        //其他输出调用方式
        System.out.println(t1.toString());
        System.out.println(t1); //注意：输出引用的时候会自动调用toString方法

    }
}

class MyTime extends Object{
    int year;
    int month;
    int day;

    public MyTime() {
    }

    public MyTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //重写toString()方法，怎么重写？
    //越简洁、可读性越强越好，向简洁的、详实的、易阅读的方向发展。
    public String toString(){
        return this.year + "年" + this.month + "月" + this.day + "日";
    }
}
