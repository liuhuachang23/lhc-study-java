package hsp.chapter08.homework;
//定义一个Music类，里面有 音乐名name、音乐时长times 属性，并有播放play功能和返回值本身属性信息的功能方法getInfo
public class Homework07 {
    public static void main(String[] args) {
        Music music = new Music("爱你一万年","4 mine");
        music.play();
        System.out.println(music.getInfo());
    }
}

class Music{
    String name;
    String times;

    public Music(String name, String times) {
        this.name = name;
        this.times = times;
    }

    public String getInfo(){
        return "该歌曲的名称为 " + name + "  播放时长：" + times;
    }

    public void play(){
        System.out.println("开始播放: \n" + getInfo());
    }
}
