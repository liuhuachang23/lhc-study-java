package hsp.chapter18.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 19:43
 * @Description: 演示 Properties 的使用
 * 完成对 mysql.properties 的读取
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //1)创建Properties对象
        Properties properties = new Properties();
        //2)加载指定的配置文件
        properties.load(new FileReader("src\\hsp\\chapter18\\properties\\mysql.properties"));
        //3)吧 k-v 显示到控制台
        properties.list(System.out);
        //4)根据 k 获取对应的 v
        String ip = properties.getProperty("ip");
        System.out.println(ip);
    }
}
