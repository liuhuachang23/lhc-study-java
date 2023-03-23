package hsp.chapter13.list.vector;

import java.util.Vector;

/*
* Vector基本介绍
*
* 1)Vector类的定义说明
*   public class Vector<E>
*   extends AbstractList<E>
*   implements List<E>, RandomAccess, Cloneable, Serializable
*
* 2)Vector底层也是一个对象数组,protected Object[] elementData;
*
* 3)Vector是线程同步的,即线程安全,Vector类的操作方法带有synchronized
*
* 4)在开发中,需要线程同步安全时,考虑用Vector
*
* */
public class Vector_ {

    public static void main(String[] args) {

        Vector vector = new Vector();

        /*
        Vector是线程同步的,即线程安全,Vector类的操作方法带有synchronized

        public synchronized boolean add(E e) {
            modCount++;
            ensureCapacityHelper(elementCount + 1);
            elementData[elementCount++] = e;
            return true;
        }
        */
    }
}
