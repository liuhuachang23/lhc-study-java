package hsp.chapter12.string;

public class String01 {
    public static void main(String[] args) {

        //1、String类有很多构造器，构造器重载，常用的有:
        //String s1 = new String();
        //String s2 = new String(String original);
        //String s3 = new String(char[] a);
        //String s4 = new String(char[] a, int startIndex, int count);
        //String s5 = new String(byte[] b);

        //2、String类实现了接口：
        // 接口：Serializable【String 可串行化：可以在网络传输】
        // 接口：Comparable【String 对象可以比较大小】

        //3、String是final类,不能被其他类继承

        //4、String 中有属性: private final char value[]; 用于存放字符串内容
        //一定要注意：value 是一个 final类型，不可以修改（value地址不可修改，不可以指向新的地址，但是单个字符的内容可以变）
        //String 保存的是字符串常量,里面的值不能修改（还是指value的地址不可改变）,每次String类的更新实际上就是更改地址
        String name = "jack";
        name = "tom";
        final char[] value = {'a', 'b', 'c'};
        char[] value2 = {'t', 'o', 'm'};
        //可以，数组里的单个字符可以改变
        value[0] = 'h';
        //报错，value不可指向新的地址
        //value = value2;
    }
}
