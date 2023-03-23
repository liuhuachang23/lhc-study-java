package hsp.chapter18.reader;


import java.io.FileReader;
import java.io.IOException;

/*
* FileReader相关方法
* 1) new FileReader(File/String)
* 2) read() : 每次读取当个字符, 返回该字符, 如果到文件末尾就返回-1
* 3) read(char[] c) : 批量读取多个字符到数组,返回读取到的字符数, 如果到文件末尾就返回-1
*
* FileWriter不能处理 二进制文件(声音,视频,doc,pdf .等)
*
* 相关API:
* 1) new String(char[] c) 将char[] 转换成 String
* 2) new String(char[] c, int off, int len) 将char[]指定的部分转换成String
* */
public class FileReader_ {
    public static void main(String[] args) {

    }
    /**
     * 使用 read(char[] c) 读取文件中的数据
     * 单个单个字符读取
     */
    public void reader01(){

        //读取图片出现乱码
        //String filePath = "d:\\wwl.jpg";

        String filePath = "d:\\story.txt";
        FileReader fileReader = null;
        int readDate = 0;
        try {
            fileReader = new FileReader(filePath);
            while ((readDate = fileReader.read()) != -1){
                System.out.print((char)readDate);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 使用 read() 读取文件中的数据
     * 字符数组读取 ， 提高效率
     */
    public void reader02(){
        String filePath = "d:\\story.txt";
        FileReader fileReader = null;
        char[] buf = new char[8];
        int readLen = 0;
        try {
            fileReader = new FileReader(filePath);
            while ((readLen = fileReader.read(buf)) != -1){
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}