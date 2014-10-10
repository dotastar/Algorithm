package com.leetcode.dp;

/**
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 *  For example, given the array [2,3,-2,4],
 *  the contiguous subarray [2,3] has the largest product = 6.
 *
 *  Created by Xiaomeng on 9/24/2014.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        if(A.length == 1) return A[0];
        int currMax = A[0], currMin = A[0], max = A[0];
        for(int i = 1; i < A.length; i++){
            int currMaxCopy = currMax;
            currMax = Math.max(Math.max(A[i], currMax *A[i]), currMin * A[i]);
            currMin = Math.min(Math.min(A[i], currMaxCopy * A[i]), currMin * A[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }

    public static void main(String[] args){
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] A = {2,3,-2,4,5,-1};
        System.out.println(test.maxProduct(A));
    }
}
