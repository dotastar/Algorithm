package com.leetcode.dfs;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * Created by Xiaomeng on 8/3/2014.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] num = new int[n + 1];
        int count = 1;
        for(int i = 0; i < n; i++){
            num[i] = i + 1;
            count *= i + 1;
        }
        k--;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            count /= n - i;
            int index = k/count;
            result.append(num[index]);
            for(int j = index; j < n; j++){
                num[j] = num[j + 1];
            }
            k %= count;
        }
        return result.toString();
    }

    public static void main(String[] args){
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(3, 4));
    }
}
