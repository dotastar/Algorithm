package com.leetcode.matrix;

/**
 *  Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 *  click to show follow up.
 *  Follow up:
 *
 *  Did you use extra space?
 *  A straight forward solution using O(mn) space is probably a bad idea.
 *  A simple improvement uses O(m + n) space, but still not the best solution.
 *
 *  Could you devise a constant space solution?
 *
 *  Created by Xiaomeng on 9/1/2014.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean top = false;
        boolean left = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0) left = true;
        }

        for(int j = 0; j < cols; j++){
            if(matrix[0][j] == 0) top = true;
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < rows; i++){
            if(matrix[i][0] == 0){
                for(int j = 0; j < cols; j++) matrix[i][j] = 0;
            }
        }

        for(int i = 1; i < cols; i++){
            if(matrix[0][i] == 0){
                for(int j = 0; j < rows; j++) matrix[j][i] = 0;
            }
        }

        if(top){
            for(int i = 0; i < cols; i++) matrix[0][i] = 0;
        }

        if(left){
            for(int i = 0; i < rows; i++) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {2,0,0},
                {5,3,7},
                {6,4,8},
        };
        SetMatrixZeroes test = new SetMatrixZeroes();
        test.setZeroes(matrix);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
