package hsp.chapter18.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 19:11
 * @Description:
 * 如下一个配置文件 mysql.properties
 *  ip=192.168.0.13
 *  user=root
 *  pwd=12345
 *请问编程读取 ip、user、pwd 的值是多少
 */
public class Properties01 {
    public static void main(String[] args) throws IOException {
        //使用传统方法 : 获取 修改 比较麻烦
        //读取mysql.properties 文件，并得到ip、user、pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\hsp\\chapter18\\properties\\mysql.properties"));
        String  line;
        while ((line = br.readLine()) != null){

            //System.out.println(line); 逐行输出

            //想要读取 ip、user、pwd 的值是多少
            String[] split = line.split("="); //字符串拆分
            //System.out.println(split[0] + " " + split[1]);

            //要求只需获得ip
            if ("ip".equals(split[0])){
                System.out.println(split[1]);
            }

        }


        br.close();

    }
}
