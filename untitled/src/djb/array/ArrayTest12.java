package djb.array;
/*
* 动态初始化二维数组
* */
public class ArrayTest12 {
    public static void main(String[] args) {
        //3行4列
        int[][] array = new int[3][4];

        //遍历
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j] + " ");
            }
            //换行
            System.out.println();
        }

        System.out.println("---------------------------------------");

        //静态初始化
        int[][] a = {
                {1,2,3,4,5,6},
                {22,31,5,474,33},
                {11,32,56}
        };

        printArray(a);

        //合并
        printArray(new int[][] {{1,2,3,4,5,6}, {22,31,5,474,33}, {11,32,56}});
    }

    public static void printArray(int[][] array){
        //遍历
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j] + " ");
            }
            //换行
            System.out.println();
        }
    }
}
