package hsp.chapter12.stringbuilder;

public class StringBuilder01 {
    //1. StringBuilder 继承了 AbstractStringBuilder 类
    //2. 实现了 Serializable , 说明StringBuilder对象是可以串行化(对象可以网络传输,可以保存到文件)
    //3. StringBuilder 是final类 ,不可被继承
    //4. StringBuilder 对象的字符序列仍然是存放在其父类 AbstractStringBuilder的 char[] value; 因此这个字符序列是存放在堆中
    //5. StringBuilder 的方法,没有做互斥处理,即没有synchronize 关键字,因此在单线程的情况下使用 【与StringBuffer的区别】
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
    }

}
