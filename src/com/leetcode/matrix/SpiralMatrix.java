package com.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * You should return [1,2,3,6,9,8,7,4,5].
 *
 * Created by Xiaomeng on 9/1/2014.
 */
public class SpiralMatrix {
    List<Integer> result;
    public List<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        int rows = matrix.length;
        int cols = matrix[0].length;
        spiralOrder(matrix, 0, 0, rows, cols);
        return result;
    }

    public void spiralOrder(int[][] matrix, int row, int col, int rows, int cols){
        if(row < 0 || col < 0 || row >= rows || col >= cols) return;

        for(int i = col; i < cols; i++){
            result.add(matrix[row][i]);
        }

        for(int i = row + 1; i < rows; i++){
            result.add(matrix[i][cols - 1]);
        }

        if(rows - 1 > row){
            for(int i = cols - 2; i >= col; i--){
                result.add(matrix[rows - 1][i]);
            }
        }

        if(cols - 1 > col){
            for(int i = rows - 2; i >= row + 1; i--){
                result.add(matrix[i][col]);
            }
        }
        spiralOrder(matrix, row + 1, col + 1, rows - 1, cols - 1);
    }

    public static void main(String[] args){
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        SpiralMatrix test = new SpiralMatrix();
        System.out.println(test.spiralOrder(matrix));
    }
}
