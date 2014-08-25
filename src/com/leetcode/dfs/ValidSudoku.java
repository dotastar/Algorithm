package com.leetcode.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 *
 * Created by Xiaomeng on 8/24/2014.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        //Row
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        //Column
        for(int i = 0; i < 9; i++){
            set.clear();
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.') continue;
                if(set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        int i = 0, j = 0;
        while(i < 9 && j < 9){
            set.clear();
            for(int m = i; m < i + 3; m++){
                for(int n = j; n < j + 3; n++){
                    if(board[m][n] == '.') continue;
                    if(set.contains(board[m][n])) return false;
                    set.add(board[m][n]);
                }
            }
            if(j == 6){
                i += 3;
                j = 0;
            }else{
                j += 3;
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

        ValidSudoku test = new ValidSudoku();
        System.out.println(test.isValidSudoku(board));
    }
}
