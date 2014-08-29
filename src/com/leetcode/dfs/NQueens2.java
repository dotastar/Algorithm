package com.leetcode.dfs;

/**
 * Follow up for N-Queens problem.
 *
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 *
 * Created by Xiaomeng on 8/24/2014.
 */
public class NQueens2 {
    char[][] chessBoard;
    int len;
    int count;
    public int totalNQueens(int n) {
        chessBoard = new char[n][n];
        len = n;
        count = 0;
        dfs(0);
        return count;
    }

    public void dfs(int row){
        if(row >= len){
            count++;
            return;
        }
        for(int i = 0; i < len; i++){
            if(!hasAttack(row, i)){
                chessBoard[row][i] = 'Q';
                dfs(row + 1);
                chessBoard[row][i] = '.';
            }
        }
    }

    public boolean hasAttack(int row, int col){
        for(int i = 0; i <= row; i++){
           if(chessBoard[i][col] == 'Q') return true;
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(chessBoard[i][j] == 'Q') return true;
        }

        for(int i = row, j = col; i >= 0 && j < len; i--, j++){
            if(chessBoard[i][j] == 'Q') return true;
        }
        return false;
    }

    public static void main(String[] args){
        NQueens2 test = new NQueens2();
        System.out.println(test.totalNQueens(8));
    }
}
