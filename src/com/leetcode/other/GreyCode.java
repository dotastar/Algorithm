package com.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 *
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 *
 * Created by Xiaomeng on 9/2/2014.
 */
public class GreyCode {
    /**
     * Reference:
     * http://yucoding.blogspot.com/2013/01/leetcode-question-33-gary-code.html
     * http://www.cnblogs.com/TenosDoIt/p/3451938.html
     * http://www.cnblogs.com/lihaozy/archive/2012/12/31/2840437.html
     *
     * @param n
     * @return List of Integer
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int count = (int)Math.pow(2, n);
        for(int i = 0; i < count; i++){
            result.add((i >> 1) ^ i);
        }
        return result;
    }

    public static void main(String[] args){
        GreyCode test = new GreyCode();
        System.out.println(test.grayCode(2));
    }
}
