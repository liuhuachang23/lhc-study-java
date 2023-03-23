package hsp.chapter12.stringbuilder;

/*
* String、StringBuffer、StringBuilder 的比较
*
* 1）String：不可变序列，效率低，但是复用性高
* 2）StringBuffer：可变序列、效率较高（增删）、线程安全
* 3）StringBuilder：可变序列、效率最高（增删）、线程不安全
*
* 4）StringBuffer和StringBuilder 非常类似，均代表可变的字符序列，而且方法也一样
*
* 5）String使用注意说明：
* String s = "a"; //创建了一个字符串
* s += "b"; //实际上原来的"a"字符串已经被丢弃，现在又产生一个字符串s + "b"（"ab"）.
* 如果多次执行这种操作，会导致大量副本字符串对象存留再内存中，减低效率，放到循环中也极大影响程序的性能
* 6）结论：
*   如果字符串存在大量的修改操作，并且在单线程的情况，使用StringBuilder
*   如果字符串存在大量的修改操作，并且在多线程的情况，使用StringBuffer
*   如果字符串很少修改，被多个对象引用，使用String（比如配备信息等）
*/
public class StringVsStringBufferVsStringBuilder {

}
