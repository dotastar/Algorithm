package com.leetcode.dp;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 *  We say that "rgtae" is a scrambled string of "great".
 *
 *  Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 *  Created by Xiaomeng on 9/18/2014.
 */
public class ScrambleString {
    /*
    * Recursive
    * Reference: http://www.cnblogs.com/TenosDoIt/p/3452004.html
    * */
    public boolean isScramble(String s1, String s2) {
        return isScrambleRecur(s1, s2);
    }

    public boolean isScrambleRecur(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String sorted1 = new String(arr1);
        String sorted2 = new String(arr2);

        if(!sorted1.equals(sorted2)) return false;
        if(s1.equals(s2)) return true;

        int len = s1.length();
        int k = 1;
        while(k < len){
            String left1 = s1.substring(0, k);
            String left2 = s1.substring(k);

            String right1 = s2.substring(0, k);
            String right2 = s2.substring(k);

            if((isScramble(left1, right1) && isScramble(left2, right2)))
                return true;

            right1 = s2.substring(len - k);
            right2 = s2.substring(0, len - k);

            if(isScramble(left1, right1) && isScramble(left2, right2))
                return true;
            k++;
        }
        return false;
    }

    /*
    * DP
    * Reference: http://www.cnblogs.com/TenosDoIt/p/3452004.html
    * */
    public boolean isScrambleRecurDP(String s1, String s2){
        int len = s1.length();
        boolean memo[][][] = new boolean[len + 1][len][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                memo[1][i][j] = s1.charAt(i) == s2.charAt(j) ? true : false;
            }
        }

        for(int k = 2; k < len + 1; k++){
            for(int i = 0; i <= len - k; i++){
                for(int j = 0; j <= len - k; j++){
                    for(int div = 1; div <= k && !memo[k][i][j]; div++){
                        memo[k][i][j] = (memo[div][i][j] && memo[k - div][i + div][j + div])
                                || (memo[div][i][j + k - div] && memo[k - div][i + div][j]);
                    }
                }
            }
        }
        return memo[len][0][0];
    }
}
