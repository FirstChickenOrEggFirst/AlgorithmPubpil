package com.itpubpil.datastructure.linkedlist;

/**
 * @author wangjingbiao
 * createTime: 2019/7/18 22:34
 * desc:
 * 从链表中删除某个元素
 */
public class RemoveElementTest {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    /**
     * 删除链表中的元素,不使用虚拟头节点
     *
     * @param head 链表头
     * @param val  要删除的值
     */
    public ListNode soulutionWithOutdummyHead(ListNode head, int val) {
        // 删除链表头结点中该删除的元素
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 此时如果head == null,说明链表中的元素已经全部删除了
        if (head == null) {
            return null;
        }
        // 执行循环一直到最后一个元素
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 删除链表中的元素,使用虚拟头节点
     *
     * @param head 链表头
     * @param val  要删除的值
     */
    public ListNode soulutionWithDummyHead(ListNode head, int val) {
        // 在头结点前面增加上一个虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 执行循环一直到最后一个元素
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    // 使用递归来进行解决
    public ListNode soulutionUserecursive(ListNode head, int val) {
        if (head == null) {
            return head;
        }
//        ListNode res = soulutionUserecursive(head.next, val);
//        if (head.val == val) {
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }
        head.next = soulutionUserecursive(head.next, val);
        return head.val == val ? head.next : head;
    }
}
