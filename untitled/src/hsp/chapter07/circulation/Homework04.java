package hsp.chapter07.circulation;
//输出小写a~z 和大写A~Z
public class Homework04 {
    public static void main(String[] args) {

        for (char j = 'a'; j < 'a' +26; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (char i = 'A'; i <'A' + 26 ; i++) {
            System.out.print(i + " ");
        }
    }
}
