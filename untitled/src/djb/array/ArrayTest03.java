package djb.array;
/*
* 当一个方法的参数是一个数组的时候
* */
public class ArrayTest03 {
    public static void main(String[] args) {

        //调用方法时传一个数组

        System.out.println("================静态初始化===============");
        int[] x = {1,2,3,4};
        printArray(x);

        String[] strs ={"abx","dwe","wrr","tge"};
        printArray(strs);

        System.out.println("================动态初始化================");

        int[] y = new int[3];
        printArray(y);

        String[] strArray = new String[3];
        printArray(strArray);

        System.out.println("===========以下为简化代码===============");
        printArray(new int[3]);
        printArray(new String[3]);

    }

    public static void printArray(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static void printArray(String[] args){
        for (int i = 0; i <args.length ; i++) {
            System.out.println("String数组中的元素" + args[i]);
        }
    }
}
