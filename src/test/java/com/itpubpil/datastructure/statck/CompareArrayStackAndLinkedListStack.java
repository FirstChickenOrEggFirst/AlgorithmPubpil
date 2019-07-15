package com.itpubpil.datastructure.statck;

import org.junit.Test;

import java.util.Random;

/**
 * @author wangjingbiao
 * createTime: 2019/7/15 23:15
 * desc:
 * 比对数组实现的栈和链表实现的栈的性能差异
 */
public class CompareArrayStackAndLinkedListStack {
    /**
     * 二者的算法复杂度都是一样的，
     * 但是arrayStack需要扩展空间，linkedListStack需要不断寻找可开辟空间，所以也有差异
     */
    @Test
    public void compare() {
        int opCount = 5000000;
        Stack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("arrayStack: " + time1);
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack: " + time2);
    }

    private double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

}
