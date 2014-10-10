package com.leetcode.other;

/**
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 *
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 * Created by Xiaomeng on 9/15/2014.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        if(s == null || s.trim().isEmpty()) return false;

        boolean dotPresent = false;
        boolean ePresent = false;
        boolean firstPart = false;
        boolean secondPart = false;

        s = s.trim();

        int start = 0;
        while(start < s.length() && (s.charAt(start) == '+' || s.charAt(start) == '-')) start++;

        for(int i = start; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '.'){
                if(dotPresent || ePresent) return false;
                dotPresent = true;
            }else if(ch >= 48 && ch <= 57){
                if(ePresent)
                    secondPart = true;
                else
                    firstPart = true;
            }else if(ch == 'e' || ch == 'E'){
                if(ePresent || !firstPart)
                    return false;
                else
                    ePresent = true;
            }else if(ch == '+' || ch == '-'){
                char prev = s.charAt(i - 1);
                if(!ePresent || !(prev == 'e' || prev == 'E'))
                    return false;
            }else{
                return false;
            }
        }

        if(!firstPart)
            return false;
        else if(ePresent && !secondPart)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        ValidNumber test = new ValidNumber();
        System.out.println(test.isNumber("0e"));  //false
        System.out.println(test.isNumber("3."));  //true
        System.out.println(test.isNumber("."));   //false
        System.out.println(test.isNumber(".1"));  //true
        System.out.println(test.isNumber(".e1")); //false
        System.out.println(test.isNumber("-1.")); //true
        System.out.println(test.isNumber("+.8")); //true
    }
}
