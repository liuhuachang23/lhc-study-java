package com.tes006;
/*
* java语言当中方法调用的时候涉及到参数传递问题
* 参数传递实际上传递的是变量中保存的具体值。
*
* int i = 10；
* add(i);等同于add(10);
* */
public class Test01 {
    public static void main(String[] args){
        int i = 10;
        add(i); //add方法调用的时候有，给add方法传递了一个变量i，传的是
        System.out.println("main -->" + i); //10
    }

    public static void add(int i){
        i++;
        System.out.println("add -->" + i); //11
    }
}
