package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * Created by Xiaomeng on 8/21/2014.
 */
public class LetterCombinationsOfPhoneNumber {
    Map<Character, String> map;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        StringBuilder single = new StringBuilder();
        result = new ArrayList<String>();
        map = buildMap();
        dfs(single, digits, 0);
        return result;
    }

    private void dfs(StringBuilder single, String digits, int index){
        if(index >= digits.length()){
            result.add(single.toString());
            return;
        }

        String combine = map.get(digits.charAt(index));
        for(int i = 0; i < combine.length(); i++){
            single.append(combine.charAt(i));
            dfs(single, digits, index + 1);
            single.deleteCharAt(single.length() - 1);
        }
    }

    private Map<Character, String> buildMap(){
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;
    }

    public static void main(String[] args){
        LetterCombinationsOfPhoneNumber test = new LetterCombinationsOfPhoneNumber();
        System.out.println(test.letterCombinations("23"));
    }



}
