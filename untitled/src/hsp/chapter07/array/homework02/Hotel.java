package hsp.chapter07.array.homework02;
/*
* 酒店对象，酒店中有二维数组，二维数组模拟大厦
* */
public class Hotel {
    /*
    * 二维数组，模拟大厦所有房间
    * */
    private Room[][] rooms;

    //通过构造方法来盖楼
    public Hotel(){

        //一共有几层，每层的房间类型是多少，每个房间的编号是多少
        //我们可以先写死：一共3层，一层单人间，二层双人间，三层标准间，四层总统套房。每一层有10个房间
        /*
        * 房间编号：
        * 一楼：101，102，103，104，105...
        * 二楼：201，202，203，204，205...
        * 三楼：301，302，303，304，305...
        * 四楼：401，402，403，404，405...
        * */
        rooms = new Room[4][10];

        //创建40个Room对象，放到数组中
        for (int i = 0; i <rooms.length ; i++) {
            for (int j = 0; j <rooms[i].length ; j++) {
                if (i == 0) {
                    //i == 0 表示第一层
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "单人间", true);
                } else if (i == 1) {
                    //i == 1 表示第二层
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "双人间", true);
                } else if (i == 2) {
                    //i == 2 表示第三层
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "标准间", true);
                } else if (i == 3) {
                    //i == 3 表示第四层
                    rooms[i][j] = new Room((i + 1) * 100 + j + 1, "总统套房", true);
                }
            }
        }
    }

    //在酒店对象是上提供一共打印房间列表的方法
    public void print(){
        //打印所有房间
        //遍历二维数组
        for (int i = 0; i <rooms.length ; i++) {
            for (int j = 0; j <rooms[i].length ; j++) {
                //输出的引用会自动调用toString()方法
                System.out.print(rooms[i][j] + " ");
            }
            //换行
            System.out.println();
        }
    }

    //订房方法
    public void order(int roomNo){
        //通过预定房间的编号来计算下标
        //获取房间对象
        Room room = rooms[roomNo / 100 - 1][roomNo % 100 - 1];
        //改为占用
        room.setStatus(false);
        System.out.println("订房成功，欢迎入住：" + room.getNo() + room.getType());
    }

    //退房方法
    public void exit(int roomNo){
        Room room = rooms[roomNo / 100 - 1][roomNo % 100 - 1];
        //改为空闲
        room.setStatus(true);
        System.out.println("房间:" + room.getNo() + room.getType() + " 成功退房，欢迎下次光临！");
    }
}
