package hsp.chapter14.generic;

import java.util.ArrayList;

/*
 * 泛型使用的注意事项和细节
 * 1. interface List<T> {}，public class HashSet<E> {} ..等等
 * 说明：T、E 只能是引用类型
 *
 * 2. 在指定泛型类型的具体类型后，可以传入该类型的或者其子类类型
 *
 * 3. 泛型使用形式
 *  ArrayList<Integer> list = new ArrayList<Integer>();
 *  ArrayList<Integer> list3 = new ArrayList<>();  //简写
 *
 * 4. 泛型是默认存在的，当我们没有写，会默认为Object类型
 *  ArrayList list = new ArrayList(); 等价于：
 *  ArrayList<Object> list = new ArrayList<>();
 * */
public class GenericDetail {
    public static void main(String[] args) {

        //1.泛型，只能是引用类型
        ArrayList<Integer> list = new ArrayList<>(); //正确
        //ArrayList<int> list1 = new ArrayList<>(); //报错

        //2.在指定泛型类型的具体类型后，可以传入该类型的或者其子类类型
        //说明：因为E 指定了A类型，构造器可以传入 new A{}
        Pig<A> aPig = new Pig<A>(new A());
        aPig.show(); //A
        Pig<A> bPig = new Pig<A>(new B());
        bPig.show(); //B

        //3.泛型的使用形式
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //在实际开发中，我们往往简写
        //编译器会进行类型判断，推荐使用简写
        ArrayList<Integer> list3 = new ArrayList<>();

        //4. 泛型是默认存在的，当我们没有写，会默认为Object类型
        ArrayList list4 = new ArrayList(); //等价于：ArrayList<Object> list5 = new ArrayList<>();

    }
}

class A {
}

class B extends A {
}

class Pig<E> {
    E e;

    public Pig(E e) {
        this.e = e;
    }

    public void show() {
        System.out.println(e.getClass());
    }
}