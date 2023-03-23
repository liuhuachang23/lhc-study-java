package com.test005;

public class Customer {
    //属性
    private int id;
    private String name;
    private int age;
    private String addr;

    //setter and getter方法
    public int getId(){
        return id;
    }

    public void setId(int id){
        //入口处可以设置安全控制

        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        //入口处可以安全控制

        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        //安全控制
        this.age = age;
    }

    public String getAddr(){
        return addr;
    }

    public void setAddr(String addr){
        //安全控制
        this.addr = addr;
    }
}
