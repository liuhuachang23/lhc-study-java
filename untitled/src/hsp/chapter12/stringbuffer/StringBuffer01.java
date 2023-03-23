package hsp.chapter12.stringbuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
        //分析
        //1.StringBuffer 的直接父类 是 AbstractStringBuffer
        //2.StringBuffer 实现了 Serializable, 即StringBuffer对象可以串行化
        //3.在父类中 AbstractStringBuffer 有属性 char[] value (注意:相比于String中的,这个没有final修饰)
        //该 value 数组 存放字符串内容 引用存放在堆中 (相比于String,字符串不会在存放在常量池中,而是直接存放在堆中)
        //4. StringBuffer 是一个 final类,不能被继承.
        StringBuffer stringBuffer = new StringBuffer("hello");


        //String VS StringBuffer
        //1.String 保存的是字符串常量,里面的值不能修改（里面的value地址不可变）,每次String类的更新实际上就是更改地址,效率低.
        // private final char value[]; 里面的值存放在常量池中
        //2.StringBuffer 保存的是字符串变量,里面的值是可以更改的,每次StringBuffer的更新实际上可以内容
        //不用每次更新地址,效率高. char[] value; 里面的值存放在堆中
    }
}
