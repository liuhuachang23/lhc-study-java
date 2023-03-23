package hsp.chapter13.homework;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings({"all"})
public class Homework04{
    public static void main(String[] args) {
        /*Set set = new HashSet();
        set.add("jack");
        set.add("tom");
        set.add("jack");
        System.out.println(set);*/

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).compareTo((String)o2);
            }
        });
        treeSet.add("jack");
        treeSet.add("jack");
    }
}
