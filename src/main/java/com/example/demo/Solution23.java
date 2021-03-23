package com.example.demo;

/**
 *
 */
public class Solution23 {

    public static class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dumpNode = new ListNode(0);
        ListNode listNode = dumpNode;
        while (true) {
            ListNode min = getMin(lists);
            if (min != null) {
                listNode.next = min;
                listNode = listNode.next;
            } else {
                break;
            }
        }
        return dumpNode.next;
    }

    public ListNode getMin(ListNode[] lists) {
        ListNode tempNode = new ListNode(Integer.MAX_VALUE);
        int k = 0;
        int z = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                z++;
                continue;
            }
            if (lists[i].val < tempNode.val) {
                tempNode = lists[i];
                k = i;
            }
        }
        if (z == lists.length ) {
            return null;
        }
        if (lists[k].next != null) {
            lists[k] = lists[k].next;
        } else {
            lists[k] = null;
        }
        if (tempNode.val == Integer.MAX_VALUE) {
            return null;
        }
        return tempNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(4);
        node1.next = node11;
        ListNode node12 = new ListNode(5);
        node11.next = node12;

        ListNode node2 = new ListNode(4);
        ListNode node22 = new ListNode(6);
        node2.next = node22;

        ListNode[] lists = {node1, node2};

        ListNode listNode = new Solution23().mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("aaad");
    }
}
