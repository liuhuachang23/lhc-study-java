package hsp.chapter12.bignum;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {

        //当我们需要处理很大的整数,long也不够用
        //可以使用BigInteger的类来搞定
        BigInteger bigInteger = new BigInteger("222222222222222222222222222");
        System.out.println(bigInteger);

        //在对BigInteger进行加减乘除运算的时候,不能直接进行,要调用方法
        BigInteger bigInteger1 = new BigInteger("3");
        //加
        System.out.println(bigInteger.add(bigInteger1));
        //减
        System.out.println(bigInteger.subtract(bigInteger1));
        //乘
        System.out.println(bigInteger.multiply(bigInteger1));
        //除
        System.out.println(bigInteger.divide(bigInteger1));

    }
}
