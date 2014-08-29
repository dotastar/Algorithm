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
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < memo.length; i++){
            for(int j = 0; j < memo[0].length; j++){
                memo[i][j] = -1;
            }
        }
        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;
        memo[0][0] = 1;
        return uniquePathsWithObstacles(obstacleGrid, memo, m, n);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int[][] memo, int m, int n){
        if(m < 0 || n < 0 || m >= obstacleGrid.length || n >= obstacleGrid[0].length) return 0;
        if(obstacleGrid[m][n] == 1) memo[m][n] = 0;
        if(memo[m][n] == -1){
            memo[m][n] = uniquePathsWithObstacles(obstacleGrid, memo, m - 1, n) + uniquePathsWithObstacles(obstacleGrid, memo, m, n - 1);
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
