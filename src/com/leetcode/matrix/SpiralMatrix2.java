package com.leetcode.matrix;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 *  ]
 *
 * Created by Xiaomeng on 9/1/2014.
 */
public class SpiralMatrix2 {
    /**
     * Recursive
     *
     */
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        generateMatrix(0, n, result, 0);
        return result;
    }

    public void generateMatrix(int start, int n, int[][] result, int count){
        if(start >= n) return;
        for(int i = start; i < n; i++){
            result[start][i] = ++count;
        }

        for(int i = start + 1; i < n; i++){
            result[i][n - 1] = ++count;
        }

        for(int i = n - 2; i >= start; i--){
            result[n - 1][i] = ++count;
        }

        for(int i = n - 2; i >= start + 1; i--){
            result[i][start] = ++count;
        }
        generateMatrix(start + 1, n - 1, result, count);
    }

    /**
     * Iterative
     *
     */
    public int[][] generateMatrix1(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - layer - 1;
            for(int i = first; i < last; i++){
                result[first][i] = count++;
            }
            for(int i = first; i < last; i++){
                result[i][last] = count++;
            }
            for(int i = last; i > first; i--){
                result[last][i] = count++;
            }
            for(int i = last; i > first; i--){
                result[i][first] = count++;
            }
        }
        if(n % 2 != 0) result[n/2][n/2] = count;
        return result;
    }

    public static void main(String[] args){
        SpiralMatrix2 test = new SpiralMatrix2();
        int[][] matrix = test.generateMatrix(3);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
