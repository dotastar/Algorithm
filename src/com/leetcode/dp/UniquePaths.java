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
    /**
     * Recursive: 2^n
     *
     */
    public int uniquePaths1(int m, int n) {
        if(m == 1 || n == 1) return 1;
        return uniquePaths1(m - 1, n) + uniquePaths1(m, n - 1);
    }


    /**
     * Bottom-up DP
     * Time: O(mn)
     * Space: O(mn)
     *
     */
    public int uniquePaths2(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(i == 1)
                    memo[i][j] = 1;
                else if(j == 1)
                    memo[i][j] = 1;
                else{
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }
        return memo[m][n];
    }

    /**
     * Bottom-up DP
     * Time: O(mn)
     * Space: O(n)
     *
     */
    public int uniquePaths3(int m, int n) {
        int[] curr = new int[n + 1];
        int[] next = new int[n + 1];
        for(int i = 1; i < n + 1; i++) curr[i] = 1;

        for(int i = 2; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(j == 1){
                    next[j] = 1;
                }else{
                    next[j] = next[j - 1] + curr[j];
                }
            }
            curr = next;
        }
        return curr[n];
    }

    /**
     * Top-down DP
     * Time: O(mn)
     * Space: O(mn)
     */
    public int uniquePaths4(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++) memo[i][1] = 1;
        for(int i = 1; i < n + 1; i++) memo[1][i] = 1;
        return uniquePaths4(m, n, memo);
    }

    public int uniquePaths4(int m, int n, int[][] memo){
        if(memo[m][n] == 0){
            memo[m][n] = uniquePaths4(m - 1, n, memo) + uniquePaths4(m, n - 1, memo);
        }
        return memo[m][n];
    }

    public static void main(String[] args){

    }
}
