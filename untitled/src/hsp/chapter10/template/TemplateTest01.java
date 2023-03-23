package hsp.chapter10.template;

//模板设计模式
/*
* 例题：
*   有多个类，完成不同的任务job，要求统计得到各自任务的完成时间
* */
public class TemplateTest01 {
    public static void main(String[] args) {

        Sum sum = new Sum();
        sum.calculateTime(); //这里还是需要良好的OOP基础，对多态

        Multiply multiply = new Multiply();
        multiply.calculateTime();

        Template template = new Sum();
        int b = template.a;
        System.out.println(b);
    }
}
