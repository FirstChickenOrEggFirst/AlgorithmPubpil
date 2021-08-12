package com.itpubpil.solution;

import java.util.List;

/**
 * @author wangjingbiao
 * @date 2021/8/12 周四 2:01 下午
 * desc:
 */
public class Solution19 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (n <= 0) {
            return head;
        }
        // 前后指针，前指针走n+1步后，后指针开始走，前指针走到尾巴，后指针刚好到待删除节点的前一个节点
        ListNode frontNode = head;
        ListNode backNode = head;
        int size = 0;
        while (frontNode != null) {
            frontNode = frontNode.next;
            if (n < 0) {
                // 前置指针走n步后，后置指针开始走
                backNode = backNode.next;
            }
            n--;
            size++;
        }

        if (n < 0) {
            ListNode delNode = backNode.next;
            backNode.next = delNode.next;
            delNode.next = null;
            return head;
        } else if (n == 0) {
            head = head.next;
            return head;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution19 s = new Solution19();
        ListNode node = s.removeNthFromEnd(node1, 3);
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
