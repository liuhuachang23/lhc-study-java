package com.test005;

//账户类
public class Account { // 实例变量/对象变量，必须先有对象才能有对应的实例变量。

    //账号
    private String actno;

    //余额
    private double balance;

    //无参数构造器
    public Account(){
        //初始化实例变量的内存空间，会给默认给如下实例变量赋默认值.
        //actno = null;
        //balance = 0.0;
    }

    //有参数构造器
    public Account(String s){
        actno = s;
        //balance = 0.0;
    }

    public Account(double d){
        //actno = null;
        balance = d;
    }

    public Account(String s,double d){
        actno = s;
        balance = d;
    }

    //setter与getter

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
