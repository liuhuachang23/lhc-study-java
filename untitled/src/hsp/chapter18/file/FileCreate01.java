package hsp.chapter18.file;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: 刘华昌
 * @Date: 2022/4/5 13:25
 * @Description:
 */
public class FileCreate01 {
    public static void main(String[] args) throws IOException {
        String directPath = "d:\\demo";
        String filePath = "d:\\demo\\news.txt";
        //这里file对象,在java程序中,只是一个对象
        //只有执行了 mkdirs()或createNewFile() 才会真正的在磁盘创建该目录或文件
        File file1 = new File(directPath);
        File file2 = new File(filePath);
        file1.mkdirs(); //创建多级目录
        file2.createNewFile(); //创建文件
        //下面两个换个顺序，都能删除成功
        file1.delete(); //删除目录失败，不是空白目录
        file2.delete(); //删除文件成功


    }
}
