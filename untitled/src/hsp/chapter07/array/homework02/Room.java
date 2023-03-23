package hsp.chapter07.array.homework02;
/*
* 酒店的房间
* */
public class Room {
    /*
    * 房间编号
    * 一楼：101，102，103，104，105...
    * 二楼：201，202，203，204，205...
    * 三楼：301，302，303，304，305...
    * ....
    * */
    private int no;
    /*
    * 房间类型：单人间，双人间，标准间，总统套房
    * */
    private String type;
    /*
    * 房间状态
    *   true表示空闲，可以被预定
    *   false表示占用，不可以预定
    * */
    private boolean status;

    //构造方法
    public Room() {
    }

    public Room(int no, String type, boolean status) {
        this.no = no;
        this.type = type;
        this.status = status;
    }

    //setter and getter方法
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //重写equals方法
    //用来比较两个对象是否相同
    //至于怎么比较 程序员自己重写
    //现在认为两个房间的编号，房间类型相同就表示同一个房间
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getNo() == room.getNo() && getType().equals(room.getType());
    }

    //重写toString()方法
    public String toString() {
        return "Room{" + "no=" + no + ", type='" + type + '\'' + ", status=" + (status? "空闲":"占用") + '}';
    }
}
