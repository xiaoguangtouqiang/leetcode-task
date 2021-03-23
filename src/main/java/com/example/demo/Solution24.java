package com.example.demo;

import java.util.Stack;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class Solution24 {

    public class ListNode {
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

    public ListNode swapPairs(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode listNode = head;
        ListNode dumpNode = new ListNode(0);
        ListNode resultNode = dumpNode;
        while (listNode != null) {
            if (stack.size() < 2) {
                stack.push(listNode);
                listNode = listNode.next;
            } else {
                resultNode.next = stack.pop();
                resultNode = resultNode.next;
                resultNode.next = stack.pop();
                resultNode = resultNode.next;
            }
        }
        while (!stack.isEmpty()) {
            resultNode.next = stack.pop();
            resultNode = resultNode.next;
        }
        resultNode.next = null;

        return dumpNode.next;
    }

    public static void main(String[] args) {

        Solution24 solution24 = new Solution24();
        ListNode header1 = solution24.new ListNode(1);
        ListNode header2 = solution24.new ListNode(2);
        ListNode header3 = solution24.new ListNode(3);
        ListNode header4 = solution24.new ListNode(4);
        header1.next = header2;
        header2.next = header3;
        header3.next = header4;
        System.out.println(solution24.swapPairs(header1));
    }
}
