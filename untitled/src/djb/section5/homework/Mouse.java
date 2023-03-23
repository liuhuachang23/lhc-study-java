package djb.section5.homework;

public class Mouse implements USB{
    @Override
    public void keyboard() {

    }

    public void mouse(){
        System.out.println("成功接入鼠标，请开始使用");
    }

    @Override
    public void display() {

    }

    @Override
    public void printer() {

    }
}
