package com.leetcode.dp;

/**
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 *  Return the minimum cuts needed for a palindrome partitioning of s.
 *
 *  For example, given s = "aab",
 *  Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 *  Created by Xiaomeng on 9/9/2014.
 */
public class PalindromePartitioning2 {
    /*
     * Double DP: http://yucoding.blogspot.com/2013/08/leetcode-question-133-palindrome.html
     * Possible O(n) solution: https://oj.leetcode.com/discuss/9476/solution-does-not-need-table-palindrome-right-uses-only-space
     */
    public int minCut(String s) {
        int len = s.length();
        int[] min = new int[len];
        boolean[][] p = new boolean[len][len];

        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                p[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || p[i + 1][j - 1]);
            }
        }

        for(int i = 0; i < len; i++){
            if(p[0][i]){
                min[i] = 0;
            }else{
                int rs = len;
                for(int j = 0; j < i; j++){
                    if(p[j + 1][i]){
                        rs = Math.min(rs, min[j] + 1);
                    }
                }
                min[i] = rs;
            }
        }
        return min[len - 1];
    }

    public static void main(String[] args){
        PalindromePartitioning2 test = new PalindromePartitioning2();
        String s = "aab";
        System.out.println(test.minCut(s));
    }
}
