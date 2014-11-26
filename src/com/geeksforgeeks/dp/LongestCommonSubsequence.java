package com.geeksforgeeks.dp;

/**
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 *
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4
 *
 */
public class LongestCommonSubsequence {
    public static int getLCS(String S, String T){
        int m = S.length();
        int n = T.length();

        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    memo[i][j] = 0;
                }else{
                    if(S.charAt(i - 1) == T.charAt(j - 1)){
                        memo[i][j] = memo[i - 1][j - 1] + 1;
                    }else{
                        memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                    }
                }
            }
        }
        return memo[m][n];
    }

    public static void main(String[] args){
        String S = "AGGTAB";
        String T = "GXTXAYB";
        System.out.println(getLCS(S, T));
    }
}
