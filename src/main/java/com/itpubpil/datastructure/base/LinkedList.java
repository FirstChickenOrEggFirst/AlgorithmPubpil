package com.itpubpil.datastructure.base;

/**
 * @author wangjingbiao
 * createTime: 2019/7/15 22:15
 * desc:
 * 链表
 */
public class LinkedList<E> {
    /**
     * 定义链表中的节点信息
     */
    private class Node {
        /**
         * 元素
         */
        public E e;
        /**
         * 下一个节点的引用
         */
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 当前元素数量
     */
    private int size;
    /**
     * 虚拟头节点，用于避开头节点的特殊处理
     */
    private Node dummyHead;

    public LinkedList() {
        //创建全空的一个虚拟头节点
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 指定位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed,Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        // 等价于 prev.next = new Node(e,prev.next)
        size++;
    }

    /**
     * 尾部添加节点
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 头部添加节点
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 查询指定位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取头部元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取尾部元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 设置指定位置元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 判断是否包含元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除指定位置元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. Illegal index");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 删除头部元素
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除尾部元素
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }

        /* for循环遍历链表的方式
         * for (Node cur2 = dummyHead.next;cur2 !=null;cur2 = cur2.next){
         *             res.append(cur2).append("->");
         * }
         */

        res.append("NULL");
        return res.toString();
    }
}
