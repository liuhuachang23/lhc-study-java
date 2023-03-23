package djb.section5.homework;

public class Printer implements USB{
    @Override
    public void keyboard() {

    }

    @Override
    public void mouse() {

    }

    @Override
    public void display() {

    }

    public void printer(){
        System.out.println("成功接入打印机，请开始使用");
    }
}
