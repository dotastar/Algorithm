package com.leetcode.tree;

import com.leetcode.core.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Created by Xiaomeng on 8/11/2014.
 */
public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);

        MinimumDepthBinaryTree test = new MinimumDepthBinaryTree();
        System.out.println(test.minDepth(root));
    }
}
