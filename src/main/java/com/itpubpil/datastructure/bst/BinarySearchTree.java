package com.itpubpil.datastructure.bst;

import org.w3c.dom.Node;

/**
 * @author wangjingbiao
 * createTime: 2021/6/21 22:05
 * desc:
 * 二分搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {
    /**
     * 节点内部类
     */
    private class Node {
        public E e;
        // 左节点、右节点
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo((node.e)) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

}
