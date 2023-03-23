package hsp.chapter18.buffered;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\note.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.newLine(); //插入一个和系统相关的换行
        bufferedWriter.write("hello, 吴小文 ");
        bufferedWriter.newLine();
        bufferedWriter.write("hello, 吴小文 ");
        bufferedWriter.newLine();
        bufferedWriter.write("hello, 吴小文 ");

        //关闭外层流
        bufferedWriter.close();
    }
}
