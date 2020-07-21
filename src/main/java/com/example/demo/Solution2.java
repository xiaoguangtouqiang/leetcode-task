package com.example.demo;

/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

        示例：

        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/add-two-numbers
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class Solution2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int i = 0;
            ListNode listNode = new ListNode(0);
            ListNode prvNode = listNode;
            while (l1 != null || l2 != null) {
                int leftVal = l1 == null ? 0 : l1.val;
                int righttVal = l2 == null ? 0 : l2.val;
                int x = leftVal + righttVal + i;
                if (x >= 10) {
                    x = x - 10;
                    i = 1;
                } else {
                    i = 0;
                }
                ListNode tempNode = new ListNode(x);
                prvNode.next = tempNode;
                prvNode = tempNode;
                l1 = l1 == null || l1.next == null ? null : l1.next;
                l2 = l2 == null || l2.next == null ? null : l2.next;
            }
            if (i == 1) {
                ListNode lastNode = new ListNode(1);
                prvNode.next = lastNode;
            }
            return listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(8);
        ListNode listNode3 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(9);
//        ListNode listNode5 = new ListNode(9);
//        ListNode listNode6 = new ListNode(9);

//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
        System.out.println(Solution.addTwoNumbers(listNode1, listNode4));
    }
}
