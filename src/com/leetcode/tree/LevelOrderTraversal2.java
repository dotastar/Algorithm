package com.leetcode.tree;

import com.leetcode.core.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 *
 * return its bottom-up level order traversal as:
 *
 * [
 *  [15,7],
 *  [9,20],
 *  [3]
 * ]
 *
 * Created by Xiaomeng on 8/7/2014.
 */
public class LevelOrderTraversal2 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return result;

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        List<Integer> level = new ArrayList<Integer>();
        queue1.add(root);

        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            level.add(node.val);

            if(node.left != null) queue2.add(node.left);
            if(node.right != null) queue2.add(node.right);

            if(queue1.isEmpty()){
                result.add(level);
                level = new ArrayList<Integer>();
                queue1.addAll(queue2);
                queue2.clear();
            }
        }
        Collections.reverse(result);
        return result;
    }
}
