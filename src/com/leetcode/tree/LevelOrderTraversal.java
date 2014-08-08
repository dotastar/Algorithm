package com.leetcode.tree;

import com.leetcode.core.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 *
 * return its level order traversal as:
 *
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 *
 * Created by Xiaomeng on 8/6/2014.
 */
public class LevelOrderTraversal {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return result;

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.add(root);
        List<Integer> level = new ArrayList<Integer>();

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
        return result;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal test = new LevelOrderTraversal();
        for(List<Integer> level : test.levelOrder(root)){
            System.out.println(level);
        }
    }

}
