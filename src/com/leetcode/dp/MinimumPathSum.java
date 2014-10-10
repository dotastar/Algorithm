package com.leetcode.dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Created by Xiaomeng on 9/3/2014.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] memo = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                memo[i][j] = -1;
            }
        }
        return minPathSum(grid, 0, 0, rows - 1, cols - 1, memo);
    }

    public int minPathSum(int[][] grid, int m, int n, int rows, int cols, int[][] memo){
        if(rows == 0 && cols == 0) return grid[rows][cols];
        if(rows < 0 || cols < 0) return Integer.MAX_VALUE;

        if(memo[rows][cols] == -1){
            memo[rows][cols] = Math.min(minPathSum(grid, 0, 0, rows - 1, cols, memo), minPathSum(grid, 0, 0, rows, cols - 1, memo)) + grid[rows][cols];
        }
        return memo[rows][cols];
    }

    public static void main(String[] args){
        int[][] grid = {
                {2,3,8},
                {1,5,5},
                {3,6,1}
        };
        MinimumPathSum test = new MinimumPathSum();
        System.out.println(test.minPathSum(grid));
    }

}
