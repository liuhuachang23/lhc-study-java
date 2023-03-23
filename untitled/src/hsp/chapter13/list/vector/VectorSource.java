package hsp.chapter13.list.vector;

import java.util.Vector;

/*
*
* Vector的底层操作机制源码分析:
* */
public class VectorSource {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //使用无参数构造器创建Vector对象
        Vector vector = new Vector(1);

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        vector.add(100);
        /*
        1.无参构造器默认数组大小为10

        2. vector.add(i)
         1) 下面这个方法就是添加数据到vector集合
            public synchronized boolean add(E e) {
                modCount++;
                ensureCapacityHelper(elementCount + 1);
                elementData[elementCount++] = e; //数据添加
                return true;
            }
         2) 进入ensureCapacityHelper(elementCount + 1) 确定是否需要扩容
            private void ensureCapacityHelper(int minCapacity) {
                if (minCapacity - elementData.length > 0)
                grow(minCapacity);
            }
         3)如果容量不够了就进入 grow(minCapacity)
            扩容算法 int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
             这个三目运算符中 capacityIncrement永远等于0(没有被修改的情况下) 所以永远是2倍扩容

            private void grow(int minCapacity) {
                int oldCapacity = elementData.length;
                int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                                capacityIncrement : oldCapacity);
                if (newCapacity - minCapacity < 0)
                    newCapacity = minCapacity;
                if (newCapacity - MAX_ARRAY_SIZE > 0)
                    newCapacity = hugeCapacity(minCapacity);
                elementData = Arrays.copyOf(elementData, newCapacity);
            }
          4)然后一步步返回完成 第一步的 数据添加
        */

    }

}
