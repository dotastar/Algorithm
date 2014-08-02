package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a set of distinct integers, S, return all possible subsets.
 *  Note:
 *  Elements in a subset must be in non-descending order.
 *  The solution set must not contain duplicate subsets.
 *
 *  For example,
 *  If S = [1,2,3], a solution is:
 *  [
 *    [3],
 *    [1],
 *    [2],
 *    [1,2,3],
 *    [1,3],
 *    [2,3],
 *    [1,2],
 *    []
 *  ]
 *
 *  Reference: http://rleetcode.blogspot.com/2014/02/leetcode-given-set-of-distinct-integers.html
 *
 * Created by Xiaomeng on 8/1/2014.
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] S) {
        result.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++){
            dfs(S, i);
        }
        return result;
    }

    public void dfs(int[] S, int index){
        List<List<Integer>> tmp = new ArrayList<List<Integer>>();
        for(List<Integer> single : result){
            List<Integer> newSet = new ArrayList<Integer>(single);
            newSet.add(S[index]);
            tmp.add(newSet);
        }
        result.addAll(tmp);
    }

    public static void main(String[] args){
        int[] S = {1, 2, 3};
        Subsets test = new Subsets();
        List<List<Integer>> result = test.subsets(S);
        for(List<Integer> single : result){
            System.out.println(single);
        }
    }
}
