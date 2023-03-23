package hsp.chapter12.wrappertype;

public class WrapperExercise01 {
    public static void main(String[] args) {

        Object obj1 = true? new Integer(1) : new Double(2.0);
        System.out.println(obj1); // 1.0

        Object obj2;
        if (true){
            obj2 = new Integer(1);
        } else {
            obj2 = new Double(2.0);
        }
        System.out.println(obj2); // 1

        //为什么两者输出不一样,
        //三元运算符看做一个整体,Integer要提升精度变成Double类型 所以输出1.0
        //下面那个不存在这个问题 输出1
    }
}
