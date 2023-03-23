package com.lhc.mhl.service;

import com.lhc.mhl.dao.BillDAO;
import com.lhc.mhl.dao.MultiTableDAO;
import com.lhc.mhl.domain.Bill;
import com.lhc.mhl.domain.MultiTable;

import java.util.List;
import java.util.UUID;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/12 16:06 星期四
 * @Operating:
 * @Description:
 */
public class BillService {

    private BillDAO billDAO = new BillDAO();
    private MenuService menuService = new MenuService();
    private DiningTableService diningTableService = new DiningTableService();
    private MultiTableDAO multiTableDAO = new MultiTableDAO();

    /**
     * 编写点餐方法完成：
     * 1. 生成账单
     * 2. 更新餐桌状态
     *
     * @param menuId        菜品单号
     * @param nums          份数
     * @param diningTableId 餐桌号
     *                      如果成功返回 true 否则返回 false
     */
    public boolean orderMenu(int menuId, int nums, int diningTableId) {
        //生成一个账单号
        String billId = UUID.randomUUID().toString();

        //将订单添加到bill表中
        int addOrder = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billId, menuId, nums, menuService.getMenu(menuId).getPrice() * nums, diningTableId);

        if (addOrder <= 0) {
            return false;
        } else {
            //订单添加成功就更新餐桌状态
            return diningTableService.updateTableState(diningTableId, "就餐中");
        }
    }

    //查看账单
    public List<Bill> showBill() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    //查看账单（新增菜名、价格）
    public List<MultiTable> showBill2() {
       return multiTableDAO.queryMulti("select bill.*, menu.name,menu.price from bill, menu where bill.menuId = menu.id", MultiTable.class);
    }

    //通过餐桌号查询是否存在未结账账单
    public boolean getBill(int diningTableId) { // limit 0, 1 （表示 查询到了记录，不管多少条，只需返回一条）用于下面判断是否存在账单
        Bill bill = billDAO.querySingle("select * from bill where diningTableId = ? and state = '未结账'limit 0, 1",Bill.class, diningTableId);
        return (bill != null);
    }

    //结账
    public boolean payBill(int diningTableId,String way) {

        //1.修改bill表
        int update1 = billDAO.update("update bill set state = ? where diningTableId = ? and state = '未结账'"
                , way, diningTableId);
        if (update1 <= 0){ //如果执行没成功，就直接退出，不能在往下修改diningTable表了
            return false;
        }

        //2.修改diningTable表
        if (!diningTableService.updateTableToFree(diningTableId,"空闲")) {
            return false;
        }
        return true;
    }

}
