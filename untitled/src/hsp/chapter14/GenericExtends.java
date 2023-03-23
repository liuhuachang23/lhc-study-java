package hsp.chapter14;

import java.util.List;

import java.util.ArrayList;

/*
 * 泛型的继承和通配符说明
 * 1) 泛型不具备继承性
 *    List<Object> list = new ArrayList<String>() //错误
 * 2) <?> : 支持任意泛型类型
 * 3) <? extends A>: 支持A类及A类的子类, 规定了泛型的上限
 * 4) <? super A>: 支持A类及A类的的父类, 不限于直接父类, 规定了泛型的下限
 *
 * */
public class GenericExtends {
    public static void main(String[] args) {

        //1) 泛型不具备继承性
        //ArrayList<Object> list = new ArrayList<String>(); //错误

        //举例说明下面三个方法的使用
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();

        //调用打印集合方法1
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);
        //可以看出 <?> 支持任意泛型类型

        //调用打印集合方法2
        //printCollection2(list1); //×
        //printCollection2(list2); //×
        printCollection2(list3); //√
        printCollection2(list4); //√
        printCollection2(list5); //√


        //调用打印集合方法3
        printCollection3(list1); //√
        //printCollection3(list2); //×
        printCollection3(list3); //√
        //printCollection3(list4); //×
        //printCollection3(list5); //×


    }

    //2) List<?> 表示 任意的泛型都可以接收
    public static void printCollection1(List<?> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    //3) List<? extends AA> 表示支持 AA类及AA类的子类, 规定了泛型的上限
    public static void printCollection2(List<? extends AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

    //4) List<? super AA> 表示支持 AA类及AA的父类(不限于直接父类), 规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }

}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}
