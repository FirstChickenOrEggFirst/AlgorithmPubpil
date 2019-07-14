package com.itpubpil.datastructure.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 15:16
 * desc:
 * 测试数组实现的队列
 */

public class ArrayQueueTest {
    private Queue<Integer> queue;

    @Before
    public void initQueue() {
        queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enquque(i);
        }
    }

    @Test
    public void testQueue() {
        System.out.println("simple: " + queue);
        Assert.assertEquals(10, queue.getSize());

        Integer front = queue.getFront();
        Assert.assertEquals(0, front.intValue());
        System.out.println("getFront: " + queue);
        Assert.assertEquals(10, queue.getSize());

        Integer dequeue = queue.dequeue();
        Assert.assertEquals(0, dequeue.intValue());
        System.out.println("dequeue: " + queue);
        Assert.assertEquals(9,queue.getSize());
    }
}
