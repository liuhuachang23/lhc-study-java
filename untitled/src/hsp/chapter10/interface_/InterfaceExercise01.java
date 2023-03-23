package hsp.chapter10.interface_;
//接口中的成员都是共有的
//接口中的常量可以被其实现类使用，但不能被修改

//
public class InterfaceExercise01 {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb.a);
        System.out.println(AA.a);
        System.out.println(BB.a);
    }
}

interface AA {
    //常量
    int a = 1000; //省略了 public final static
}

class BB implements AA {

}