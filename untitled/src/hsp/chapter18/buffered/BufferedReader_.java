package hsp.chapter18.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\story.txt";
        //创建BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;
        //readLine()按行读取
        //当返回null时表示读取完毕
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //关闭流,
        //注意，这里只需要关闭外层流（处理流）就可以，因为底层会自动去关闭 节点流
        /*public void close() throws IOException {
            synchronized (lock) {
                if (in == null)
                    return;
                try {
                    in.close(); //in 就是传入的节点流
                } finally {
                    in = null;
                    cb = null;
                }
            }
        }*/
        bufferedReader.close();
    }
}
