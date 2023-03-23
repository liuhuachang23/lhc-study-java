package hsp.chapter18.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/4 20:30
 * @Description:
 * 判断在d盘下是否有文件夹myTemp，如果没有就创建
 * 判断d:\\myTemp 目录下 是否有 hello.txt 文件，没有就创建
 * 在 hello.txt 文件中 写入 hello，吴小文
 *
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {

        String directPath = "d:\\myTemp";
        File file = new File(directPath);
        if (file.exists()) {
            System.out.println(directPath + "目录存在");
        } else {
            file.mkdirs(); //创建目录
            System.out.println(directPath + "目录创建成功");
        }
        String filePath = "d:\\myTemp\\hello.txt";
        file = new File(filePath);
        if (file.exists()) {
            System.out.println(filePath + "该文件存在");
        } else {
            file.createNewFile(); //创建文件
            System.out.println(filePath + "文件创建成功");
        }

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
        osw.write("hello，吴小文");
        osw.close();
    }
}
