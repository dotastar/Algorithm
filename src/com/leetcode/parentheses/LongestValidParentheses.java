package com.leetcode.parentheses;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 * Created by Xiaomeng on 8/24/2014.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(ch.equals(')') && !stack.isEmpty() && s.charAt(stack.peek()) == '('){
                stack.pop();
                if(stack.isEmpty()){
                    max = i + 1;
                }else{
                    max = Math.max(i - stack.peek(), max);
                }
            }else{
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args){
        LongestValidParentheses test = new LongestValidParentheses();
        String s = "()(())";
        System.out.println(test.longestValidParentheses(s));
    }
}
