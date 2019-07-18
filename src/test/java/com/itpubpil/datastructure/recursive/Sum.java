package com.itpubpil.datastructure.recursive;

import org.junit.Test;

/**
 * @author wangjingbiao
 * createTime: 2019/7/18 22:55
 * desc:
 * 使用递归实现数组求和
 * 递归实际上就是把一个问题转化为更简单的问题，直到最简单的一个问题。
 */
public class Sum {
    /**
     * 递归求和
     *
     * @param arr 数组
     * @param l   左边界
     * @return 和
     */
    private int sum(int[] arr, int l) {
        // 左边界到达右边界，递归退出
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }

    private int sum(int[] arr) {
        return sum(arr, 0);
    }

    @Test
    public void testSum() {
        int[] a = new int[]{1, 2, 3, 5};
        System.out.println(sum(a));
    }
}
