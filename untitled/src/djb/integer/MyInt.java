package djb.integer;
/*
* 这种包装类是我自己写的，实际开发中我们不需要自己写。
* 8种基本数据类型对应的8种包装类，SUN公司已经写好了，我们直接用
* */
public class MyInt {
    int value;

    public MyInt() {
    }

    public MyInt(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
