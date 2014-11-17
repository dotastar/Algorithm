package com.airbnb;

import com.leetcode.core.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a Binary Search Tree
 *
 * Reference: http://www.sanfoundry.com/java-program-implement-binary-search-tree/
 *
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(){
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Average time: O(logN)
     * Worst case: O(n)
     *
     */
    public void insert(int val){
        root = insert(root, val);
    }

    private TreeNode insert(TreeNode node, int val){
        if(node == null){
            node = new TreeNode(val);
        }else{
            if(val < node.val){
                node.left = insert(node.left, val);
            }else{
                node.right = insert(node.right, val);
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
        if(root == null){
            System.out.println("Nothing to be deleted, the tree is empty!");
        }else if(search(val) == false){
            System.out.println(val + "is not present in the tree");
        }else{
            root = delete(root, val);
        }
    }

    private TreeNode delete(TreeNode node, int val){
        if(val == node.val){
            if(node.left == null && node.right == null){
                return null;
            }else if(node.left == null){
                return node.right;
            }else if(node.right == null){
                return node.left;
            }else{
                TreeNode p = node.right;
                TreeNode prev = null;
                while(p.left != null){
                    prev = p;
                    p = p.left;
                }
                node.val = p.val;
                if(prev != null) prev.left = null;
            }
        }else if(val < node.val){
            node.left = delete(node.left, val);
        }else{
            node.right = delete(node.right, val);
        }
        return node;
    }

    /**
     * Average time: O(logN)
     * Worst case: O(n)
     *
     */
    public boolean search(int val){
        return search(root, val);
    }

    private boolean search(TreeNode node, int val){
        if(node == null){
            return false;
        }

        if(val < node.val){
            return search(node.left, val);
        }else if(val > node.val){
            return search(node.right, val);
        }else{
            return true;
        }
    }

    public void inorder(){
        inorder(root);
    }

    public void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
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
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(8);
        tree.insert(6);
        tree.insert(2);
        tree.insert(4);
        tree.insert(0);
        tree.delete(1);
        tree.levelorder();
    }
}
