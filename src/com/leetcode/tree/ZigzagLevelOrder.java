package com.leetcode.tree;

import com.leetcode.core.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 * Created by Xiaomeng on 8/7/2014.
 */
public class ZigzagLevelOrder {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        for(int i = 1; i < result.size(); i += 2){
            Collections.reverse(result.get(i));
        }
        return result;
    }
}
