package hsp.chapter07.array.homework01;

public class MyStackTest {
    public static void main(String[] args) {
        //创建一个栈对象
        MyStack stack = new MyStack();

        //调用压栈方法，进行压栈
        //压栈java.lang.Object@14ae5a5元素成功，栈帧指向0
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());
        stack.push(new Object());


        //调用弹栈方法，进行弹栈
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();


    }
}
