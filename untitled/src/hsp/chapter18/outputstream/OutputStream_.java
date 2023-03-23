package hsp.chapter18.outputstream;


import java.io.FileOutputStream;
import java.io.IOException;

/*
* 演示使用 FileOutputStream 将数据写到文件中
*   中英文字符都可以写
* */
public class OutputStream_ {
    public static void main(String[] args) {

    }

    public void writeFile(){

        String filePath = "d:\\a.txt";
        //创建FileOutputStream 对象
        FileOutputStream fileOutputStream = null;
        try {
            //1.1 使用new FileOutputStream(filePath)的创建方式,写入的内容,会覆盖原先的内容
            //1.2 使用new FileOutputStream(filePath, true)的创建方式.写入的内容,会添加在原先内容之后
            fileOutputStream = new FileOutputStream(filePath, true);
            //2.1 写入一个字节
            //fileOutputStream.write('H'); // char-->int
            //2.2 写入字符串
            //write(byte[] b, int off, int len);
            //可以使用字符串的getBytes()方法将字符串->字节数组
            String str = "你好，wwl";
            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { //关闭字节流
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
