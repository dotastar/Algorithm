package com.leetcode.dp;

/**
 *  Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 *  A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
 *  (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 *  Here is an example:
 *  S = "rabbbit", T = "rabbit"
 *  Return 3.
 *
 *  Created by Xiaomeng on 9/13/2014.
 */
public class DistinctSubsequences {
    /*
    * Two dimensional DP
    * Reference: http://blog.csdn.net/abcbc/article/details/8978146
    *
    * */
    public int numDistinct(String S, String T) {
        int[][] memo = new int[T.length() + 1][S.length() + 1];

        for(int i = 1; i < T.length() + 1; i++){
            memo[i][0] = 0;
        }

        for(int j = 0; j < S.length() + 1; j++){
            memo[0][j] = 1;
        }

        for(int i = 1; i < T.length() + 1; i++){
            for(int j = 1; j < S.length() + 1; j++){
                memo[i][j] = memo[i][j - 1] + (T.charAt(i - 1) == S.charAt(j - 1) ? memo[i - 1][j - 1] : 0);
            }
        }
        return memo[T.length()][S.length()];
    }
}
