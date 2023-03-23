package com.lhc.mhl.service;

import com.lhc.mhl.dao.MenuDAO;
import com.lhc.mhl.domain.Menu;

import java.util.List;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/12 14:30 星期四
 * @Operating:
 * @Description:
 */
public class MenuService {

    private MenuDAO menuDAO = new MenuDAO();

    //显示所有菜品
    public List<Menu> Menu(){
       return menuDAO.queryMulti("select * from menu", Menu.class);
    }

    //根据menuId ，获取menu对象
    public Menu getMenu(int menuId){
        return menuDAO.querySingle("select * from menu where id = ?",Menu.class,menuId);
    }
}
