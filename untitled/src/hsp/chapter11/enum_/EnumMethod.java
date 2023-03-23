package hsp.chapter11.enum_;
//演示Enum类的各种方法的使用
public class EnumMethod {
    public static void main(String[] args) {
        //使用Season2 枚举类来演示各种方法
        Season2 autumn = Season2.AUTUMN;
        //1、toString：Enum类已经重写了，返回的是当前对象名，子类可以重写，用于返回对象的属性信息
        System.out.println(autumn);
        //2、name()：输出枚举对象的名字 AUTUMN
        System.out.println(autumn.name());
        //3、ordinal()：输出该枚举对象的次序/编号（相当于下标，编号从0开始） 2
        System.out.println(autumn.ordinal());

        //4、values()：从反编译枚举类，可以看出 values() ,返回 Season[]
        //这个Season数组含有定义的所有枚举类（常量）
        Season2[] values = autumn.values();
        System.out.println("=========遍历取出枚举对象=========");
        for (Season2 season : values) {//增强for循环
            System.out.println(season);
        }

        System.out.println("================================");
        //5、valueOf：将字符串转换成枚举对象，这个字符串必须为已有对象的常量名
        //执行流程：
        //1）根据你输入的 "AUTUMN" 到 Season2 的枚举对象去查找
        //2）如果找到了，则返回这个枚举对象，否则报错
        Season2 autumn1 = Season2.valueOf("AUTUMN");
        //Season2 autumn2 = Season2.valueOf("AUT");//报错
        System.out.println(autumn1);
        //判断一下上面的autumn 是否和 autumn1 是同一个对象
        System.out.println(autumn == autumn1); //true

        //6、compareTo：比较两个枚举常量，比较的就是编号
        //把 Season.AUTUMN 枚举对象的编号[2] 减去 Season2.SPRING 枚举对象的编号[0]
        /* Enum里面的compareTo()
        public final int compareTo(E o) {
            Enum<?> other = (Enum<?>)o;
            Enum<E> self = this;
            if (self.getClass() != other.getClass() && // optimization
                    self.getDeclaringClass() != other.getDeclaringClass())
                throw new ClassCastException();
            return self.ordinal - other.ordinal; //返回的结果 就是两个对象编号相减
        }
        */
        System.out.println(Season2.AUTUMN.compareTo(Season2.SPRING)); // 2



        /*
        //解析一下这个增强for循环
        int[] nums = {1, 2, 9};
        //普通for循环
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
        //对应的增强for循环
        for (int i : nums) { //执行流程是，依次从nums数组中取出数组，赋值给i，取完则退出for循环
            System.out.println(i);
        }
        */

    }
}
