package hsp.chapter10.innerclass;

/*
 * 1.有一个铃声接口Bell,里面有一个ring方法
 * 2.有一个手机类Cellphone,具有闹钟功能alarmClock,参数是Bell类型
 * 3.测试手机类的闹钟功能,提供匿名内部类(对象)作为参数,打印:懒猪起床了
 * 4.再传入另一个匿名内部类(对象),打印:小伙伴上课了
 * */
public class InnerClassExercise02 {
    public static void main(String[] args) {

        Cellphone cellphone = new Cellphone();

        //传递的是实现了Bell接口的匿名内部类 InnerClassExercise02$1
        //重写ring
        /*
           class  InnerClassExercise02$1 implements Bell {
                        @Override
                        public void ring() {
                            System.out.println("懒猪起床了...");
                        }
                    }
                    new InnerClassExercise02$1 ()
         */
        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了...");
            }
        });

        cellphone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });

    }
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarmClock(Bell bell) { //形参是Bell接口类型
        System.out.println(bell.getClass());
        bell.ring(); //动态绑定 运行类型 InnerClassExercise02$1、InnerClassExercise02$2
    }
}
