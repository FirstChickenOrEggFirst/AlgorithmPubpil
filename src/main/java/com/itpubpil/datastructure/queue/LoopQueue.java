package com.itpubpil.datastructure.queue;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 15:35
 * desc:
 * 循环队列，优化出队操作，出队由O(n) 优化为 O(1)
 */
public class LoopQueue<T> implements Queue<T> {
    private T[] data;
    /**
     * 队首，队尾
     */
    private int front, tail;
    /**
     * 队列当前元素数量
     */
    private int size;
    /**
     * 默认队列初始化长度
     */
    public static final int DEFAULT_CAPACITY = 10;

    public LoopQueue(int capacity) {
        // 循环队列会浪费一个元素，要在原容量上加一
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(DEFAULT_CAPACITY);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public void enQueue(T t) {
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }
        data[tail] = t;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        T ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //缩容量
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot getFront from an empty queue");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
