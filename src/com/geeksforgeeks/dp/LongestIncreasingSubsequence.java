package com.geeksforgeeks.dp;

/**
 * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 */
public class LongestIncreasingSubsequence {
    public static int getLIS(int[] arr){
        int len = arr.length;
        if(len == 0) return 0;
        int[] memo = new int[len];
        for(int i = 0; i < len; i++){
            memo[i] = 1;
        }

        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && memo[i] < memo[j] + 1){
                    memo[i] = memo[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < len; i++){
            if(memo[i] > max) max = memo[i];
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {10, 22, 9};
        System.out.println(getLIS(arr));
    }
}
