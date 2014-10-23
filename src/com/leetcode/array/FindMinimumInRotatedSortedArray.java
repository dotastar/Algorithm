package com.leetcode.array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Created by Xiaomeng on 10/22/2014.
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if(num.length == 0) return 0;
        return binarySearch(num, 0, num.length - 1);
    }

    public int binarySearch(int[] num, int start, int end){
        if(start == end) return num[start];

        if(num[start] < num[end]){
            return num[start];
        }

        int mid = start + (end - start)/2;
        if(mid - 1 >= 0 && num[mid] < num[mid - 1]){
            return num[mid];
        }

        if(num[start] > num[mid]){
            return binarySearch(num, start, mid - 1);
        }else{
            return binarySearch(num, mid + 1, end);
        }
    }

    public static void main(String[] args){
        int[] num = {4, 5, 6, 7, 8, 1, 2, 3};
        FindMinimumInRotatedSortedArray test = new FindMinimumInRotatedSortedArray();
        System.out.println(test.findMin(num));
    }
}
