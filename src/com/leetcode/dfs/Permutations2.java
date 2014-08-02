package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 *  For example,
 *  [1,1,2] have the following unique permutations:
 *  [1,1,2], [1,2,1], and [2,1,1].
 *
 *  Created by Xiaomeng on 7/31/2014.
 */
public class Permutations2 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> single = new ArrayList<Integer>();

    public List<List<Integer>> permuteUnique(int[] num) {
        boolean[] visited = new boolean[num.length];
        Arrays.sort(num);
        permuteUnique(num, visited);
        return result;
    }

    public void permuteUnique(int[] num, boolean[] visited){
        if(single.size() == num.length){
            result.add(new ArrayList<Integer>(single));
            return;
        }

        for(int i = 0; i < num.length; i++){
            if(!visited[i]){
                if(i > 0 && num[i] == num[i - 1] && visited[i - 1]) continue;
                single.add(num[i]);
                visited[i] = true;
                permuteUnique(num, visited);
                single.remove(single.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] num = {1,1,3};
        Permutations2 test = new Permutations2();
        for(List<Integer> single : test.permuteUnique(num)){
            System.out.println(single);
        }
    }
}
