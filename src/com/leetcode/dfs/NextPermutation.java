package com.leetcode.dfs;

/**
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 *  If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 *  The replacement must be in-place, do not allocate extra memory.
 *
 *  Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *  1,2,3 → 1,3,2
 *  3,2,1 → 1,2,3
 *  1,1,5 → 1,5,1
 *
 *  Created by Xiaomeng on 8/2/2014.
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num.length == 0 || num.length == 1) return;

        int i = num.length - 2;
        while(i >= 0 && num[i] >= num[i + 1]) i--;
        if(i < 0){
            reverse(num, 0, num.length - 1);
        }else{
            int partitionNum = num[i];
            int j = num.length - 1;
            while(j >= 0 && num[j] <= partitionNum) j--;
            swap(num, i, j);
            reverse(num, i + 1, num.length - 1);
        }
    }

    public void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        NextPermutation test = new NextPermutation();
        int[] num = {2,3,1};

        for(int i = 0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
        System.out.println();

        test.nextPermutation(num);
        for(int i = 0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
    }
}
