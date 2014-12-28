package com.leetcode.dp;

/**
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 *
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 *
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 *
 * Created by Xiaomeng on 8/18/2014.
 */
public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) return 0;
        int n = obstacleGrid[0].length;

        int[][] memo = new int [m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = -1;
            }
        }
        memo[0][0] = 1;
        return uniquePaths(obstacleGrid, m - 1, n - 1, memo);
    }

    public int uniquePaths(int[][] obstacleGrid, int m, int n, int[][] memo){
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1) return 0;

        if(memo[m][n] == -1){
            memo[m][n] = uniquePaths(obstacleGrid, m - 1, n, memo) + uniquePaths(obstacleGrid, m, n - 1, memo);
        }
        return memo[m][n];
    }

    public static void main(String[] args){
        UniquePaths2 test = new UniquePaths2();
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
    }
}
