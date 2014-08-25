package com.leetcode.dfs;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 *
 * Created by Xiaomeng on 8/25/2014.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        canSolveSudoku(board);
    }

    public boolean canSolveSudoku(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char m = '1'; m <= '9'; m++){
                        board[i][j] = m;
                        if(isValid(board, i, j) && canSolveSudoku(board)) return true;
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int x, int y){
        //Row
        for(int i = 0; i < 9; i++){
            if(i != x && board[i][y] == board[x][y]) return false;
        }

        //Col
        for(int i = 0; i < 9; i++){
            if(i != y && board[x][i] == board[x][y]) return false;
        }

        //Square
        for(int i = 3 * (x/3); i < 3 * (x/3) + 3; i++){
            for(int j = 3 * (y/3); j < 3 * (y/3) + 3; j++){
                if(i != x && j != y && board[i][j] == board[x][y]) return false;
            }
        }
        return true;
    }
}
