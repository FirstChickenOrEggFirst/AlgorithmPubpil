package com.itpubpil.datastructure.statck;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 14:28
 * desc:
 * 测试数组实现的栈
 */
public class ArrayStackTest {
    private Stack<Integer> stack = null;

    @Before
    public void initStack() {
        stack = new ArrayStack<>();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
    }

    @Test
    public void testStack() {
        System.out.println("simple: " + stack);
        Integer peek = stack.peek();
        System.out.println("peek: " + stack);
        Assert.assertEquals(99, peek.intValue());
        Assert.assertEquals(100, stack.getSize());
        Integer pop = stack.pop();
        Assert.assertEquals(99, pop.intValue());
        Assert.assertEquals(99, stack.getSize());
        stack.push(109);
        Assert.assertEquals(109, stack.peek().intValue());
        System.out.println("push: " + stack);
    }
}
