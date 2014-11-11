package com.fb;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Xiaomeng on 11/4/2014.
 */
public class LongestCommonSubstring {
    /**
     * Time(m * n), Space(m * n)
     *
     * Follow-ups:
     * The following tricks can be used to reduce the memory usage of an implementation:
     * Keep only the last and current row of the DP table to save memory (O(\min(m, n)) instead of O(n m))
     * Store only non-zero values in the rows. This can be done using hash tables instead of arrays. This is useful for large alphabets.
     * How about the input is a set of strings?
     *
     * Reference:
     * http://en.wikipedia.org/wiki/Longest_common_substring_problem
     * http://www.geeksforgeeks.org/longest-common-substring/
     *
     */
    public static int findLCS(String S, String T){
        int m = S.length();
        int n = T.length();
        int[][] memo = new int[m + 1][n + 1];
        Set<String> result = new HashSet<String>();

        int longest = 0;
        for(int i = 0; i < m + 1; i ++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0 || j == 0){
                    memo[i][j] = 0;
                }else if(S.charAt(i - 1) == T.charAt(j - 1)){
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    if(memo[i][j] > longest){
                        longest = memo[i][j];
                        result.clear();
                    }
                    if(memo[i][j] == longest){
                        result.add(S.substring(i - longest, i));
                    }
                }else{
                    memo[i][j] = 0;
                }
            }
        }
        System.out.println(result);
        return longest;
    }

    public static void main(String[] args){
        String S = "xiaomeng";
        String T = "asdxiaofasdfmengasdf";
        System.out.println(findLCS(S, T));
    }
}
