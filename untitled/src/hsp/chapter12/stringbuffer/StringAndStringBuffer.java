package hsp.chapter12.stringbuffer;
//String 和 StringBuffer 之间的转换
public class StringAndStringBuffer {
    public static void main(String[] args) {

        //String --> StringBuffer
        //方式1.使用构造器
        String str = "hello tom";
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式2.使用spend方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        //StringBuffer --> String
        StringBuffer stringBuffer2 = new StringBuffer("韩顺平教育");
        //方式1:使用StringBuffer提供的 toString方法
        String s = stringBuffer2.toString();
        //方式2:使用构造器
        String s1 = new String(stringBuffer2);

    }
}
