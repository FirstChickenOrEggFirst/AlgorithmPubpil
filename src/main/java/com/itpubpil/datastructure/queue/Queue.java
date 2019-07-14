package com.itpubpil.datastructure.queue;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 15:08
 * desc:
 * 队列，先进先出 FIFO
 */
public interface Queue<T> {
    /**
     * 入队
     *
     * @param t
     */
    void enquque(T t);

    /**
     * 出队
     *
     * @return
     */
    T dequeue();

    /**
     * 查看队首元素
     *
     * @return
     */
    T getFront();

    /**
     * 查看队列中的元素数量
     *
     * @return
     */
    int getSize();

    /**
     * 查看队列是否为空
     *
     * @return
     */
    boolean isEmpty();
}
