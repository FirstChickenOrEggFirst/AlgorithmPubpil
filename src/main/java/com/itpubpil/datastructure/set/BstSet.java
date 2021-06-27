package com.itpubpil.datastructure.set;

import com.itpubpil.datastructure.bst.BinarySearchTree;

/**
 * @author wangjingbiao
 * createTime: 2021/6/27 18:45
 * desc:
 * 二分搜索树实现集合
 */
public class BstSet<E extends Comparable<E>> implements Set<E> {

    private final BinarySearchTree<E> bst;

    public BstSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
