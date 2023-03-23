package hsp.chapter13.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class Homework03 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);

        map.put("jack", 2600);

        //为所有员工工资加薪100元；
        Set set = map.entrySet();
        for (Object o: set ) {
            Map.Entry entry = (Map.Entry) o;
            Integer ig = (Integer)entry.getValue() + 100;
            System.out.println(entry.getKey() + "-" + ig);
        }


    }
}
