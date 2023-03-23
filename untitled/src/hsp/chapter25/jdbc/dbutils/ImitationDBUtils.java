package hsp.chapter25.jdbc.dbutils;

import hsp.chapter25.jdbc.datasource.JDBCUtilsByDruid;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/11 14:54 星期三
 * @Operating:
 * @Description: 先使用自己的方法模拟 DBUtils工具类 + Druid连接池
 */
public class ImitationDBUtils {

    public static void main(String[] args) {

        //将ResultSet --封装到-->ArrayList
        //1）创建一个Actor类，将ResultSet中的数据封装到该类，一条记录对应一个actor对象
        //2）将actor 放到 ArrayList集合中
        //封装完成后，就可以随意使用这些记录了，就不会因为关闭了连接而不能使用这些记录
        Connection connection = null;
        String sql = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //创建
        ArrayList<Actor> arrayList = new ArrayList<>();

        try {
            //1. 获取连接
            connection = JDBCUtilsByDruid.getConnection();
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
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");
                //把得到的整条记录，封装到actor对象中 ，在放入到集合中
                arrayList.add(new Actor(id, name, sex, borndate, phone));
            }
            System.out.println("arrayList集合数据 " + arrayList);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7. 关闭资源（不是真正的关闭连接，只是将connection 放回到连接池）
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }
}
