package hsp.chapter18.decorator_design_patterns;
//模拟 StringReader（节点流）
public class StringReader_ extends Reader_ {
    public void read(){
        System.out.println("对字符串进行读取..");
    }
}
