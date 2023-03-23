package com.test005;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class CustomerTest {
    public static void main(String[] args) {

        //创建顾客对象
        Customer c = new Customer();

        //私有属性不能在外部直接访问,这就是封装
        //c.id = 404;

        //操作入口变成了只能通过set和get方法进行访问
        //在set方法和get方法执行过程中可以进行安全过滤
        c.setId(404);
        c.setName("zhangsan");
        c.setAge(22);
        c.setAddr("江西新余");

        System.out.println(c.getId());
        System.out.println(c.getName());
        System.out.println(c.getAge());
        System.out.println(c.getAddr());
    }
}

