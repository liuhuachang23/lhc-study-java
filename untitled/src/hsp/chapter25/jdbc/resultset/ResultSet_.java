package hsp.chapter25.jdbc.resultset;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/6 9:47 星期五
 * @Operating： lhc_db01数据库中actor表
 * @Description: 演示select语句 返回 ResultSet结果集 ，并取出结果
 *
 */
@SuppressWarnings({"all"})
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //1. 通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\hsp\\chapter25\\jdbc\\mysql.properties"));
        //获取相关的值
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");

        //2.注册驱动
        Class<?> aClass = Class.forName(driver);
        //3. 获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //4. 得到Statement
        Statement statement = connection.createStatement();
        //5. 组织sql语句
        String sql = "select id, name, sex, borndate from actor";

        //6. 执行sql语句(dql)，该语句返回一个 ResultSet对象
        /* 6.1 返回的 ResultSet对象：
            +----+-----------+-----+---------------------+
            | id | NAME      | sex | borndate            |
            +----+-----------+-----+---------------------+
            |  3 | jack      | 男  | 1990-11-11 00:00:00 |
            |  4 | 刘德华     | 男  | 1990-11-11 00:00:00 |
            +----+-----------+-----+---------------------+
         */
        /* 6.2 debug 查看 resultSet对象底层结构
           1）resultSet 是一个接口 对应的数据库厂商实现了这个接口  类型为：JDBC42ResultSet
           2）存储数据的位置为：
           resultSet -> rowData -> rows(所有行，是一个ArrayList集合) -> elementData(对象数组) -> 0、1、2...(各行数据) ->
           inernalRowData(所有列，byte数组) -> 0、1、2..(各列数据) -> 每列数据都是以字符形式存储
         */
        ResultSet resultSet = statement.executeQuery(sql);

        //7. 使用while取出数据（一行一行循环取）
        while (resultSet.next()){  //resultSet.next() 会让光标向下移，当后面没有记录，这返回false
            int id = resultSet.getInt(1); //获取该行 第一列（id） 的数据
            String name = resultSet.getString(2); //获取该行 第二列（name） 的数据
            String sex = resultSet.getString(3); //获取该行 第三列（sex） 的数据
            String borndate = resultSet.getString(4); //获取该行 第四列（borndate） 的数据
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate);
        }


        //8. 关闭相关资源
        resultSet.close();
        statement.close();
        connection.close();


    }
}
