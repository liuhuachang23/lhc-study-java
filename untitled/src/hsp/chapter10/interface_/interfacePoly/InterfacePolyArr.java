package hsp.chapter10.interface_.interfacePoly;

public class InterfacePolyArr {
    public static void main(String[] args) {

        //多态数组 --> 接口类型数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();

        //给数组中，存放Phone和Camera对象，phone类还有一个特有的方法call()
        //遍历数组，且输出call方法
        for (int i = 0; i <usbs.length ; i++) {
            usbs[i].work();//动态绑定
            if (usbs[i] instanceof Phone){
                ((Phone)usbs[i]).call();
            }
        }
    }
}

interface Usb{
    void work();
}

class Phone implements Usb{

    public void call(){
        System.out.println("手机可以打电话...");
    }

    @Override
    public void work() {
        System.out.println("手机工作中...");
    }
}

class Camera implements Usb{

    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}