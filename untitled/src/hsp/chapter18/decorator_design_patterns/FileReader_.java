package hsp.chapter18.decorator_design_patterns;
//模拟 FileReader（节点流）
public class FileReader_ extends Reader_ {
    public void read(){
        System.out.println("对文件进行读取..");
    }
}
