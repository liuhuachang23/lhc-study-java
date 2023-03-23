package hsp.chapter12.stringbuffer;
/*
要求将价格的小数点前每3位数用逗号隔开
比如将：1123564.59
输出为：1,123,564.59
 */
public class StringBufferExercise02 {
    public static void main(String[] args) {
        String price = "1123564.59";

        StringBuffer sb = new StringBuffer(price);

        int i = sb.lastIndexOf(".");
        //sb.insert(i-3,",");
        //System.out.println();

        for (int j = sb.lastIndexOf(".")-3; j > 0 ; j -=3) {
            sb.insert(j,",");
        }
        System.out.println(sb);


    }
}
