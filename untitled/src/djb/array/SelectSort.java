package djb.array;
/*
* 选择排序
* */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = {6, 2, 5, 7, 3, 1};

        for (int i = 0; i <arr.length -1; i++) {
            //假设起点:下标位置上我元素是最小值
            int min = i;
            for (int j = i+1; j < arr.length ; j++) {
              if (arr[j] < arr[min]){
                min = j; //最小元素的下标是j
              }
            }

            if (min != i){
                int temp;
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

        //重新遍历
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
}
