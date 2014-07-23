package com.leetcode.palindrome;

/**
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 *  For example,
 *  "A man, a plan, a canal: Panama" is a palindrome.
 *  "race a car" is not a palindrome.
 *
 *  Note:
 *  Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 *  For the purpose of this problem, we define empty string as valid palindrome.
 *
 *  Created by Xiaomeng on 7/22/2014.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.trim().isEmpty()) return true;
        int low = 0, high = s.length() - 1;
        s = s.toLowerCase();
        while(low < high){
            Character lowChar = s.charAt(low);
            Character highChar = s.charAt(high);
            if(!Character.isLetterOrDigit(lowChar)){
                low++;
                continue;
            }
            if(!Character.isLetterOrDigit(highChar)){
                high--;
                continue;
            }
            if(!highChar.equals(lowChar)) return false;
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "1a2";
        if(isPalindrome(s))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
