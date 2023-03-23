package hsp.chapter11.enum_;

//1.使用enum关键字后，就不能继承其他类了，因为enum类会隐式继承Enum，而Java机制是单继承
//2.枚举类和普通类一样，可以实现接口
public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASS_MUSIC.play();
    }
}

interface IP {
    void play();
}

enum Music implements IP{
    //public static final Music CLASS
    CLASS_MUSIC;

    @Override
    public void play() {
        System.out.println("播放好听的音乐");
    }
}
