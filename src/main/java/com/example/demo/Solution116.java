package com.example.demo;

import java.util.LinkedList;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution116 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        return root;
    }


    private Node midScan(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return root;
        }
        queue.push(root);
        while (!queue.isEmpty()) {
            Node pop = queue.getLast();
            queue.removeLast();
            if(!queue.isEmpty()){
                pop.next = queue.getLast();
            }
            System.out.println(pop.val);
            if (pop.left != null) {
                queue.push(pop.left);
                queue.push(pop.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node node1 = new Solution116().new Node(1, null, null, null);
        Node node2 = new Solution116().new Node(2, null, null, null);
        Node node3 = new Solution116().new Node(3, null, null, null);
        Node node4 = new Solution116().new Node(4, null, null, null);
        Node node5 = new Solution116().new Node(5, null, null, null);
        Node node6 = new Solution116().new Node(6, null, null, null);
        Node node7 = new Solution116().new Node(7, null, null, null);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        Node node = new Solution116().midScan(node1);
    }
}
