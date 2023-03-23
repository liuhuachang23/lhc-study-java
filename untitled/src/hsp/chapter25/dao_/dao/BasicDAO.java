package hsp.chapter25.dao_.dao;

import hsp.chapter25.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/10 10:16 星期二
 * @Operating:
 * @Description: 开发 BasicDAO，用于其他 DAO的父类
 */
public class BasicDAO<T> { //泛型指定具体类型

    private QueryRunner qr = new QueryRunner();

    /**
     * 开发通用的DML方法，针对任意表
     *
     * @param sql    执行的sql语句，可以有 ?占位符
     * @param params 可变形参，用于给占位符赋值
     * @return 影响的行数
     */
    public int update(String sql, Object... params) {

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 开发通用的DQL方法，针对任意表（查询多行）
     *
     * @param sql    执行的sql语句，可以有 ?占位符
     * @param clazz  类的Class对象(Domain)，比如 Actor
     * @param params 可变形参，用于给占位符赋值
     * @return 根据Class对象 返回对应的 ArrayList集合
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }


    /**
     * 开发通用的DQL方法，针对任意表（查询单行）
     *
     * @param sql    执行的sql语句，可以有 ?占位符
     * @param clazz  类的Class对象(Domain)，比如 Actor
     * @param params 可变形参，用于给占位符赋值
     * @return 返回 单个 Class对象
     */
    public T querySingle(String sql, Class<T> clazz, Object... params) {

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 开发通用的DQL方法，针对任意表（查询单行单列）
     *
     * @param sql    执行的sql语句，可以有 ?占位符
     * @param params 可变形参，用于给占位符赋值
     * @return 返回一个 Object对象
     */
    public Object queryScalar(String sql, Object... params) {

        Connection connection = null;

        try {
            connection = JDBCUtilsByDruid.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
