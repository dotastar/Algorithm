package com.leetcode.dp;

/**
 *  Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 *  For example,
 *
 *  Given:
 *  s1 = "aabcc",
 *  s2 = "dbbca",
 *
 *  When s3 = "aadbbcbcac", return true.
 *  When s3 = "aadbbbaccc", return false.
 *
 *  Created by Xiaomeng on 9/13/2014.
 */
public class InterleavingString {
    /*
    * DPS Solution
    * */
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    public boolean isInterleave(String s1, String s2, String s3, int i1, int i2, int i3){
        if(i3 == s3.length()) return true;
        if(i1 == s1.length()) return s2.substring(i2).equals(s3.substring(i3));
        if(i2 == s2.length()) return s1.substring(i1).equals(s3.substring(i3));

        if(s1.charAt(i1) == s3.charAt(i3) && s2.charAt(i2) == s3.charAt(i3))
            return isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1) || isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1);
        else if(s1.charAt(i1) == s3.charAt(i3))
            return isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1);
        else if(s2.charAt(i2) == s3.charAt(i3))
            return isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1);
        else
            return false;
    }

    /*
    * Two dimensional DP solution
    * Reference: http://blog.csdn.net/u011095253/article/details/9248073
    * */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        boolean[][] memo = new boolean[s1.length() + 1][s2.length() + 1];
        memo[0][0] = true;
        for(int i = 1; i <= s1.length(); i++){
            if(memo[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1))
                memo[i][0] = true;
        }

        for(int j = 1; j <= s2.length(); j++){
            if(memo[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1))
                memo[0][j] = true;
        }

        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(memo[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    memo[i][j] = true;
                }
                if(memo[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    memo[i][j] = true;
                }
            }
        }
        return memo[s1.length()][s2.length()];
    }

    public static void main(String[] args){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";

        InterleavingString test = new InterleavingString();
        System.out.println(test.isInterleave2(s1, s2, s3));
    }
}
