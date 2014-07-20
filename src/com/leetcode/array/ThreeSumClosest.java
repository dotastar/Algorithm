package com.leetcode.array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Created by Xiaomeng on 7/20/2014.
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int diff = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++){
            int start = i + 1, end = num.length - 1;
            while(start < end){
                if(Math.abs(num[start] + num[end] + num[i] - target) < diff){
                    diff = Math.abs(num[start] + num[end] + num[i] - target);
                    result = num[start] + num[end] + num[i];
                }
                if(num[start] + num[end] + num[i] < target){
                    start++;
                }else if(num[start] + num[end] + num[i] > target){
                    end--;
                }else{
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {0,2,1,-3};
        System.out.println(threeSumClosest(nums, 1));

    }
}
