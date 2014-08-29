package com.leetcode.tree;

import com.leetcode.core.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 *
 * You may only use constant extra space.
 *
 * For example,
 * Given the following binary tree,
 *
 *        1
 *       /  \
 *      2    3
 *     / \    \
 *    4   5    7
 *
 * After calling your function, the tree should look like:
 *
 *        1 -> NULL
 *       /  \
 *      2 -> 3 -> NULL
 *     / \    \
 *    4-> 5 -> 7 -> NULL
 *
 * Created by Xiaomeng on 8/11/2014.
 */
public class PopulatingNextRightPointers2 {
    public void connect(TreeLinkNode root) {
        if(root == null) return;

        TreeLinkNode node = root.next;
        while(node != null){
            if(node.left == null && node.right == null)
                node = node.next;
            else
                break;
        }

        TreeLinkNode next = node == null ? null :
                            node.left != null ? node.left : node.right;

        if(root.left != null){
            root.left.next = root.right != null ? root.right : next;
        }

        if(root.right != null){
            root.right.next = next;
        }

        connect(root.right);
        connect(root.left);
    }
}
