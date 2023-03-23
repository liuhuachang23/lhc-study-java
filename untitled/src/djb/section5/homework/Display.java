package djb.section5.homework;

public class Display implements USB{
    @Override
    public void keyboard() {

    }

    @Override
    public void mouse() {

    }

    public void display(){
        System.out.println("成功接入显示器，请开始使用");
    }

    @Override
    public void printer() {

    }
}
