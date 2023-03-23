package hsp.chapter13.set.linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;

/*
* LinkedHashSet全面说明
* 1) LinkedHashSet 是 HashSet 的子类
* 2) LinkedHashSet 底层是一个LinkedHashMap, 底层维护了一个 数组+双向链表
* 3) LinkedHashSet 根据元素的 hashCode值来1决定元素的存储位置, 同时使用链表维护元素的次序, 这使得元素看来是已插入顺序保存的
* 4) LinkedHashSet 不允许重复元素
*
* */
public class LinkedHashSet_ {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();

    }
}
