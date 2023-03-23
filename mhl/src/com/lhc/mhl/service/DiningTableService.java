package com.lhc.mhl.service;

import com.lhc.mhl.dao.DiningTableDAO;
import com.lhc.mhl.domain.DiningTable;

import java.util.List;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/12 10:30 星期四
 * @Operating:
 * @Description:
 */
public class DiningTableService {

    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //显示餐桌状态
    public List<DiningTable> getDiningTable() {
        return diningTableDAO.queryMulti(
                "select * from diningTable", DiningTable.class);
    }

    //通过id返回，餐桌状态
    public Object getTableState(int id) {
        return diningTableDAO.queryScalar("select state from diningTable where id = ?", id);
    }

    //预定餐桌
    public void reserveTable(int id, String orderName, String orderTel) {
        int reserve = diningTableDAO.update("update diningTable set state = ?, orderName = ?," +
                " orderTel = ? where id = ?", "已预定", orderName, orderTel, id);
        System.out.println(reserve > 0 ? "预定成功" : "预定失败");
    }

    //更新餐桌状态
    public boolean updateTableState(int id, String state) {

        int reserve = diningTableDAO.update("update diningTable set state = ? where id = ?", state, id);
        return reserve > 0;
    }

    //结账后更新餐桌信息
    public boolean updateTableToFree(int id, String state) {

        int reserve = diningTableDAO.update("update diningTable set state = ?, orderName = '',orderTel = '' where id = ?", state, id);
        return reserve > 0;
    }
}
