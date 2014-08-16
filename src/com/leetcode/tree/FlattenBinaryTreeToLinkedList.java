package com.leetcode.tree;

import com.leetcode.core.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 *
 * The flattened tree should look like:
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *
 * Created by Xiaomeng on 8/16/2014.
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        TreeNode left = flattenTree(root.left);
        TreeNode right = flattenTree(root.right);
        root.left = null;
        if(left == null){
            root.right = right;
        }else{
            root.right = left;
            if(right != null){
                while(left.right != null) left = left.right;
                left.right = right;
            }
        }
        return root;
    }
}
