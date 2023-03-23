package djb.array;
/*
* 二维数组的遍历
* */
public class ArrayTest11 {
    public static void main(String[] args) {
        //二维数组
        String[][] array = {
                {"java","oracle","c++","python","c#"},
                {"张三","李四","王五"},
                {"lucy","jack","rose"}
        };

        //遍历二维数组
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j] + " ");
            }
            //换行
            System.out.println();
        }
    }
}
