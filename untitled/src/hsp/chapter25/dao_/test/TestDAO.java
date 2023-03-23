package hsp.chapter25.dao_.test;

import hsp.chapter25.dao_.dao.ActorDAO;
import hsp.chapter25.dao_.dao.GoodsDAO;
import hsp.chapter25.dao_.domain.Actor;
import hsp.chapter25.dao_.domain.Goods;
import org.junit.Test;

import java.util.List;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/10 14:18 星期二
 * @Operating:
 * @Description: 测试类
 */
public class TestDAO {

    //测试ActorDAO 对actor表的crud操作
    @Test
    public void testActorDAO() {

        ActorDAO actorDAO = new ActorDAO();

        //1. 执行DQL语句

        //1）查询多条记录
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("===查询单条记录===");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //2）查询单行记录
        Actor actor = actorDAO.querySingle("select * from actor where id = ?", Actor.class, 4);
        System.out.println("===查询单行记录===");
        System.out.println(actor);

        //3）查询单行单例记录
        Object o = actorDAO.queryScalar("select name from actor where id = ?", 4);
        System.out.println("===查询单行单列记录===");
        System.out.println(o);

        //2. 执行DML语句（增、改、删）
        //int rows = actorDAO.update("insert into actor values(null,?,?,?,?)", "小龙女", "女", "1993-12-21", "124");
        //int rows = actorDAO.update("update actor set name = ? where id = ?", "紫霞仙子", 7);
        int rows = actorDAO.update("delete from actor where id = ?", 7);
        System.out.println(rows > 0 ? "执行成功" : "数据库(表)无任何变化");
    }

    //测试GoodsDAO 对goods表的crud操作
    @Test
    public void testGoodsDAO(){

        GoodsDAO goodsDAO = new GoodsDAO();

        //1. 执行DML语句
        //int rows = goodsDAO.update("insert into goods values(?, ?, ?)", 10, "华为手机", 4000);
        //int rows = goodsDAO.update("insert into goods values(?, ?, ?)", 20, "苹果手机", 5000);
        //int rows = goodsDAO.update("insert into goods values(?, ?, ?)", 30, "小米手机", 3000);
        //int rows = goodsDAO.update("insert into goods values(?, ?, ?)", 40, "三星手机",null);
        //int rows = goodsDAO.update("update goods set price = ? where id = ?", 6000, 40);
        //System.out.println(rows > 0 ? "执行成功" : "数据库(表)无任何变化");

        //2. 执行DQL语句
        //1）查询多条记录
        List<Goods> list = goodsDAO.queryMulti("select * from goods where id >= ?", Goods.class, 10);
        System.out.println("===查询多行记录===");
        for (Goods goods : list){
            System.out.println(goods);
        }

        //2）查询单条记录
        Goods goods = goodsDAO.querySingle("select * from goods where id = ?", Goods.class, 10);
        System.out.println("===查询单行记录===");
        System.out.println(goods);

        //3）查询单行单列记录
        Object o = goodsDAO.queryScalar("select goods_name from goods where id = ?", 10);
        System.out.println("===查询单行单列记录===");
        System.out.println(o);

    }

}
