package hsp.chapter25.jdbc.batch_;

import hsp.chapter25.jdbc.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 刘华昌
 * @DATE: 2022/5/8 9:18 星期日
 * @Operating： lhc_db01数据库 中 admin2表
 * @Description: 演示 java批处理 添加 5000条数据到admin2
 */
@SuppressWarnings({"All"})
public class Batch_ {

    // 使用传统方法
    @Test
    public void noBatch() throws SQLException {

        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //这里我们统计一下执行的时间
        System.out.println("开始执行");
        long start = System.currentTimeMillis(); //开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis(); //开始时间
        System.out.println("传统方法 耗时：" + (end - start)); //5345ms
        JDBCUtils.close(null, preparedStatement, connection);
    }

    //使用批量处理方式
    @Test
    public void useBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into admin2 values (null, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //这里我们统计一下执行的时间
        System.out.println("开始执行");
        long start = System.currentTimeMillis(); //开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");

            //将sql语句 加入到批处理包中 --> 看源码
            /*
                public void addBatch() throws SQLException {
                    synchronized(this.checkClosed().getConnectionMutex()) {

                    //1. 第一次进来，会创建一个 batchedArgs（ArrayList）,这个集合里有一个elementDate(Object[])
                    //     这个对象数值，就用于下面存放预处理的sql语句
                    if (this.batchedArgs == null) {
                        this.batchedArgs = new ArrayList();
                    }

                    //2. this.parameterValues.length，就是 sql语句中占位符的个数
                    //     这个for循环，检查占位符上填写的数据，以及一些预编译的工作（预处理sql语句）
                    for(int i = 0; i < this.parameterValues.length; ++i) {
                        this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
                    }

                    //3. 将sql语句添加到batchedArgs的elementDate中
                    //    当elementDate 满后 按1.5倍扩容
                    //    当添加到指定值后，就执行批量处理
                    this.batchedArgs.add(new PreparedStatement.BatchParams(this.parameterValues,
                                this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
                    }
                    //4. 批量处理会减少我们发生sql语句的网络开销，而且减少编译次数，因此效率提高
                }
             */
            preparedStatement.addBatch();
            //当有1000条记录时 批量执行
            if ((i + 1) % 1000 == 0) { //每满1000及倍数，就执行一次
                preparedStatement.executeBatch(); //执行
                preparedStatement.clearBatch(); //清空
            }

        }
        long end = System.currentTimeMillis(); //开始时间
        System.out.println("批处理方法 耗时：" + (end - start)); //81ms
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
