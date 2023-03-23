package hsp.chapter25.jdbc.datasource;

import hsp.chapter25.jdbc.datasource.JDBCUtilsByDruid;
import org.junit.Test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/8 16:44 星期日
 * @Operating: lhc_db01.actor
 * @Description: 演示使用 Druid工具类 查询数据库
 */
@SuppressWarnings({"all"})
public class JDBCUtilsByDruid_USE {

    @Test
    public void JDBCUtils_DQL() {

        Connection connection = null;
        String sql = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //1. 获取连接
            connection = JDBCUtilsByDruid.getConnection();
            System.out.println(connection.getClass()); //运行类型
            //2. 组织sql语句
            sql = "select * from actor where id >= ?";
            //3. 得到preparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //4. 给占位符赋值
            preparedStatement.setInt(1, 1);
            //5. 执行sql语句
            resultSet = preparedStatement.executeQuery();
            //6. 使用while循环遍历结果集，获取数据
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String borndate = resultSet.getString("borndate");
                String phone = resultSet.getString("phone");
                System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate + "\t" + phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7. 关闭资源（不是真正的关闭连接，只是将connection 放回到连接池）
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }
}
