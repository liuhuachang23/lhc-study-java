package hsp.chapter18.decorator_design_patterns;
//1. 节点流是底层流/低级流，直接跟数据源相接
//2. 处理流对节点流进行包装，使用了 修饰器模式，不会直接与数据源相连

//模拟 装饰器设计模式
public class Test_ {
    public static void main(String[] args) {
        //通过BufferedReader包装流，去读取FileReader节点流
        BufferedReader_ bufferedReader_1 = new BufferedReader_(new FileReader_());
        bufferedReader_1.read();//调用FileReader节点流 里面的方法
        bufferedReader_1.read(5); //也可以调用自己扩展的方法(处理流提供了很多更方便的方法来完成输入输出)

        //通过BufferedReader包装流，去读取StringReader节点流
        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        bufferedReader_2.read();//调用FileString节点流 里面的方法
        bufferedReader_2.read(5);//也可以调用自己扩展的方法
    }
}
