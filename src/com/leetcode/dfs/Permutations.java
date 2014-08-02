package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a collection of numbers, return all possible permutations.
 *
 *  For example,
 *  [1,2,3] have the following permutations:
 *  [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 *  Created by Xiaomeng on 7/31/2014.
 */
public class Permutations {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> single = new ArrayList<Integer>();

    public List<List<Integer>> permute(int[] num) {
        boolean[] visited = new boolean[num.length];
        permute(num, visited);
        return result;
    }

    public void permute(int[] num, boolean[] visited) {
        if(single.size() == num.length){
            result.add(new ArrayList<Integer>(single));
            return;
        }

        for(int i = 0; i < num.length; i++){
            if(!visited[i]){
                single.add(num[i]);
                visited[i] = true;
                permute(num, visited);
                single.remove(single.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] num = {1,2,3};
        Permutations test = new Permutations();
        for(List<Integer> single : test.permute(num)){
            System.out.println(single);
        }
    }
}
