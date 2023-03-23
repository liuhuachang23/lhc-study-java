package hsp.chapter25.jdbc.utils;



import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/7 19:08 星期六
 * @Operating： lhc_db01数据库 中news表
 * @Description: 使用 JDBCUtils 对表进行 增删改查操作
 */
@SuppressWarnings({"all"})
public class JDBCUtils_USE {
    public static void main(String[] args) {
    }

    //增删改
    @Test
    public void JDBCUtils_DML() {
        Connection connection = null;
        String sql = null;
        PreparedStatement preparedStatement = null;

        try {


            //1. 获取连接
            connection = JDBCUtils.getConnection();

            /*//2. 添加数据
            sql = "insert into actor values(?, ?, ?, ?, ?)";
            //3. 得到preparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //4. 给占位符赋值
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, "吴小文");
            preparedStatement.setString(3, "女");
            preparedStatement.setString(4, "2001-11-29");
            preparedStatement.setString(5,"123");*/

            /*//2. 修改数据
            sql = "update actor set phone = ? where id = ? ";
            //3. 得到preparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //4. 给占位符赋值
            preparedStatement.setString(1, "193");
            preparedStatement.setInt(2,5);*/

            //2. 删除数据
            sql = "delete from actor where id = ?";
            //3. 得到preparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //4. 给占位符赋值
            preparedStatement.setInt(1, 5);

            //5. 执行sql语句
            int row = preparedStatement.executeUpdate();
            System.out.println(row > 0 ? "操作成功" : "操作失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //查
    @Test
    public void JDBCUtils_DQL() {

        Connection connection = null;
        String sql = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //1. 获取连接
            connection = JDBCUtils.getConnection();
            System.out.println(connection.getClass());
            //2. 组织sql语句
            sql = "select * from actor where id = ?";
            //3. 得到preparedStatement
            preparedStatement = connection.prepareStatement(sql);
            //4. 给占位符赋值
            preparedStatement.setInt(1, 4);
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
            //7. 关闭资源
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }

}
