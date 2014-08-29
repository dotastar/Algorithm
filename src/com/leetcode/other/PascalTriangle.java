package com.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 *
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * Created by Xiaomeng on 8/26/2014.
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) return result;

        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        result.add(first);
        if(numRows == 1) return result;

        List<Integer> second = new ArrayList<Integer>();
        second.add(1);
        second.add(1);
        result.add(second);
        if(numRows == 2) return result;

        for(int i = 3; i <= numRows; i++){
            List<Integer> prev = result.get(i - 2);
            List<Integer> curr = new ArrayList<Integer>();
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i - 1) {
                    curr.add(1);
                }else{
                    curr.add(prev.get(j - 1) + prev.get(j));
                }
            }
            result.add(curr);
        }
        return result;
    }

    public static void main(String[] args){
        PascalTriangle test = new PascalTriangle();
        List<List<Integer>> result = test.generate(10);
        for(List<Integer> single : result){
            System.out.println(single);
        }
    }
}
