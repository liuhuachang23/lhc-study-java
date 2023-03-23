package com.lhc.mhl.view;

import com.lhc.mhl.domain.*;
import com.lhc.mhl.service.*;
import com.lhc.mhl.utils.Utility;

import java.util.List;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/11 20:09 星期三
 * @Operating:
 * @Description: 满汉楼主界面
 */
public class MHLView {

    private boolean loop = true; //控制是否退出菜单
    private String key = ""; //接收用户输入
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();
    private LoginService loginService = new LoginService();

    public static void main(String[] args) {
        MHLView mhlView = new MHLView();
        mhlView.mainMenu();
    }

    //显示主菜单
    public void mainMenu() {

        //显示一级菜单
        while (loop) {
            System.out.println("============满汉楼============");
            System.out.println("\t\t" + "1 登录满汉楼");
            System.out.println("\t\t" + "2 退出满汉楼");

            System.out.print("请输入你的选择：");
            String key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("请输入员工号：");
                    String empId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String pwd = Utility.readString(50);

                    Login login = Login(empId, pwd);
                    if (login != null) {
                        //登录成功就加载查询员工信息
                        Employee employee = employeeService.infoOfEmp(empId);
                        System.out.println("===========" + employee.getName() + " 登录成功===========");
                        //显示二级菜单
                        while (loop) {
                            System.out.println("===========满汉楼(二级菜单)===========");
                            System.out.println("\t\t" + "1 显示餐桌状态");
                            System.out.println("\t\t" + "2 预定餐桌");
                            System.out.println("\t\t" + "3 显示所有菜品");
                            System.out.println("\t\t" + "4 点餐服务");
                            System.out.println("\t\t" + "5 查看账单");
                            System.out.println("\t\t" + "6 结账");
                            System.out.println("\t\t" + "7 人事管理");
                            System.out.println("\t\t" + "8 退出满汉楼");

                            System.out.print("请输入你的选择：");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    showDiningTableState();
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    showMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    lookBill();
                                    break;
                                case "6":
                                    pay();
                                    break;
                                case "7":
                                    //1.校验身份，只有职位为经理，才能进行人事管理
                                    if (checkStatus(empId)) {
                                        while (loop) {
                                            System.out.println("===========人事管理菜单===========");
                                            System.out.println("\t\t" + "1 显示所有员工信息");
                                            System.out.println("\t\t" + "2 招聘新员工");
                                            System.out.println("\t\t" + "3 开除员工");
                                            System.out.println("\t\t" + "4 退出满汉楼");
                                            System.out.print("请输入你的选择：");
                                            key = Utility.readString(1);
                                            switch (key) {
                                                case "1":
                                                    showEmployee();
                                                    break;
                                                case "2":
                                                    addEmp();
                                                    break;
                                                case "3":
                                                    deleteEmp();
                                                    break;
                                                case "4":
                                                    loop = false;
                                                    break;
                                                default:
                                                    System.out.println("你输入的格式不正确，请重新输入");
                                            }

                                        }
                                    } else {
                                        System.out.println("你的职位等级不足，无法进行人事管理");
                                    }
                                    break;
                                case "8":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("你输入的格式不正确，请重新输入");
                            }
                        }
                    } else {
                        System.out.println("===========登录失败===========");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("你输入的格式不正确，请重新输入");
            }
        }
        System.out.println("退出满汉楼系统");
    }

    //登录验证
    public Login Login(String empId, String pwd) {
        return loginService.checkLogin(empId, pwd);
    }


    //显示餐桌状态
    public void showDiningTableState() {
        System.out.println("===========显示餐桌状态===========");
        List<DiningTable> diningTables = diningTableService.getDiningTable();
        System.out.println("餐桌编号\t餐桌状态");
        for (DiningTable diningTable : diningTables) {
            System.out.println(diningTable.getId() + "\t\t" + diningTable.getState());
        }

    }

    //预定餐桌
    public void orderDiningTable() {
        System.out.println("===========预定餐桌===========");
        System.out.print("请选择预定的餐桌号（-1表示取消预定）");
        int id = Utility.readInt(2);
        if (id == -1) {
            System.out.println("===========退出预定===========");
            return;
        }
        Object o = diningTableService.getTableState(id);
        if ("空闲".equals(o)) {
            System.out.print("请输入预定人姓名：");
            String orderName = Utility.readString(10);
            System.out.print("请输入预定人电话：");
            String orderTel = Utility.readString(11);
            diningTableService.reserveTable(id, orderName, orderTel);
        }
        if (o == null) {
            System.out.println("你选择的餐桌不存在");
        } else {
            System.out.println("你选择的餐桌已被占用");
        }
    }

    //显示菜谱
    public void showMenu() {
        System.out.println("===========显示菜谱===========");
        List<Menu> menus = menuService.Menu();
        System.out.println("菜品编号\t\t菜品名称\t\t菜品类别\t\t菜品价格");
        for (Menu menu : menus) {
            System.out.println(menu.getId() + "\t\t\t" + menu.getName() + "\t\t" +
                    menu.getType() + "\t\t" + menu.getPrice());
        }
    }

    //点餐服务
    public void orderMenu() {

        System.out.println("===========点餐服务===========");

        //选择餐桌号
        System.out.print("请选择点餐的桌号（-1表示取消点餐）：");
        int diningTableId = Utility.readInt(2);
        if (diningTableId == -1) {
            System.out.println("===========取消点餐===========");
            return;
        }
        //校验餐桌号是否存在
        Object state = diningTableService.getTableState(diningTableId);
        if (state == null) {
            System.out.println("你选择的餐桌不存在");
            return;
        }

        //选择菜品
        System.out.print("请选择需要的菜品编号（-1表示取消点餐）：");
        int menuId = Utility.readInt(2);
        if (menuId == -1) {
            System.out.println("===========取消点餐===========");
            return;
        }
        //校验菜品是否存在
        Menu menu = menuService.getMenu(menuId);
        if (menu == null) {
            System.out.println("你选择的菜品不存在");
            return;
        }
        //菜品数
        System.out.print("请选择菜品数量（-1表示取消点餐）：");
        int nums = Utility.readInt(2);
        if (nums == -1) {
            System.out.println("===========取消点餐===========");
            return;
        }

        //再次确认是否点餐
        char c = Utility.readConfirmSelection();
        if (c == 'N') {
            System.out.println("===========取消点餐===========");
            return;
        }
        //点餐
        boolean b = billService.orderMenu(menuId, nums, diningTableId);
        if (b) {
            System.out.println("点餐成功");
        }
    }

    //查看账单
    public void lookBill() {
        System.out.println("===========查看账单===========");
        List<MultiTable> allBill = billService.showBill2();
        System.out.println("编号\t\t餐桌号\t菜品号\t菜名\t\t\t单价\t\t\t数量\t\t日期\t\t\t\t\t\t\t金额\t\t\t状态");
        for (MultiTable bill : allBill) {
            System.out.println(bill);
        }
    }

    //结账
    public void pay() {
        System.out.println("===========结账服务===========");
        System.out.print("请选择要结账的餐桌编号(-1退出)：");
        int diningTableId = Utility.readInt(2);
        if (diningTableId == -1) {
            System.out.println("===========取消结账===========");
            return;
        }

        //对餐桌进行校验
        if (!billService.getBill(diningTableId)) {
            System.out.println("你选择的餐桌号没有账单记录");
            return;
        }

        //选择结账方式
        System.out.print("请选择结账方式(现金/支付宝/微信) 回车表示退出：");
        String way = Utility.readString(10, ""); //如果回车 就默认""
        if ("".equals(way)) {
            System.out.println("===========取消结账===========");
        }

        //再次确认是否结账
        char c = Utility.readConfirmSelection();
        if (c == 'N') {
            System.out.println("===========取消结账===========");
            return;
        }

        //完成结账
        if (billService.payBill(diningTableId, way)) {
            System.out.println(diningTableId + "号餐桌，结账成功");
        } else {
            System.out.println("结账失败");
        }
    }

    //人事管理-职位校验
    public boolean checkStatus(String id) {
        Object job = employeeService.getJob(id);
        if ("老板".equals(job)) {
            return true;
        }
        return false;
    }

    //人事管理-显示所有员工
    public void showEmployee(){
        List<Employee> employees = employeeService.allEmployee();
        System.out.println("ID号\t\t员工号\t\t姓名\t\t\t职位");
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }

    //人事管理-招聘员工
    public void addEmp(){
        System.out.print("请输入添加的员工编号：");
        String empId = Utility.readString(10);
        System.out.print("请输入添加的员工密码：");
        String pwd = Utility.readString(10);
        System.out.print("请输入添加的员工姓名：");
        String name = Utility.readString(10);
        System.out.print("请输入添加的员工职位：");
        String job = Utility.readString(10);
        boolean b = employeeService.addEmployee(empId, pwd, name, job);
        if (b){
            System.out.println("招聘员工成功");
        } else {
            System.out.println("招聘员工失败");
        }
    }

    //人事管理-开除员工
    public void deleteEmp(){
        System.out.print("请输入开除的员工编号：");
        String empId = Utility.readString(10);
        boolean b = employeeService.deleteEmployee(empId);
        if (b){
            System.out.println("开除员工成功");
        } else {
            System.out.println("开除员工失败");
        }
    }

}
