package com.itpubpil.datastructure.statck;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 14:07
 * desc:
 * 定义栈 interface
 * 栈后进先出 LIFO，用处很多，比如函数中的调用链
 */
public interface Stack<T> {
    /**
     * 入栈元素
     * @param t
     */
    void push(T t);

    /**
     * 出栈元素
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();

    /**
     * 获取栈大小
     * @return
     */
    int getSize();

    /**
     * 查看栈是否为空
     * @return
     */
    boolean isEmpty();
}
