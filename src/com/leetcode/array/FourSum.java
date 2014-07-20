package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 *
 * * Created by Xiaomeng on 7/20/2014.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i < num.length; i++){
            if(i != 0 && num[i] == num[i - 1]) continue;
            for(int j = i + 1; j < num.length; j++){
                if(j != i + 1 && num[j] == num[j - 1]) continue;
                int start = j + 1, end = num.length - 1;
                while(start < end){
                    if(num[start] + num[end] + num[i] + num[j] > target){
                        end--;
                    }else if(num[start] + num[end] + num[i] + num[j] < target){
                        start++;
                    }else{
                        List<Integer> quadruplet = new ArrayList<Integer>();
                        quadruplet.add(num[i]);
                        quadruplet.add(num[j]);
                        quadruplet.add(num[start]);
                        quadruplet.add(num[end]);
                        result.add(quadruplet);
                        start++;
                        end--;
                        while(start < end && num[start] == num[start - 1]) start++;
                        while(start < end && num[end] == num[end + 1]) end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(nums, 0);
        for(List<Integer> quadruplet : result){
            System.out.println(quadruplet);
        }
    }
}
