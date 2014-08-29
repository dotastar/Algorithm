package com.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * Created by Xiaomeng on 8/26/2014.
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if(rowIndex == 0) return result;
        result.add(1);
        if(rowIndex == 1) return result;

        List<Integer> tmp = new ArrayList<Integer>();
        for(int i = 1; i <= rowIndex - 1; i++){
            for(int j = 0; j < result.size(); j++){
                if(j == result.size() - 1){
                    tmp.add(1);
                    break;
                }
                if(j == 0){
                    tmp.add(1);
                }
                tmp.add(result.get(j) + result.get(j + 1));
            }
            result.clear();
            result.addAll(tmp);
            tmp.clear();
        }
        return result;
    }

    public static void main(String[] args){
        PascalTriangle2 test = new PascalTriangle2();
        System.out.println(test.getRow(3));
    }
}
