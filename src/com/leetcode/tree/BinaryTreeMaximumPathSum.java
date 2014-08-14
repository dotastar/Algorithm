package com.leetcode.tree;

import com.leetcode.core.TreeNode;

/**
 *  Given a binary tree, find the maximum path sum.
 *
 *  The path may start and end at any node in the tree.
 *
 *  For example:
 *  Given the below binary tree,
 *
 *      1
 *     / \
 *    2   3
 *
 *  Return 6.
 *
 *  Created by Xiaomeng on 8/13/2014.
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;
        int m = root.val;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left > 0) m += left;
        if(right > 0) m += right;
        max = m > max ? m : max;

        return Math.max(left, right) > 0 ? root.val + Math.max(left, right) : root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(20);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        BinaryTreeMaximumPathSum pathSum = new BinaryTreeMaximumPathSum();
        System.out.println(pathSum.maxPathSum(root));
    }
}
