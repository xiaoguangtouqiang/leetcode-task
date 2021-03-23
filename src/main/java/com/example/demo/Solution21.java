package com.example.demo;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution21 {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dumpNode = new ListNode(0);
        ListNode listNode = dumpNode;
        ListNode first = l1;
        ListNode second = l2;
        while (first != null & second != null) {
            if (first.val < second.val) {
                listNode.next = first;
                first = first.next;
            } else {
                listNode.next = second;
                second = second.next;
            }
            listNode = listNode.next;

        }
        if (first == null && second != null) {
            listNode.next = second;
        } else if (second == null && first != null) {
            listNode.next = first;
        }
        return dumpNode.next;
    }
}
