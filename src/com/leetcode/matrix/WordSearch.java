package com.leetcode.matrix;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 *
 * Given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 *
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * Created by Xiaomeng on 9/9/2014.
 */
public class WordSearch{
    char[][] board;
    int rows;
    int cols;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(search(i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean search(int i, int j, String word, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] == '#' || board[i][j] != word.charAt(index)) return false;
        char tmp = board[i][j];
        board[i][j] = '#';
        if(search(i + 1, j, word, index + 1) || search(i - 1, j, word, index + 1)
                || search(i, j + 1, word, index + 1) || search(i, j - 1, word, index + 1)){
            return true;
        }else{
            board[i][j] = tmp;
            return false;
        }
    }

    public static void main(String[] args){
        String word = "bcdea";
        char[][] board = {
                {'a','b','e','a'},
                {'a','c','d','a'},
                {'a','a','c','a'},
                {'a','a','b','a'}
        };
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word));
    }
}
