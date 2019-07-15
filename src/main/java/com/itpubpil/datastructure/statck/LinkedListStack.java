package com.itpubpil.datastructure.statck;

import com.itpubpil.datastructure.base.LinkedList;

/**
 * @author wangjingbiao
 * createTime: 2019/7/15 23:07
 * desc:
 * 基于链表实现栈
 */
public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void push(T t) {
        linkedList.addFirst(t);
    }

    @Override
    public T pop() {
        return linkedList.removeFirst();
    }

    @Override
    public T peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkedList);
        return res.toString();
    }
}
