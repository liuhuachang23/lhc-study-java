package hsp.chapter25.jdbc.dbutils;

import hsp.chapter25.jdbc.datasource.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;


import java.sql.*;
import java.util.List;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/9 14:54 星期一
 * @Operating: lhc_db01 actor
 * @Description: 使用DBUrils工具类 + Druid连接池 完成对表的操作
 */
@SuppressWarnings({"all"})
public class UseDBUtils {
    public static void main(String[] args) {
    }
    //使用 DBUtils工具类，先引入 DBUtils相关的jar，加入到项目中

    @Test
    //使用apache-DBUtils 工具类 + Druid连接池 完成对表的查询操作
    public void UseDBUtils01() throws SQLException {
        //1. 获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();


        //2. 创建 QueryRunner，这个queryRunner就可以执行相关的方法，返回对应的ResultSet
        QueryRunner queryRunner = new QueryRunner();

        //3. 组织sql语句
        //String sql = "select * from actor where id >= ?";
        //还可以查询部分信息
        String sql = "select id, name from actor where id >= ?";

        //4. 执行query()
        //解读：
        //（1）query方法 就是执行sql语句，得到resultSet，并将这个结果集封装到 ArrayList集合中, 返回一个集合
        //（2）connection：连接
        //（3）sql：执行sql语句
        //（4）new BeanListHandler<>(Actor.class)：将resultSet --封装--> actor对象 --放入--> ArrayList集合
        //（5）Actor.class：底层利用反射机制 去获取Actor的属性，进行封装
        //（6）1：就是给sql语句中的占位符赋值，是一个可变参数，可以有多个值
        /**
         * 源码分析 queryRunner.query()
         *
         *  public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *      PreparedStatement stmt = null;                  //定义 PreparedStatement
         *      ResultSet rs = null;                            //接收返回的 ResultSet
         *      Object result = null;                           //接收返回的 ArrayList
         *
         *      try {
         *          stmt = this.prepareStatement(conn, sql);    //使用connect和sql创建了一个preparedStatement
         *          this.fillStatement(stmt, params);           //给占位符赋值
         *          rs = this.wrap(stmt.executeQuery());        //执行sql语句，将得到的结果集 进行处理，再返回给rs(resultSet)
         *          result = rsh.handle(rs);                    //将处理过后的 resultSet 封装到 ArrayList（使用到反射，对传入class对象处理）
         *      } catch (SQLException var33) {
         *             this.rethrow(var33, sql, params);
         *      } finally {
         *          try {
         *              this.close(rs);                         //关闭 ResultSet
         *          } finally {
         *              this.close((Statement)stmt);            //关闭 PreparedStatement
         *          }
         *      }
         *      return result;                                  //返回result
         *  }
         */
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

        System.out.println("输出集合信息");
        for (Actor actor : list) {
            System.out.println(actor);
        }
        //5. 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }


    //使用apache-DBUtils 工具类 + Druid连接池 完成对表的查询操作（查询 单行记录）
    @Test
    public void UseDBUtils02() throws SQLException {
        //1. 获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 创建 QueryRunner，这个queryRunner就可以执行相关的方法，返回对应的ResultSet
        QueryRunner queryRunner = new QueryRunner();
        //4. 查询一条记录
        String sql = "select * from actor where id = ?";
        //5. 执行query()
        //返回一条记录 --> 单个对象，使用的hander为 BeanHandler，将结果集中的第一行数据封装到一个对应的JavaBean实例中，不需要在装入集合中
        //当查询不到记录时，返回null
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 4);
        System.out.println(actor);
        //6. 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //使用apache-DBUtils 工具类 + Druid连接池 完成对表的查询操作（查询 单行单列）
    @Test
    public void UseDBUtils03() throws SQLException {
        //1. 获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 创建 QueryRunner，这个queryRunner就可以执行相关的方法，返回对应的ResultSet
        QueryRunner queryRunner = new QueryRunner();
        //4. 查询单行单列
        String sql = "select name from actor where id = ?";
        //5. 执行query()
        //返回单行单列 使用的hander为 ScalarHandler，返回一个Object
        //当查询不到记录时，返回null
        Object o = queryRunner.query(connection, sql, new ScalarHandler(), 4);
        System.out.println(o);
        //6. 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }

    //使用apache-DBUtils 工具类 + Druid连接池 完成对表的增删改操作
    @Test
    public void UseDBUtils04() throws SQLException {
        //1. 获取连接
        Connection connection = JDBCUtilsByDruid.getConnection();
        //2. 创建 QueryRunner，这个queryRunner就可以执行相关的方法，返回对应的ResultSet
        QueryRunner queryRunner = new QueryRunner();
        //4. 组织sql语句
        //String sql = "update actor set name = ? where id = ?"; //修改
        //String sql = "insert into actor values(null, ?, ?, ?, ?)";//增加
        String sql = "delete from actor where id = ?";

        //5.当执行dml（增删改）操作时，使用queryRunner.update()
        //  返回值为受影响的行数
        int rows = queryRunner.update(connection, sql,6);
        System.out.println(rows > 0 ? "执行成功" : "表没有发生变化");

        //6. 释放资源
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
