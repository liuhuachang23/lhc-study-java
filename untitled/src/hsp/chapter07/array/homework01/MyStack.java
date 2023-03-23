package hsp.chapter07.array.homework01;
/*
* 题目：
*   编写程序，使用一维数组，模拟栈数据结构。
*
* 要求：
*   1、这个栈可以存储java中的任何引用类型的数据
*   2、在栈中提供push方法模拟压栈。（栈满了，要有提示信息）
*   3、在栈中提供pop方法模拟弹栈。（栈空了，要有提示信息）
*   4、编写测试程序，new栈对象，调用push pop方法来模拟压栈弹栈的动作。
*   5、假设栈的默认初始化容量是10.（请注意无参数构造方法的编写方式）
*
* 提示:
*   public class MyStack{  //栈类
*       //提供一个数组来存储栈中的元素
*       Object[] elements;
*
*       //栈帧（永远指向栈顶元素）
*       //每加一个元素，栈帧+1
*       //每减一个元素，栈帧-1
*       int index;
*
*       //构造方法
*       //构造方法是不是应该给一维数组一个初始化容量
*
*       //push方法
*       //压栈表示栈中多一个元素
*       //但是栈如果已满，压栈失败
*       //这个方法的参数以及返回值类型自己定义
*
*       //pop方法
*       //弹栈表示栈中少一个元素
*       //但是栈如果已空，弹栈失败
*       //这个方法的参数以及返回值类型自己定义
*   }
*
*   main() {
*       测试 ...
*   }
*
* */
public class MyStack {

    //向栈中存储元素，我们这里使用一维数组模拟，存到栈中就表示存到数组中
    //选择Object类型数组，这个栈可以存储java中的任何引用类型数据
    private Object[] elements;
    //下标
    private int index;

    //无参（可以给属性赋默认值）
    public MyStack() {

        //默认初始化容量为10
        this.elements = new Object[10];
        //给index初始化为-1（看后面就知道为什么初始化为-1了）
        this.index = -1;
    }

    //有参
    public MyStack(Object[] elements) {
        this.elements = elements;
    }

    //getter and setter
    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    //压栈方法
    //obj 被压的元素
    public void push(Object obj){
        if (this.index >= elements.length-1){
            System.out.println("栈已满，压栈失败！");
            return;
        }
        //压栈，下标加一，栈帧=此时的下标
        index = index + 1;
        //压栈，向栈中传入参数（obj），传入的参数的位置就是此刻栈帧的位置
        //下面代码就是：elements[0] = obj;
        this.elements[index] = obj;
        //上面两行代码可以合并为
        //this.elements[++index] = obj;

        //在声明一遍：所有的System.out.println()方法执行时，如果输出的引用的话，会自动调用引用的toString()方法
        System.out.println("压栈"+ obj + "元素成功，栈帧指向" + index);
    }

    //弹栈方法
    //从数组里面取元素
    public Object pop(){
        if (index < 0){
            System.out.println("栈空了，弹栈失败！");
            return null;
        }
        System.out.print("弹栈" + elements[index] + "元素成功，");
        index--;
        System.out.println("栈帧指向" + index);
        return null;
    }
}
