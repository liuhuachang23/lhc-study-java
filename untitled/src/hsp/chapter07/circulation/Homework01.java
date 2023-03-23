package hsp.chapter07.circulation;

public class Homework01 {
    public static void main(String[] args) {
        //拥有的钱数
        double money = 100000;
        //经过的路口数
        int count = 0;
        while(money >= 1000){

           if (money > 50000){
               money -= money*0.05;
           } else if (money >= 1000){
               money -= 1000;
           } else {
               break;
           }
           count++;
        }
        System.out.println("一共可以过: " + count + "个路口");
    }
}
