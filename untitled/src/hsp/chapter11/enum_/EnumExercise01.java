package hsp.chapter11.enum_;

public class EnumExercise01 {
    public static void main(String[] args) {
        Gender boy = Gender.BOY;
        Gender boy1 = Gender.BOY;
        //输出 BOY
        //引用类型输出会自动调用父类的toString方法
        //父类Enum重写了toString,返回的name(常量名名称)
        System.out.println(boy);
        //输出true
        //两个静态的对象,当然是同一个对象
        System.out.println(boy == boy1);
    }
}

enum Gender{
    BOY,GIRL;
}
