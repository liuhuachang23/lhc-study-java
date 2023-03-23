package hsp.chapter18.decorator_design_patterns;
//模拟 BufferedReader （处理流）
public class BufferedReader_ extends Reader_ {
    private Reader_ reader_;  //定义了一个Reader_属性

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void read(){
        reader_.read();
    }
    //扩展readFile，多次读取文件
    public void read(int num){
        for (int i = 0; i < num; i++) {
            reader_.read();
        }
    }

}
