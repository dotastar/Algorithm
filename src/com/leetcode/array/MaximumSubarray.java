package com.leetcode.array;

/**
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 *  For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *  the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 *  More practice:
 *  If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *  Created by Xiaomeng on 7/29/2014.
 */
public class MaximumSubarray {
    /**
     * DP
     * @param A
     * @return
     */
    public static int maxSubArray(int[] A) {
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }

    /**
     * Divide and conquer
     * @param A
     * @return
     */
    public static int maxSubArray2(int[] A) {
        return maxSubArray2(A, 0, A.length - 1);
    }

    public static int maxSubArray2(int[] A, int start, int end){
        if(start > end) return Integer.MIN_VALUE;
        int mid = (start + end)/2;
        int leftMax = maxSubArray2(A, start, mid - 1);
        int rightMax = maxSubArray2(A, mid + 1, end);

        int left = 0, sum = 0;
        for(int i = mid - 1; i >= start; i--){
            sum += A[i];
            left = sum > left ? sum : left;
        }

        int right = 0;
        sum = 0;
        for(int i = mid + 1; i <= end; i++){
            sum += A[i];
            right = sum > right ? sum : right;
        }

        return Math.max(A[mid] + left + right, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args){
        int[] A = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(A));
    }
}
