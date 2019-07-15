package com.itpubpil.datastructure.statck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wangjingbiao
 * createTime: 2019/7/15 23:11
 * desc:
 * 链表栈测试类
 */
public class LinkedListStackTest {
    private Stack<Integer> stack = null;

    @Before
    public void initStack() {
        stack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
    }

    @Test
    public void testStack() {
        System.out.println("simple: " + stack);
        Integer peek = stack.peek();
        System.out.println("peek: " + stack);
        Assert.assertEquals(9, peek.intValue());
        Assert.assertEquals(10, stack.getSize());
        Integer pop = stack.pop();
        Assert.assertEquals(9, pop.intValue());
        Assert.assertEquals(9, stack.getSize());
        stack.push(109);
        Assert.assertEquals(109, stack.peek().intValue());
        System.out.println("push: " + stack);
    }


}
