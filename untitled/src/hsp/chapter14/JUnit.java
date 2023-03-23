package hsp.chapter14;


/*
* JUnit
*
* 1.为什么需要JUnit
*   1) 一个类有很多功能代码需要测试, 为了测试, 就需要写入到main方法中
*   2) 如果有多个代码测试, 就需要来回注销, 切换很麻烦
*   3) 如果可以直接运行一个方法, 就方便很多, 并且可以给出相关信息, 就好了
*
* 2.JUnit基本介绍
*   1) JUnit是一个java语言的单元测试框架
*   2) 多数java开发环境都已经集成了JUnit作为单元测试的工具
*
* 3.Junit的简单使用
*   在方法前加 @Test
*   导入 import org.junit.jupiter.api.Test;
* */
public class JUnit {
    public static void main(String[] args) {

        //传统方法调用下面两个方法
        //new JUnit().m1();
        //new JUnit().m2();
    }

    public void m1(){
        System.out.println("m1方法被调用");
    }

    public void m2(){
        System.out.println("m2方法被调用");
    }
}
