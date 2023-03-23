package hsp.chapter18.buffered;

import java.io.*;
/*
* 字符处理流拷贝文件
* 使用 BufferedReader和BufferedWriter
* 注意:这里不能处理 二进制文件(声音,视频,doc,pdf .等)
* */
public class BufferedCopy01 {
    public static void main(String[] args) {
        String srcFilePath = "d:\\note.txt";
        String destFilePath = "d:\\note1.txt";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
