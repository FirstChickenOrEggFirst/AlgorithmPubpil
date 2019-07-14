package com.itpubpil.datastructure.statck;

import com.itpubpil.datastructure.base.Array;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 14:15
 * desc:
 * 基于二次封装的动态数组，实现栈
 */
public class ArrayStack<T> implements Stack<T> {
    private Array<T> array;

    /**
     * 构造指定长度的动态数组
     *
     * @param capacity 数组初始容量
     */
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    /**
     * 构造默认容量的动态数组，具体取决于Array中的取值
     */
    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(T t) {
        array.addLast(t);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
