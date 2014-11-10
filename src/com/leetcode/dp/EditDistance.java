package com.leetcode.dp;

/**
 *  Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 *  You have the following 3 operations permitted on a word:
 *
 *  a) Insert a character
 *  b) Delete a character
 *  c) Replace a character
 *
 */
public class EditDistance {
    /**
     * Two dimensional DP
     * Reference: http://blog.unieagle.net/
     *
     */
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < word1.length() + 1; i++){
            memo[i][0] = i;
        }

        for(int j = 0; j < word2.length() + 1; j++){
            memo[0][j] = j;
        }

        for(int i = 1; i < word1.length() + 1; i++){
            for(int j = 1; j < word2.length() + 1; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    memo[i][j] = memo[i - 1][j - 1];
                }else{
                    memo[i][j] = Math.min(Math.min(memo[i - 1][j], memo[i][j - 1]), memo[i - 1][j - 1]) + 1;
                }
            }
        }
        return memo[word1.length()][word2.length()];
    }

    /**
     * One dimensional DP!
     *
     */
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] memoUp = new int[n + 1];
        int[] memoDown = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            memoUp[i] = i;
        }

        int j = 1;
        while(j <= m){
            for(int i = 0; i < n + 1 && j <= m; i++){
                if(i == 0){
                    memoDown[i] = j;
                }else{
                    if(word1.charAt(j - 1) == word2.charAt(i - 1)){
                        memoDown[i] = memoUp[i - 1];
                    }else{
                        memoDown[i] = Math.min(Math.min(memoUp[i], memoDown[i - 1]), memoUp[i - 1]) + 1;
                    }
                }
            }
            int[] tmp = memoUp;
            memoUp = memoDown;
            memoDown = tmp;
            j++;
        }
        return memoUp[n];
    }
}
