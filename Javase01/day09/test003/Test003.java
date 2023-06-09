package com.test003;
/*用户测试类

   面向对象包括三大特征
    -封装
    -继承
    -多态

   当前主要讲解的是封装机制,为什么要封装,封装有什么好处?
    封装的好处:
        1.封装之后对于那个事物来说,看不到这个事物比较复杂的那一面,只能看到该事物简单的那一面.
        复杂性封装,对外提供简单的操作入口,照相机就是一个很好的封装的案例,照相机的实现原理非常复杂,
        但是对于使用照相机的人来说,操作起来是非常方便的,他们不需要关心内部实现原理,只要会操作就行.

        2.封装之后才会形成真正的"对象",真正的"独立体"

        3.封装就意味着以后的程序可以重复使用,并且这个事物应该适应性比较强,在任何场合都可以使用.

        4.封装之后,对于对象本身,提高了安全性.[安全性特别高]

 */
public class Test003 {
    public static void main(String[] args){
        //创建用户对象
        User user = new User();

        //访问age
        //读取年龄值【get】
        System.out.println("该用户年龄：" + user.age );

        //修改年龄值【set】
        //这里的age属性显然是完全暴露给外部程序的，对于程序员来说可以操作User对象当中所有的细节，导致User中部分数据不安全
        //不建议这样，建议User类型进行封装，建议在外部程序中不能随意访问User对象当中的属性。
        user.age = 20;

        //读取年龄值【get】
        System.out.println("该用户年龄：" + user.age );
    }
}
