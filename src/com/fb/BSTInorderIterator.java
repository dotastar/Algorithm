package com.fb;

import com.leetcode.core.TreeNode;

import java.util.*;

/**
 * Created by Xiaomeng on 12/7/2014.
 */
public class BSTInorderIterator implements Iterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTInorderIterator(TreeNode head){
        pushLeftChild(head);
    }

    private void pushLeftChild(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Object next() {
        if(hasNext()){
            TreeNode node = stack.pop();
            pushLeftChild(node.right);
            return node.val;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(3);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);

        BSTInorderIterator iterator = new BSTInorderIterator(root);
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
