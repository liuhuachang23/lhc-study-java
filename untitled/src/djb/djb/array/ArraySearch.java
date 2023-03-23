package djb.array;
/*
* 数组元素查询:
*   第一种方式：一个一个挨着找
*   第二种方式：二分法查询
* */
public class ArraySearch {
    public static void main(String[] args) {
        //第一种方式
        int[] arr = {1,2,3,4,55,8};
        //需求：找出55的下标
        //一个个挨着找
        /*
        for (int i = 0; i <arr.length; i++) {
            if (arr[i] == 55){
                System.out.println("55的下标元素是: " + i);
                return;
            }
        }
        //程序可以到这里表示数组中没有55
        System.out.println("不存在该元素");*/

        //最好是封装一个方法
        //思考:传什么参数?返回什么值?
        //传什么:第一个参数是数组,第二个参数是被查找的元素
        //返回值:返回被查找这个元素的下标,如果找不到返回-1.
        int index = arraySearch(arr ,55);
        System.out.println(index == -1 ? "该元素不存在" : "该元素下标是: " + index);

    }

    /**
     * 从数组中检索某个元素的下标(数组中存在相同值的话,返回的是第一个元素的下标)
     * @param arr 被检索的数组
     * @param ele 被检索的元素
     * @return 返回值大于大于0,表示检索元素的下标.返回值为-1,表示该元素不存在
     */
    public static int arraySearch(int[] arr, int ele) {
        for (int j = 0; j <arr.length ; j++) {
            if (ele == arr[j]){
                return j;
            }
        }
        return -1;
    };
}
