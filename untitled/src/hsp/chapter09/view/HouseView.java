package hsp.chapter09.view;

import hsp.chapter09.house.House;
import hsp.chapter09.sevice.HouseService;
import hsp.chapter09.utlis.Utility;


//主菜单界面
public class HouseView {

    //定义需要的属性
    private boolean loop = true;
    private String key = "";
    private HouseService houseService = new HouseService(2);

    public void updateHouse() {
        System.out.println("============修改房屋信息============");
        System.out.println("请输入需要修改的房屋id: ");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("放弃修改");
            return;
        }

        //根据输入的编号查找要修改的房屋
        House house = houseService.byId(updateId);
        if (house == null) {
            System.out.println("房屋id不存在!");
            return;
        }

        System.out.print("姓名(" + house.getName() + ") :");
        String newName = Utility.readString(8, "");
        //这里可以设置,如果不想修改可以直接回车
        if (!"".equals(newName)) {
            house.setName(newName);
        }

        System.out.print("电话(" + house.getTel() + ") :");
        String newTel = Utility.readString(12, "");
        if (!"".equals(newTel)) {
            house.setTel(newTel);
        }

        System.out.print("地址(" + house.getAddress() + ") :");
        String newAddress = Utility.readString(18, "");
        if (!"".equals(newAddress)) {
            house.setAddress(newAddress);
        }

        System.out.print("月租(" + house.getMonthly() + ") :");
        double newMonthly = Utility.readInt(-1);
        if (newMonthly != -1) {
            house.setMonthly(newMonthly);
        }

        System.out.print("状态(" + house.getState() + ") :");
        String newState = Utility.readString(3, "");
        if (!"".equals(newState)) {
            house.setState(newState);
        }
        System.out.println("===========房屋修改成功============");
    }

    //通过id查找房屋信息
    public void findHouse() {
        System.out.println("===========查找房屋信息============");
        System.out.println("请输入需要查找的房间id: ");
        int findId = Utility.readInt();
        House house = houseService.byId(findId);
        if (house != null) {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(house);
        } else {
            System.out.println("===========查找房屋信息id不存在===========");
        }
    }


    public boolean exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            return false;
        }
        return true;
    }

    public void delHouse() {
        System.out.println("===========删除房屋信息===========");
        System.out.println("请输入需要删除的房屋id(-1退出)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("=============放弃删除房屋信息============");
            return;
        }
        System.out.println("确认删除? y/n");
        char del = Utility.readConfirmSelection();
        if (del == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("===========删除房屋信息成功===========");
                return;
            }
            System.out.println("===========房屋编号不存在===========");
            return;
        }
        System.out.println("===========放弃删除房屋信息===========");
    }

    public void addHouse() {
        System.out.println("===========添加房屋信息===========");
        System.out.print("姓名: ");
        String addName = Utility.readString(8);
        System.out.print("电话: ");
        String addTel = Utility.readString(12);
        System.out.print("地址: ");
        String addAddress = Utility.readString(18);
        System.out.print("月租: ");
        double addMonthly = Utility.readInt();
        System.out.print("状态: ");
        String addState = Utility.readString(3);
        //id系统分配
        House newHouse = new House(0, addName, addTel, addAddress, addMonthly, addState);
        houseService.add(newHouse);
        System.out.println("===========添加房屋信息成功===========");
    }

    public void listHouses() {
        System.out.println("=============房屋列表============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        houseService.list();
    }

    //主界面
    public void mainMenu() {
        HouseView houseView = new HouseView();
        do {
            System.out.println("------------房屋出租系统------------");
            System.out.println("\t\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t\t6 退       出");

            System.out.println("请输入您选择的服务(1~6)");
            key = Utility.readString(1);

            switch (key) {
                case "1":
                    houseView.addHouse();
                    break;
                case "2":
                    houseView.findHouse();
                    break;
                case "3":
                    houseView.delHouse();
                    break;
                case "4":
                    houseView.updateHouse();
                    break;
                case "5":
                    houseView.listHouses();
                    break;
                case "6":
                    loop = houseView.exit();
            }
        } while (loop);
        System.out.println("您已退出程序...");
    }


}
