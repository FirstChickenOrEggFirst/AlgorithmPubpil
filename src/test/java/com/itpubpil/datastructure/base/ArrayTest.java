package com.itpubpil.datastructure.base;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wangjingbiao
 * createTime: 19-7-12 下午4:42
 * desc:
 * 测试封装的数组的基本使用
 */
public class ArrayTest {

    @Test
    public void testBasicOperate() {
        Array<Integer> array = new Array<>(5);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());
        // 测试添加元素
        array.add(8, 99);
        System.out.println(array.toString());
        array.addFirst(100);
        System.out.println(array);
        // 测试移除元素
        array.remove(8);
        System.out.println(array);

    }

    @Test
    public void sayHello() {
        System.out.println("hello");
    }
}