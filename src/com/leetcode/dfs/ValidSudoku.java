package com.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 * Created by Xiaomeng on 5/18/2014.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9) return false;

        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(!Character.isDigit(board[i][j])) return false;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.') continue;
                if(!Character.isDigit(board[j][i])) return false;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        int x = 0, y = 0;
        while(y < 9){
            set.clear();
            for(int i = x; i < x + 3; i++){
                for(int j = y; j < y + 3; j++){
                    if(board[i][j] == '.') continue;
                    if(!Character.isDigit(board[i][j])) return false;
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
            if(x == 6){
                x = 0;
                y += 3;
            }else{
                x += 3;
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board));
    }
}
