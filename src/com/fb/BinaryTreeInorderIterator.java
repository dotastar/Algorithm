package com.fb;

import com.leetcode.core.TreeNodeWithParent;

import java.util.NoSuchElementException;

/**
 * How can I write a Java iterator (i.e. needs the next and hasNext methods) that takes the root of a binary tree and iterates through the nodes of the binary tree in in-order fashion
 */
public class BinaryTreeInorderIterator {
    private TreeNodeWithParent next;

    /**
     * Reference: http://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree
     * maybe wrong
     */
    public BinaryTreeInorderIterator(TreeNodeWithParent root){
        next = root;
        if(next == null)
            return;
        while (next.left != null)
            next = next.left;
    }

    public boolean hasNext(){
        return next != null;
    }

    public TreeNodeWithParent next(){
        if(!hasNext()) throw new NoSuchElementException();
        TreeNodeWithParent r = next;
        // if you can walk right, walk right, then fully left.
        // otherwise, walk up until you come from left.
        if(next.right != null){
            next = next.right;
            while (next.left != null)
                next = next.left;
        }else {
            while(true) {
                if (next.parent == null) {
                    next = null;
                    return r;
                }
                if (next.parent.left == next) {
                    next = next.parent;
                    return r;
                }
                next = next.parent;
            }
        }
        return null;
    }
}
