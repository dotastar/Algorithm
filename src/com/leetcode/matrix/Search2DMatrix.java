package com.leetcode.matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 *
 * Given target = 3, return true.
 *
 * Created by Xiaomeng on 9/3/2014.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        return searchMatrix(matrix, target, 0, rows * cols - 1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int start, int end){
        if(start > end) return false;

        int mid = start + (end - start)/2;
        int row = mid / matrix[0].length;
        int col = mid % matrix[0].length;

        if(matrix[row][col] == target){
            return true;
        }else if (matrix[row][col] < target){
            return searchMatrix(matrix, target, mid + 1, end);
        }else{
            return searchMatrix(matrix, target, start, mid - 1);
        }
    }

    public static void main(String[] args){
        Search2DMatrix test = new Search2DMatrix();
        int[][] matrix = {
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(test.searchMatrix(matrix, 3));
    }
}
