package djb.integer;

/*
* int String Integer 三种类型之间的互相转换：
*
* （i表示int类型数据、ig表示Integer类型数据、str表示String类型数据）
*
* 1、int --> String
*       String s = i + str
*       String s = String.valueOf(i)
*
* 2、String --> int
*       int i = Integer.parseInt(str)
*
* 3、int --> Integer
*       自动装箱：Integer ig = i
*       Integer ig = Integer.valueOf(i)
*
* 4、Integer --> int
*       自动拆箱 int i = ig
*       int i = intValue(ig)
*
* 5、String --> Integer
*       Integer ig = Integer.valueOf(str)
*
* 6、Integer --> String
*       String str = String.valueOf(ig)
*
* */
public class IntegerTest07 {
    public static void main(String[] args) {
        
        int i = 100;
        //int --> String
        String s1 = String.valueOf(i);
        System.out.println(s1 + 1); //"1001"

        //String --> int
        int i1 = Integer.parseInt(s1);
        System.out.println(i1 + 1); //101

        //int --> Integer
        Integer ig1 = i1;
        System.out.println(ig1); //"100"
        //"+"号两边要求是基本数据类型，所以会将Integer的i3自动转换为基本数据类型
        //如果两边有一侧是字符串时，则会将另一侧转换为引用数据类型，发生字符串拼接
        System.out.println(ig1 + 1); //101
        System.out.println("100" + ig1); //100100

        //Integer --> int
        int i2 = ig1;
        System.out.println(i2 + 1); //101

        //String --> Integer
        Integer ig2 = Integer.valueOf(s1);
        System.out.println(ig2); //"100"

        //Integer --> String
        String s2 = String.valueOf(ig2);
        System.out.println(s2); //"100"

    }
}
