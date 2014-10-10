package com.leetcode.matrix;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 *
 * Created by Xiaomeng on 9/1/2014.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++){
            int first = layer;
            int last = n - layer - 1;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int tmp = matrix[first][i];
                //left-bottom to left-top
                matrix[first][i] = matrix[last - offset][first];
                //right-bottom to left-bottom
                matrix[last - offset][first] = matrix[last][last - offset];
                //right-top to right-bottom
                matrix[last][last - offset] = matrix[i][last];
                //left-top to right-top
                matrix[i][last] = tmp;
            }
        }
    }
}
