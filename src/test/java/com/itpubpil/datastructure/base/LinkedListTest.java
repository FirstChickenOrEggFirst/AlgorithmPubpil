package com.itpubpil.datastructure.base;

import org.junit.Test;
/**
 * @author wangjingbiao
 * createTime: 2019/7/15 22:52
 * desc:
 */

public class LinkedListTest {
    @Test
    public void testMyLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,777);
        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
    }


}
