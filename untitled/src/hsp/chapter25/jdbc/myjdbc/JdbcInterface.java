package hsp.chapter25.jdbc.myjdbc;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/5 16:50 星期四
 * @Description: 我们规定的jdbc接口（方法）
 */
public interface JdbcInterface {

    //连接
    public Object getConnection();

    //crud
    public void crud();

    //关闭连接
    public void close();
}
