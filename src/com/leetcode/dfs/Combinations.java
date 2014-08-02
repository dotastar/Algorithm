package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 *  For example,
 *  If n = 4 and k = 2, a solution is:
 *
 *  [
 *      [2,4],
 *      [3,4],
 *      [2,3],
 *      [1,2],
 *      [1,3],
 *      [1,4],
 *  ]
 *
 * Created by Xiaomeng on 8/1/2014.
 */
public class Combinations {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> single = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return result;
    }

    public void dfs(int n, int k, int start){
        if(single.size() == k){
            result.add(new ArrayList<Integer>(single));
            return;
        }

        for(int i = start; i <= n; i++){
            single.add(i);
            dfs(n, k, i + 1);
            single.remove(single.size() - 1);
        }
    }

    public static void main(String[] args){
        Combinations test = new Combinations();
        for(List<Integer> single : test.combine(4, 2)){
            System.out.println(single);
        }
    }
}
