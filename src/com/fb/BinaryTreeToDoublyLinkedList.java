package com.fb;

import com.leetcode.core.TreeNode;

/**
 * Given a Binary Tree (Bt), convert it to a Doubly Linked List(DLL).
 * The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL.
 * The order of nodes in DLL must be same as Inorder of the given Binary Tree.
 * The first node of Inorder traversal (left most node in BT) must be head node of the DLL.
 *
 */
public class BinaryTreeToDoublyLinkedList {
    private static TreeNode prev;
    private static TreeNode head;

    /**
     * Better solution: Bottom-up O(n)
     * http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
     *
     * Not tested yet!
     *
     */
    public static TreeNode BTToDLL1(TreeNode root){
        if(root == null) return null;
        BTToDLL1(root.left);
        if(prev == null){
            head = root;
        }else{
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        BTToDLL1(root.right);
        return head;
    }

    /**
     * Easy solution
     *
     */
    public static TreeNode BTToDLL(TreeNode root){
        if(root == null) return null;

        TreeNode head = root;
        if(root.left != null){
            TreeNode node = BTToDLL(root.left);
            head = node;
            while(node.right != null){
                node = node.right;
            }
            node.right = root;
            root.left = node;

        }

        if(root.right != null){
            TreeNode node = BTToDLL(root.right);
            root.right = node;
            node.left = root;
        }
        return head;
    }
}
