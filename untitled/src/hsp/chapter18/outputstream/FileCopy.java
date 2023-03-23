package hsp.chapter18.outputstream;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//使用fileInputStream，fileOutputStream，完成图片的拷贝
//补充：中文字符也可以拷贝
public class FileCopy {
    public static void main(String[] args) {
        //完成 文件拷贝,将 d:\\wwl.jpg 拷贝到 c:\
        //思路分析
        //1. 创建文件的输入流, 将文件读入到程序
        //2. 创建文件的输出流, 将第一步读取到的文件, 写入到指定的位置
        //   文件1 --输入流--> java程序 --输出流--> 文件2


        String srcFilePath = "d:\\wwl.jpg"; //原文件路径
        String destFilePath = "d:\\wwl2.jpg"; //需要拷贝的位置

        //演示一下是否可以拷贝中文字符：可以
        //String srcFilePath = "d:\\hello.txt";
        //String destFilePath = "d:\\hello2.txt";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            byte[] buf = new byte[1024];
            int redLen = 0;
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            while ((redLen = fileInputStream.read(buf)) != -1) {
                //读取到文件后就可以写入到目标文件中
                //即,一边读取,一边写入
                fileOutputStream.write(buf, 0, redLen); //不写后面两个参数,会出现文件损失
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭输入流和输出流,释放资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
