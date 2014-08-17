package com.leetcode.tree;

import com.leetcode.core.TreeNode;

/**
 *  Two elements of a binary search tree (BST) are swapped by mistake.
 *
 *  Recover the tree without changing its structure.
 *  Note:
 *  A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 *
 *  Created by Xiaomeng on 8/16/2014.
 */
public class RecoverBinarySearchTree {
    TreeNode pre;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre == null){
            pre = root;
        }else{
            if(pre.val > root.val){
                if(first == null) first = pre;
                second = root;
            }
            pre = root;
        }
        inorder(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(10);
        //root.display();
        RecoverBinarySearchTree recover = new RecoverBinarySearchTree();
        recover.recoverTree(root);
        root.display();
    }
}
