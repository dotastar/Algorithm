package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 *  Each number in C may only be used once in the combination.
 *
 *  Note:
 *
 *  All numbers (including target) will be positive integers.
 *
 *  Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *  The solution set must not contain duplicate combinations.
 *
 *  For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 *  A solution set is:
 *  [1, 7]
 *  [1, 2, 5]
 *  [2, 6]
 *  [1, 1, 6]
 *
 *  Created by Xiaomeng on 8/21/2014.
 *
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> single = new ArrayList<Integer>();
        Arrays.sort(num);
        combinationSum2(num, target, 0, 0, single, result);
        return result;
    }

    public void combinationSum2(int[] num, int target, int count, int index, List<Integer> single, List<List<Integer>> result){
        if(count > target) return;
        if(count == target){
            result.add(new ArrayList<Integer>(single));
            return;
        }

        for(int i = index; i < num.length; i++){
            if(i > index && num[i] == num[i - 1]) continue;
            single.add(num[i]);
            combinationSum2(num, target, count + num[i], i + 1, single, result);
            single.remove(single.size() -1);
        }
    }

    public static void main(String[] args){
        CombinationSum2 test = new CombinationSum2();
        int[] num = {10,1,2,7,6,1,5};
        for(List<Integer> single : test.combinationSum2(num, 8)){
            System.out.println(single);
        }
    }
}
