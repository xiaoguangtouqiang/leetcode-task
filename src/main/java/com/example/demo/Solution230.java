package com.example.demo;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
public class Solution230 {
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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        scan(root, list);
        return list.get(k-1);
    }

    //递归获取节点当前节点的个数
    private void scan(TreeNode root, List<Integer> list) {
        if (root == null) return;
        scan(root.left, list);
        list.add(root.val);
        scan(root.right, list);
    }
}
