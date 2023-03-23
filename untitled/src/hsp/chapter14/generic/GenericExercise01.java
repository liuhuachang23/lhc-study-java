package hsp.chapter14.generic;

import java.util.*;

class GenericExercise01 {
    public static void main(String[] args) {
        //创建3个学生对象
        Student s1 = new Student("小明", 21);
        Student s2 = new Student("李军", 20);
        Student s3 = new Student("小红", 19);

        //放入到HashMap中
        /*
            public class HashMap<K,V> {}
        */
        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        hashMap.put(s1.name,s1);
        hashMap.put(s2.name,s2);
        hashMap.put(s3.name,s3);

        //遍历
        //entrySet方式
        /*  entrySet() 底层：
            public Set<Map.Entry<K,V>> entrySet() {
                Set<Map.Entry<K,V>> es;
                return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
            }
        */
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();

        //1.使用迭代器遍历
        /* iterator()底层：
            public final Iterator<Map.Entry<K,V>> iterator() {
                return new EntryIterator();
            }
        */
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
        System.out.println("---------");

        //使用增强for
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


        //放入到HashSet中
        System.out.println("===HashSet===");
        /*
        public class HashSet<K,V> {}
        */
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        //使用增强for
        for (Student student : hashSet) {
            System.out.println(student.name + "-" + student.age);
        }
        System.out.println("--------");
        //使用迭代器
        Iterator<Student> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()) {
            Student next = iterator1.next();
            System.out.println(next.name + "-" + next.age);
        }

    }
}

class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
