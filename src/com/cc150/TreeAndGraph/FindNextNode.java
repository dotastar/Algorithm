package com.cc150.TreeAndGraph;


import com.leetcode.core.TreeNodeWithParent;

/**
 * Write an algorithm to find the 'next' node(i.e. in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent
 *
 * Created by Xiaomeng on 11/2/2014.
 */
public class FindNextNode {
    /**
     * On an in-order traversal, we visit X.left, then X, then X.right.
     * So, if we want to find X.successor(), we do the following:
     * 1.   If X has a right child, then the successor must be on the right side of X (because of the order in which we visit nodes).
     *      Specifically, the left-most child must be the first node visited in that subtree.
     * 2.   Else, we go to X’s parent (call it P).
     * 2.a. If X was a left child (P.left = X), then P is the successor of X
     * 2.b. If X was a right child (P.right = X), then we have fully visited P, so we call successor(P).
     */
    public static TreeNodeWithParent findNext(TreeNodeWithParent node){
        if(node == null) return null;

        if(node.parent == null || node.right != null){
            return leftMostChild(node.right);
        }else{
            TreeNodeWithParent currParent = node.parent;
            while(currParent != null && currParent.left != node){
                node = currParent;
                currParent = currParent.parent;
            }
            return currParent;
        }
    }

    public static TreeNodeWithParent leftMostChild(TreeNodeWithParent node){
        if(node == null) return null;
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    /**
     *          10
     *         /
     *        9
     *       /
     *      2
     *       \
     *        7
     *       / \
     *      5   8
     *     / \
     *    4   6
     *
     * @param args
     */
    public static void main(String[] args){
        TreeNodeWithParent root = new TreeNodeWithParent(10);
        root.left = new TreeNodeWithParent(9);
        root.left.parent = root;
        root.left.left = new TreeNodeWithParent(2);
        root.left.left.parent = root.left;
        root.left.left.right = new TreeNodeWithParent(7);
        root.left.left.right.parent = root.left.left;
        root.left.left.right.right = new TreeNodeWithParent(8);
        root.left.left.right.right.parent = root.left.left.right;
        root.left.left.right.left = new TreeNodeWithParent(5);
        root.left.left.right.left.parent = root.left.left.right;
        root.left.left.right.left.left = new TreeNodeWithParent(4);
        root.left.left.right.left.left.parent = root.left.left.right.left;
        root.left.left.right.left.right = new TreeNodeWithParent(6);
        root.left.left.right.left.right.parent = root.left.left.right.left;

        System.out.println(findNext(root.left.left.right.right).val); // 8 -> 9
        System.out.println(findNext(root.left.left.right.left).val); //5 -> 6
        System.out.println(findNext(root.left.left).val); //2 -> 4
    }
}
