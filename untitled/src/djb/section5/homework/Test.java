package djb.section5.homework;

public class Test {
    public static void main(String[] args) {

        USB usb1 = new Keyboard();
        USB usb2 = new Mouse();
        USB usb3 = new Display();
        USB usb4 = new Printer();

        Computer c1 = new Computer(usb1);
        Computer c2 = new Computer(usb2);
        Computer c3 = new Computer(usb3);
        Computer c4 = new Computer(usb4);

        c1.employ();
        c2.employ();
        c3.employ();
        c4.employ();

    }

}
