package hsp.chapter12.bignum;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        //当我们需要处理很大的小数,double也不够用
        //可以使用BigDecimal
        BigDecimal bigDecimal = new BigDecimal("222.222222223333222233334448");
        System.out.println(bigDecimal);

        //同理BigDecimal进行基本运算,也要调用相应方法
        BigDecimal bigDecimal1 = new BigDecimal("3");

        //加
        System.out.println(bigDecimal.add(bigDecimal1));
        //减
        System.out.println(bigDecimal.subtract(bigDecimal1));
        //乘
        System.out.println(bigDecimal.multiply(bigDecimal1));
        //除
        //这里的结果可能是无限小数 就 可能会抛出异常(ArithmeticException)
        //System.out.println(bigDecimal.divide(bigDecimal1));
        //怎么解决:在调用divide方法时,指定精度即可
        //如果有无限循环小数,就保留分子的精度
        System.out.println(bigDecimal.divide(bigDecimal1,BigDecimal.ROUND_CEILING));

    }
}
