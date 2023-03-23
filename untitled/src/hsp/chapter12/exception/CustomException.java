package hsp.chapter12.exception;
//自定义异常
public class CustomException {
    public static void main(String[] args) /*throws AgeException*/{
        int age = 1400;
        if (!(age >= 18 && age <= 120)){
            //抛出我们 自定义出来的异常
            //通过构造器，设置信息
            throw new AgeException("年龄要求在18~120");
        }
        System.out.println("您的年龄范围正确");
    }
}
//自定义一个异常
//一般情况下，我们自定义异常是继承RuntimeException
//即把自己自定义异常做成一个运行时异常，
//好处是我们可以使用默认的处理机制
class AgeException extends RuntimeException/*Exception*/ {
    public AgeException(String message) {//构造器
        //自己追一下super()，会发现：
        //这个会将message这个字符串传给RuntimeException的构造器在传给Exception构造器
        //在传给Throwable 里面的 detailMessage
        //呈现运行之后的结果
        super(message);
    }
}
