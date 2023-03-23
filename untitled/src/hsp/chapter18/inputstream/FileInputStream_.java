package hsp.chapter18.inputstream;


import java.io.FileInputStream;
import java.io.IOException;

/*
使用 FileInputStream ,演示将文件读取到程序中
注意：使用文本字节输入流，不能读取中文字符(在 utf-8编码中 中文字符由3个字节组成，字节输出流是按字节读取，所以会出现乱码)
*/
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 使用 read() 读取文件
     * 一个个字节读取
     */
    public void readFile01() {
        String filePath = "d:\\hello.txt";
        FileInputStream fileInputStream = null;
        int readDate = 0;
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //read() 从该输入流读取一个字节的数据,如果没有输入可用,此方法将阻止
            //一个个字节读取,直到读取完毕,就返回-1
            while ((readDate = fileInputStream.read()) != -1) { //将读到的值转成一个int 判断是否读取完毕
                System.out.print((char) readDate); //再转回char类型,输出
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭文件流,释放资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 使用 read(byte[] b) 读取文件
     * 单个单个字节数组 读取,提高效率
     */
    public void readFile02() {
        String filePath = "d:\\hello.txt";
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[8];
        int readLen = 0; //实际读取字节的长度
        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //read(byte[] b) 从该输入流读取最多b.length字节的数据到字节数组,如果没有输入可用,此方法将阻止
            //读取正常,返回实际读取的字节数, 直到读取完毕, 就返回-1
            while ((readLen = fileInputStream.read(buf)) != -1) { //将实际读取的字节数赋值给readLen, 并判断是否读取完毕
                System.out.println(new String(buf,0,readLen)); //后面两个参数不写,默认写入整个字节数组,但可能会出现文件损失
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流,释放资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

