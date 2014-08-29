package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 *  The same repeated number may be chosen from C unlimited number of times.
 *
 *  Note:
 *
 *  All numbers (including target) will be positive integers.
 *  Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *  The solution set must not contain duplicate combinations.
 *
 *  For example, given candidate set 2,3,6,7 and target 7,
 *  A solution set is:
 *  [7]
 *  [2, 2, 3]
 *
 *  Created by Xiaomeng on 8/21/2014.
 */
public class CombinationSum {
    List<List<Integer>> result;
    List<Integer> single;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        single = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return result;
    }

    public void dfs(int[] candidates, int target, int sum, int index){
        if(sum > target) return;
        if(sum == target){
            result.add(new ArrayList<Integer>(single));
            return;
        }

        while(index < candidates.length){
            single.add(candidates[index]);
            dfs(candidates, target, sum + candidates[index], index);
            single.remove(single.size() - 1);
            index++;
        }
    }

    public static void main(String[] args){
        int[] candidates = {2, 3, 6, 7};
        CombinationSum test = new CombinationSum();
        for(List<Integer> single : test.combinationSum(candidates, 7)){
            System.out.println(single);
        }
    }
}
