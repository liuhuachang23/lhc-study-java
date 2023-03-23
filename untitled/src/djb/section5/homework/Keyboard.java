package djb.section5.homework;

public class Keyboard implements USB{
    public void keyboard(){
        System.out.println("成功接入键盘，请开始时用");
    }

    @Override
    public void mouse() {

    }

    @Override
    public void display() {

    }

    @Override
    public void printer() {

    }
}
