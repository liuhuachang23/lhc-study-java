package hsp.chapter10.template;

//抽象类
abstract public class Template {
    int a = 100;
    //抽象方法
    public abstract void job();

    public void calculateTime() { //实现方法

        //开始时间
        long start = System.currentTimeMillis();
        //调用job方法
        job(); //动态绑定
        //结束时间
        long end = System.currentTimeMillis();

        System.out.println("任务执行时间：" + (end - start));
    }
}
