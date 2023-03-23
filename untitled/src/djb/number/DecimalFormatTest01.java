package djb.number;

import java.text.DecimalFormat;

/*
* 关于数字格式化（了解）
* */
public class DecimalFormatTest01 {
    public static void main(String[] args) {
        //java.text.DecimalFormat专门负责数字格式化
        //DecimalFormat df = new DecimalFormat("数字格式")

        /*
        数字格式有那些
            # 代表任意数字
            , 代表千分位
            . 代表小数点

            如： ###,###.## 表示加入千分位，保留两位小数
         */
        DecimalFormat df = new DecimalFormat("###,###.##");
        String s = df.format(1234.56123);
        System.out.println(s); //1,234.56

        DecimalFormat df2 = new DecimalFormat("###,###.0000");
        String s2 = df2.format(1234.56);
        System.out.println(s2); //1,234.5600
    }
}
