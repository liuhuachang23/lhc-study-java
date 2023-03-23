package hsp.chapter07.poly_;

public class PolyExercise02 {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);//20
        s.display();//20
        Base b = s;
        System.out.println(b == s);//T
        //属性没有重写之说，属性的值看的是编译类型
        System.out.println(b.count);//10
        //调用对象的方法，看的是运行类型
        b.display();//20
    }

}

class Base {//父类
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {//子类
    int count = 20;

    public void display() {
        System.out.println(count);
    }
}

