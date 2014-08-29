package com.leetcode.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 *  Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 *  Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 *  Some examples:
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 *  Created by Xiaomeng on 8/22/2014.
 */
public class EvaluateReversePolishNotation {
    public static Set<String> validOperators= new HashSet<String>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        for(String token: tokens){
            if(validOperators.contains(token)){
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                if("+".equals(token))
                    stack.push(String.valueOf(operand1 + operand2));
                else if("-".equals(token))
                    stack.push(String.valueOf(operand1 - operand2));
                else if("*".equals(token))
                    stack.push(String.valueOf(operand1 * operand2));
                else if("/".equals(token))
                    stack.push(String.valueOf(operand1 / operand2));
            }else{
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args){
        String[] tokens = {"4", "13", "5", "/", "+"};
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        System.out.println(test.evalRPN(tokens));
    }
}
