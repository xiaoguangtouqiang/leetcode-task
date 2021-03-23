package com.example.demo;

public class Solution110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if (Math.abs(getNodeDeep(root.left) - getNodeDeep(root.right)) < 2) {
                return isBalanced(root.left) && isBalanced(root.right);
            } else {
                return false;
            }
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right == null) {
            return getNodeDeep(root.left) < 2;
        }
        if (root.right != null && root.left == null) {
            return getNodeDeep(root.right) < 2;
        }
        return false;
    }

    private int getNodeDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null && node.right != null) {
            return Math.max(getNodeDeep(node.left), getNodeDeep(node.right)) + 1;
        }
        if (node.left == null) {
            return getNodeDeep(node.right) + 1;
        }
        if (node.right == null) {
            return getNodeDeep(node.left) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode node1 = new Solution110().new TreeNode(3);
        TreeNode node2 = new Solution110().new TreeNode(9);

    }
}
