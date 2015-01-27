package com.google;

import com.leetcode.core.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Search Tree implementation in Java
 *
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(){
    }

    /**
     * Average time: O(logN)
     * Worst case: O(n)
     *
     */
    public void add(int val){
        root = add(root, val);
    }

    private TreeNode add(TreeNode node, int val){
        if(node == null){
            node = new TreeNode(val);
        }else{
            if(node.val > val){
                node.left = add(node.left, val);
            }else{
                node.right = add(node.right, val);
            }
        }
        return node;
    }

    /**
     * Average time: O(logN)
     * Worst case: O(n)
     *
     */
    public void delete(int val){
        root = delete(root, val);
    }

    private TreeNode delete(TreeNode node, int val){
        if(node == null) return null;
        if(node.val > val){
            node.left = delete(node.left, val);
        }else if(node.val < val){
            node.right = delete(node.right, val);
        }else{
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;
            TreeNode p = node.right;
            TreeNode prev = null;
            while(p.left != null){
                prev = p;
                p = p.left;
            }
            node.val = p.val;
            prev.left = null;
        }
        return node;
    }

    /**
     * Average time: O(logN)
     * Worst case: O(n)
     *
     */
    public boolean find(int val){
        return find(root, val);
    }

    private boolean find(TreeNode node, int val){
        if(node == null){
            return false;
        }else{
            if(node.val > val){
                return find(node.left, val);
            }else if(node.val < val){
                return find(node.right, val);
            }else{
                return true;
            }
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void levelorder(){
        levelorder(root);
    }

    public void levelorder(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(5);
        tree.add(1);
        tree.add(3);
        tree.add(8);
        tree.add(6);
        tree.add(2);
        tree.add(4);
        tree.add(0);
        tree.delete(1);
        tree.levelorder();
    }
}
