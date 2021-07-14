package com.itpubpil.datastructure.set;


import com.itpubpil.datastructure.base.LinkedList;

/**
 * @author wangjingbiao
 * createTime: 2021/7/14 7:55
 * desc:
 */
public class LinkedListSet<E> implements Set<E>{
    private final LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if(!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
