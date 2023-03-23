package hsp.chapter18.file;


import java.io.File;
import java.io.IOException;

public class FileInformation {
    public static void main(String[] args) {

    }

    //获取文件信息
    public void info() throws IOException {
        //先创建文件
        File file = new File("d:\\news1.txt");
        file.createNewFile();

        //调用相应方法, 得到对应信息
        System.out.println("文件名字: " + file.getName());
        System.out.println("文件绝对路径: " + file.getAbsolutePath());
        System.out.println("文件父级目录: " + file.getParent());
        System.out.println("文件大小(字节): " + file.length());
        System.out.println("文件是否存在: " + file.exists());
        System.out.println("是否为非目录文件: " + file.isFile());
        System.out.println("是否为目录文件(文件夹): " + file.isDirectory());

    }
}
