package hsp.chapter09.sevice;

import hsp.chapter09.house.House;

public class HouseService {

    private House[] houses; //保存房屋信息
    private int houseNums = 1; //记录当前有多少个房屋信息
    private int idCounter = 1; //记录当前的id增长到哪个值

    //用构造器初始化一个房子
    public HouseService(int size) {
        //创建houses数组
        houses = new House[size];
        //先初始化一套房子
        houses[0] = new House(1, "小明", "20001", "朝阳区", 5000, "未出租");
    }

    //通过 id 向调用者 返回 房屋 (通过id查找房屋)
    public House byId(int id) {
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == id) {
                return houses[i];
            }
        }
        return null;
    }

    //删除房屋方法
    //删除成功返回true  房屋不存在返回false
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (houses[i].getId() == delId) {
                //找到了就记录以下这个房屋在houses数组中存储的位置(下标)
                //注意: 下标 != 房屋编号
                index = i;
            }
        }
        if (index == -1) {
            //没找到返回false
            return false;
        }

        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        //将数组中的最后一个元素滞空
        houses[houseNums-1] = null;
        //数组元素减一，完成房屋信息的删除
        houseNums--;
        return true;
    }

    //添加房屋
    public void add(House house) {
        if (houseNums == houses.length) {
            //数组已满需要进行扩容
            House[] houses1 = new House[houses.length + 1];
            for (int i = 0; i < houses.length; i++) {
                houses1[i] = houses[i];
            }
            houses1[houses.length] = house;
            houses = houses1;
        } else {
            //没满直接添加
            houses[houseNums] = house;
        }
        //添加id自增机制
        houses[houseNums].setId(++idCounter);
        houseNums++;
    }


    //房屋清单
    public void list() {
        for (int i = 0; i < houseNums; i++) {
            System.out.println(houses[i]);
        }
    }

}
