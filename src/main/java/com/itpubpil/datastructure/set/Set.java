package com.itpubpil.datastructure.set;

/**
 * @author wangjingbiao
 * createTime: 2021/6/24 22:38
 * desc:
 * 集合数据定义
 */
public interface Set<E> {
    /**
     * 添加元素
     */
    void add(E e);

    /**
     * 删除元素
     */
    void remove(E e);

    /**
     * 判断是否包含某个元素
     */
    boolean contains(E e);

    /**
     * 获取大小
     */
    int getSize();

    /**
     * 判断集合是否为空
     */
    boolean isEmpty();
}
