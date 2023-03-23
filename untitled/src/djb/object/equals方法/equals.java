package djb.object.equals方法;

/*
*关于Object类中equals方法
*
*   1.equals方法的源代码
*       public boolean equals(Object obj) {
*           return (this == obj);
*       }
*       以上这个方法是Object类的默认实现。
*
*   2.在Object类中的equals方法当中，默认采用的是"=="判断两个java对象
*     是否相等（"=="判断的是两个java对象的内存地址）
*
*   3. 需求:
*       现在我们需要判断两个java对象中的内容是否相等
*       老祖宗的equals方法不够用，我们就需要子类重写equals方法
*
*   4.重写equals : IDEA工具 可以快速生成equals方法
*       快捷键 alt + insert
*
* */
public class equals {
    public static void main(String[] args) {

        //判断两个基本数据类型用"=="就行
        int a = 50;
        int b = 100;
        System.out.println(a == b); //false

        //--------------------------------------------------------------------------------------

        //判断两个Java对象(的内容)是否相等，重写equals方法

        //创建两个日期对象都是:2008/8/8
        MyTime t1 = new MyTime(2008,8,8);
        MyTime t2 = new MyTime(2008,8,8);

        //如果用"=="判断,比较的是两个java对象的内存地址,而不是内容,所以答案还是false
        System.out.println(t1 == t2); //false

        //判断两个java对象里面的内容是否相等,怎么办?
        //重写equals方法

        //没重写前 使用Object继承下来的equals方法
        //System.out.println(t1.equals(t2)); //结果还为false,所以必须重写才能满足需求

        //重写后,成功了
        System.out.println(t1.equals(t2)); //true

    }
}

class MyTime{

    int year;
    int month;
    int day;

    public MyTime() {
    }

    public MyTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //继承过来的equals方法
    /*public boolean equals(Object obj){
        return (this = obj);
    }*/

    //重写Object类中的equals方法
    //怎么重写.相同的返回值类型,相同的方法名,相同的形式参数列表
    public boolean equals(Object obj) {

        /*
        //获取当一个日期的年月日
        int year1 = this.year;
        int month1 = this.month;
        int day1 = this.day;

        //获取第二个日期的年月日
        //因为Object类中没有 年月日 所以不能和上面一样获取,
        //需要进行向下转型,将 obj 转成 MyTime 这样就能在 obj 中获取年月日了
        if (obj instanceof MyTime){
            MyTime t = (MyTime)obj;
            int year2 = t.year;
            int month2 = t.month;
            int day2 = t.day;
            //判断两个对象当中的日期是否相等
            if (year1 == year2 && month1 == month2 && day1 == day2){
                return true;
            }
        }
        //程序可以执行到这里表示日期不相等
        return false;
        */

        //可将重写代码简化为以下
        if (obj == null || !(obj instanceof MyTime)){       // obj是空 或者 obj不是一个MyTime 两个都不需要下一步比较
            return false;
        }
        if (this == obj){       // this 和 obj 保存的内存地址相同 ,也没必要比较了(同一个对象内容一定相同)
            return true;
        }
        MyTime t = (MyTime)obj;     //此时可以确定obj一定是一个MyTime 所以不需要instanceof判断,直接向下转型
        return this.year == t.year && this.month == t.month && this.day == t.day;
    }
}
