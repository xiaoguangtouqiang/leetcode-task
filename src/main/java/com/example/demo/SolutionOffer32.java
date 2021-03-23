package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

public class SolutionOffer32 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        scanNode(root, 1, list);
        System.out.println(list.toString());
        return list;
    }

    private void scanNode(TreeNode node, int height, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        List<Integer> integers = null;
        if (list.size() < height) {
            integers = new ArrayList<>();
            list.add(integers);
        } else {
            integers = list.get(height - 1);
        }

        integers.add(node.val);

        if (node.left != null) {
            scanNode(node.left, height + 1, list);
        }
        if (node.right != null) {
            scanNode(node.right, height + 1, list);
        }
    }

    public static void main(String[] args) {

    }
}












