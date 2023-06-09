package hsp.chapter13.list.vector;
/*
 Vector和ArrayList的比较
_____________________________________________________________________________________
               |底层结构      |版本        | 线程安全(同步)效率      |   扩容倍数
_______________|_____________|___________|________________________|______________________
 ArrayList     |可变数组      |jdk1.2     |不安全, 效率高           | 如果是有参构造1.5倍扩容
               |             |           |                        | 如果是无参 第一次10
               |             |           |                        | 第二次按1.5倍
_______________|_____________|___________|______________________________________________
 Vector        |可变数组      |jdk1.0     安全 , 效率不高           | 如果是无参,默认10
               |             |           |                        | 满后按2倍扩容
               |Object[]     |           |                        | 果然是指定大小,满后按2倍
_______________|_____________|___________|________________________________________________

* */
public class ArrayListVsVector {
}
