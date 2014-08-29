package com.leetcode.tree;

import com.leetcode.core.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Created by Xiaomeng on 8/11/2014.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(getBalanced(root) == -1) return false;
        return true;
    }

    public int getBalanced(TreeNode root){
        if(root == null) return 0;

        int left = getBalanced(root.left);
        if(left == -1) return -1;

        int right = getBalanced(root.right);
        if(right == -1) return -1;

        if(Math.abs(left - right) > 1) return -1;
        return left > right ? left + 1 : right + 1;
    }
}
