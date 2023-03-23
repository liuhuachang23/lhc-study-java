package hsp.chapter11.homework;

public class Homework01 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock frock = new Frock();
        System.out.println(frock.getSerialNum());
        Frock frock1 = new Frock();
        System.out.println(frock1.getSerialNum());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNum());
    }
}

class Frock{
    //衣服出厂的序列号初始值
    private static int currentNum = 100000;
    private int serialNum;

    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public Frock() {
        serialNum = getNextNum();
    }
}
