package com.geeksforgeeks.dp;

/**
 * Created by Xiaomeng on 11/25/2014.
 */
public class EditDistance {
    public static int getEditDistance(String S, String T){
        int m = S.length();
        int n = T.length();

        int[][] memo = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0)
                    memo[i][j] = j;
                else if(j == 0)
                    memo[i][j] = i;
                else{
                    int corner = memo[i - 1][j - 1] + S.charAt(i - 1) == T.charAt(j - 1) ? 0 : 1;
                    int left = memo[i - 1][j] + 1;
                    int right = memo[i][j - 1] + 1;
                    memo[i][j] = Math.min(Math.min(left, right), corner);
                }
            }
        }
        return memo[m][n];
    }
}
