package hsp.chapter18.file;


import org.junit.Test;

import java.io.File;

public class Directory {
    public static void main(String[] args) {

    }

    //判断 d:\news1.txt 是否存在, 存在的话就删除
    @Test
    public void m1() {
        String filePath = "d:\\news1.txt"; //文件路径
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(file.getName() + " 删除成功");
            } else {
                System.out.println(file.getName() + " 删除失败");
            }
        } else {
            System.out.println("文件不存在");
        }
    }

    //判断 D:\\demo02 是否存在, 存在就删除 , 否则提示不存在
    public void m2() {
        String filePath = "D:\\\\demo02"; //文件路径
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(file.getName() + " 删除成功");
            } else {
                System.out.println(file.getName() + " 删除失败");
            }
        } else {
            System.out.println("目录不存在");
        }
    }

    //判断 D:\\demo\\a\\b\\c 目录是否存在, 如果存在就提示已经存在,否则就创建
    public void m3() {
        String directPath = "D:\\demo\\a\\b\\c"; //文件路径
        File file = new File(directPath);
        if (file.exists()) {
            System.out.println(file + " 目录存在");
        } else {
            if (file.mkdirs()) { //mkdirs()创建多级目录 mkdir()创建一级目录
                System.out.println(file + " 创建成功");
            } else {
                System.out.println(file + " 创建失败");
            }
        }
    }

}
