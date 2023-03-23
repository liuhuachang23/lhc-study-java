package hsp.chapter18.file;


import java.io.File;
import java.io.IOException;

/*
 * 创建文件对象相关构造器和方法
 *
 * 相关方法:
 *
 * 1) new File(String pathname) //根据 绝对路径 构建一个File对象
 * 2) new File(File parent, String child) //根据 父目录文件 + 子路径 构建
 * 3) new File(String parent, String child) //根据 父目录文件路径 + 子路径 构建
 *
 * 目录 我们可以理解为文件夹,也可以当做文件来处理
 *
 * createNewFile 创建新文件
 * */
public class FileCreate02 {
    public static void main(String[] args) {
    }

    //1) new File(String pathname)
    public void create01(){
        String filePath = "d:\\news1.txt"; //绝对路径
        //这里file对象,在java程序中,只是一个对象
        //只有执行了 createNewFile() 才会真正的在磁盘创建该文件
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2) new File(File parent, String child)
    public void create02(){
        File parentFile = new File("d:\\"); //父目录文件
        String fileName = "news2.txt"; //子路径
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //3) new File(String parent, String child)
    public void create03(){
        String parentName = "d:\\"; //父目录路径
        //String parentName = "d:/";
        String fileName = "news3.txt"; //子路径
        File file = new File(parentName, fileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

