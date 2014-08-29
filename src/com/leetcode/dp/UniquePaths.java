package com.leetcode.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Created by Xiaomeng on 8/18/2014.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                memo[i][j] = -1;
            }
        }
        memo[1][1] = 1;
        return uniquePaths(m, n, memo);
    }

    public int uniquePaths(int m, int n, int[][] memo){
        if(m < 1 || n < 1 || m >= memo.length || n >= memo[0].length) return 0;

        if(memo[m][n] == -1){
            memo[m][n] = uniquePaths(m - 1 , n, memo) + uniquePaths(m, n - 1, memo);
        }
        return memo[m][n];
    }

    public static void main(String[] args){
        UniquePaths test = new UniquePaths();
        System.out.println(test.uniquePaths(2, 3));
    }
}
