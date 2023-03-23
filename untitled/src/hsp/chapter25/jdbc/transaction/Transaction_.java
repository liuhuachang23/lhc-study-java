package hsp.chapter25.jdbc.transaction;

import hsp.chapter25.jdbc.utils.JDBCUtils;
import org.junit.Test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/7 21:01 星期六
 * @Operating： lhc_db01数据库 中account表
 * @Description: 模拟转账业务
 * 演示 id为1的用户 转账100元 给 id为2 的用户
 */
@SuppressWarnings({"all"})
public class Transaction_ {

    //不使用事务
    @Test
    public void noTransaction(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1. 获取连接
            connection = JDBCUtils.getConnection();

            //2. 修改数据
            String sql1 = "update account set balance = balance - 100 where id = 1 ";
            String sql2 = "update account set balance = balance + 100 where id = 2 ";

            //3. 得到preparedStatement,执行sql1语句
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            //这里设置一个会抛出异常的语句，模拟在转账过程中可能出现的干扰
            //我们知道，当try块中出现异常时，就不会往下执行了，直接跳到catch快中 捕获异常
            //此时就麻烦大了，因为在默认情况下connection对象是默认自动提交 即每执行成功一次sql语句，就自动提交一次，
            //导致在数据库中 用户1 转账过去了，而用户2 没有收到
            int i = 1 / 0;

            //4. 得到preparedStatement,执行sql2语句
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6. 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    //使用事务
    @Test
    public void useTransaction(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1. 获取连接
            connection = JDBCUtils.getConnection();
            //2. 将connection对象设置为不自动提交，相当于开启了事务
            connection.setAutoCommit(false);

            //3. 修改数据
            String sql1 = "update account set balance = balance - 100 where id = 1 ";
            String sql2 = "update account set balance = balance + 100 where id = 2 ";

            //4. 得到preparedStatement,执行sql1语句
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            //这里设置一个会抛出异常的语句，模拟在转账过程中可能出现的干扰
            //我们知道，当try块中出现异常时，就不会往下执行了，直接跳到catch快中 捕获异常
            //这里我们使用了事务，在catch快中，执行了事务回滚
            //不会导致 用户1 转账过去了，而用户2 没有收到
            //int i = 1 / 0;

            //5. 得到preparedStatement,执行sql2语句
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            //提交事务 (放在try块的末尾,即没有异常出现 执行事务提交)
            connection.commit();
        } catch (SQLException e) {
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                //当出现异常时，我们这里可以回滚，即撤销之前执行的操作
                //默认回滚到事务开启时的状态，也可以设置保存点
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //6. 关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

}
