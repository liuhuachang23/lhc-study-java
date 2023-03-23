package hsp.chapter07.array;
//用二维数组打印出 杨辉三角
public class YangHui {
    public static void main(String[] args) {
        //创建一个二维数组，注意其中的一维数组还未开辟空间
        int[][] arr = new int[10][];

        for (int i = 0; i <arr.length ; i++) {
            //给二维数组中的每一个一维数组开辟空间
            arr[i] = new int[i + 1];
            //遍历一维数组，给一维数组的每个元素赋值
            for (int j = 0; j <arr[i].length ; j++) {

                if (j == 0 || j == arr[i].length - 1) {
                    //杨辉三角中每一层上的第一个元素和最后一个元素都为1
                    //(二维数组中的每一个一维数组中第一个和最后一个了元素都为1)
                    arr[i][0] = 1;
                    arr[i][arr[i].length - 1] = 1;
                } else {
                    //中间的元素为上一个 一维数组中:对应下标的元素值与其前一个元素值之和
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }
        //遍历
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
