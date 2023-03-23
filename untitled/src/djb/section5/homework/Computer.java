package djb.section5.homework;

public class Computer {

    private USB usb;

    public Computer() {
    }

    public Computer(USB usb) {
        this.usb = usb;
    }

    public USB getUsb() {
        return usb;
    }

    public void setUsb(USB usb) {
        this.usb = usb;
    }

    //使用外设方法
    public void employ() {
        this.getUsb().keyboard();
        this.getUsb().display();
        this.getUsb().printer();
        this.getUsb().mouse();
    }

}
