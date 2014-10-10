package com.leetcode.other;

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 * Created by Xiaomeng on 9/21/2014.
 */
public class RegularExpressionMatching {
    /*
    * Reference: http://blog.csdn.net/fightforyourdream/article/details/17717873
    * */
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int i, int j){
        if(j == p.length())
            return i == s.length();
        if(j == p.length() - 1)
            return (i == s.length() - 1) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if(j + 1 < p.length() && p.charAt(j + 1) != '*'){
            if(i >= s.length())
                return false;
            if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                return isMatch(s, p, i + 1, j + 1);
            }else{
                return false;
            }
        }
        while(i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')){
            if(isMatch(s, p, i, j + 2)) return true;
            i++;
        }
        return isMatch(s, p, i, j + 2);
    }

    public static void main(String[] args){
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch("aa","a"));         //--> false
        System.out.println(test.isMatch("aa","aa"));        //--> true
        System.out.println(test.isMatch("aa","aaa"));       //--> false
        System.out.println(test.isMatch("aa","a*"));        //--> true
        System.out.println(test.isMatch("aa",".*"));        //--> true
        System.out.println(test.isMatch("ab",".*"));        //--> true
        System.out.println(test.isMatch("aab","c*a*b*"));   //--> true
        System.out.println(test.isMatch("ab",".*c"));       //--> false
    }
}
