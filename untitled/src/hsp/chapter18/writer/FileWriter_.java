package hsp.chapter18.writer;


import java.io.FileWriter;
import java.io.IOException;

/*
* FileWriter常用方法
* 1） new FileWriter(File/String) 覆盖模式，相当于流的指针在首端
* 2） new FileWriter(File/String, true) 追加模式，相当于流的指针在尾端
* 3） writer(char c) 写入单个字符
* 4） writer(char[] c) 写入字符数组
* 5） writer(char c, int off, int len) 写入数组的指定部分
* 6） writer(String str) 写入字符串
* 7） writer(String str, int off, int len) 写入字符串的指定部分
*
* 相关API：String.toCharArray 将String转换成char[]
*
* 注意： FileWriter使用后，必须要关闭（close）或刷新（flush），否则写入不到指定的文件
*       FileWriter不能处理 二进制文件(声音,视频,doc,pdf .等)
* */
public class FileWriter_ {
    public static void main(String[] args) {

    }

    public void writer01(){
        String filePath = "d:\\note.txt";
        FileWriter fileWriter = null;
        try {
            //fileWriter = new FileWriter(filePath, true); 追加
            fileWriter = new FileWriter(filePath); //覆盖
            //下面演示一下下面这些写入方法
            //writer(char c) 写入单个字符
            fileWriter.write('吴');
            //writer(char[] c) 写入字符数组
            char[] chars = {'小','文','是'};
            fileWriter.write(chars);
            //writer(char c, int off, int len) 写入数组的指定部分
            fileWriter.write(chars, 0, 1);
            //writer(String str) 写入字符串
            String str = "猪猪";
            fileWriter.write(str);
            //writer(String str, int off, int len) 写入字符串的指定部
            fileWriter.write(str, 0, 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //一定要记得 关闭文件流
                //fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
