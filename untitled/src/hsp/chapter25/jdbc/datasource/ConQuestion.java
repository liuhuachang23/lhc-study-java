package hsp.chapter25.jdbc.datasource;

import hsp.chapter25.jdbc.utils.JDBCUtils;
import org.junit.Test;


import java.sql.Connection;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/8 10:56 星期日
 * @Operating:
 * @Description: 传统方式 连接数据库 出现的问题
 */
public class ConQuestion {

    @Test
    public void testCon(){

        //看看传统方式 连接5000此数据库和关闭资源 耗时多久
        long start = System.currentTimeMillis();
        System.out.println("开始连接...");
        for (int i = 0; i < 5000; i++) {
            //使用传统方式连接
            Connection connection = JDBCUtils.getConnection();
            //做一些工作，比如得到PreparedStatement，发生sql...
            //....
            //关闭资源
            JDBCUtils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("传统方式连接5000此 耗时：" + (end - start)); //5405ms
    }
}
