package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 * ["..Q.",  // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 * Created by Xiaomeng on 8/24/2014.
 */
public class NQueens {
    List<String[]> result;
    char[][] chessBoard;
    int len;

    public List<String[]> solveNQueens(int n) {
        result = new ArrayList<String[]>();
        chessBoard = new char[n][n];
        len = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chessBoard[i][j] = '.';
            }
        }
        dfs(0);
        return result;
    }

    public void dfs(int row){
        if(row >= len){
            populateResult();
            return;
        }

        for(int i = 0; i < chessBoard[0].length; i++){
            if(!hasAttack(row, i)){
                chessBoard[row][i] = 'Q';
                dfs(row + 1);
                chessBoard[row][i] = '.';
            }
        }
    }

    public void populateResult(){
        String[] solution = new String[len];
        for(int i = 0; i < len; i++){
            StringBuilder line = new StringBuilder();
            line.append(chessBoard[i]);
            solution[i] = line.toString();
        }
        result.add(solution);
    }

    private boolean hasAttack(int row, int col){
        for(int i = row; i >= 0; i--){
            if(chessBoard[i][col] == 'Q') return true;
        }

        for(int i = row, j = col; i >= 0 && j >=0; i--, j--){
            if(chessBoard[i][j] == 'Q') return true;
        }

        for(int i = row, j = col; i >= 0 && j < len; i--, j++){
            if(chessBoard[i][j] == 'Q') return true;
        }
        return false;
    }

    public static void main(String[] args){
        NQueens test = new NQueens();
        List<String[]> result = test.solveNQueens(4);
        for(String[] strs: result){
            for(int i = 0; i < strs.length; i++){
                System.out.println(strs[i]);
            }
            System.out.println();
        }

    }
}
