package hsp.chapter12.string;

public class StringExercise01 {
    public static void main(String[] args) {
        String a = "hsp"; //a 指向 常量池的 "hsp"
        String b = new String("hsp"); //b 指向 堆中的对象 value，value 再指向 常量池的 "hsp"
        System.out.println(a.equals(b)); //T
        System.out.println(a == b); //F

        //当调用intern方法时，如果常量池已经包含了一个等于此String对象的字符串，则返回池中的字符串
        //否则将此String对象添加到池中，并且返回String对象的引用
        //b.intern() 最终返回的是常量池的地址（对象） "hsp"
        System.out.println(a == b.intern()); //T
        System.out.println("hsp" == b.intern()); //T
        System.out.println(b == b.intern()); // F


    }
}
