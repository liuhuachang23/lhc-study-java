package hsp.chapter10.template;

//计算任务
//1 + ... +800000
public class Sum extends Template {

    int a = 10;

    //实现Template的抽象方法
    @Override
    public void job() {
        long num = 0;
        for (int i = 1; i <= 800000; i++) {
            num += i;
        }
    }
}
