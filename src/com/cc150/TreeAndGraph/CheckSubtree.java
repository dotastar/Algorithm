package com.cc150.TreeAndGraph;

import com.leetcode.core.TreeNode;

/**
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 *
 */
public class CheckSubtree {
    /**
     * The treeMatch procedure visits each node in the small tree at most once and is called no more than once per node of the large tree.
     * Worst case runtime is at most O(n * m), where n and m are the sizes of trees T1 and T2, respectively.
     * If k is the number of occurrences of T2’s root in T1, the worst case runtime can be characterized as O(n + k * m).
     *
     * Better solution? : http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
     */
    public static boolean containsTree(TreeNode T1, TreeNode T2){
        if(T2 == null) return true;
        return subTree(T1, T2);
    }

    public static boolean subTree(TreeNode p, TreeNode q){
        if(p == null) return false;
        if(p.val == q.val){
            if(sameTree(p, q)) return true;
        }
        return subTree(p.left, q) || subTree(p.right, q);
    }

    public static boolean sameTree(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}
