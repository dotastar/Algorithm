package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 *  Note:
 *
 *  Elements in a subset must be in non-descending order.
 *  The solution set must not contain duplicate subsets.
 *
 *  For example,
 *  If S = [1,2,2], a solution is:
 *
 *  [
 *    [2],
 *    [1],
 *    [1,2,2],
 *    [2,2],
 *    [1,2],
 *    []
 *  ]
 *
 *  Created by Xiaomeng on 8/1/2014.
 */
public class Subsets2 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] num) {
        result.add(new ArrayList<Integer>());
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            dfs(num, i);
        }
        return result;
    }

    public void dfs(int[] num, int index){
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        for(List<Integer> single : result){
            List<Integer> set = new ArrayList<Integer>(single);
            set.add(num[index]);
            if(!result.contains(set)) tmp.add(set);
        }
        result.addAll(tmp);
    }

    public static void main(String[] args){
        int[] S = {1, 2, 2};
        Subsets2 test = new Subsets2();
        List<List<Integer>> result = test.subsetsWithDup(S);
        for(List<Integer> single : result){
            System.out.println(single);
        }
    }
}

