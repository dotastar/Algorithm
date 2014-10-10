package com.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 *
 *  You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 *
 *  Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 *  For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 *  For example,
 *  words: ["This", "is", "an", "example", "of", "text", "justification."]
 *  L: 16.
 *
 *  Return the formatted lines as:
 *
 *  [
 *      "This    is    an",
 *      "example  of text",
 *      "justification.  "
 *  ]
 *
 *  Note: Each word is guaranteed not to exceed L in length.
 *
 *  Corner Cases:
 *
 *  A line other than the last line might contain only one word. What should you do in this case?
 *  In this case, that line should be left-justified.
 *
 *  Created by Xiaomeng on 9/23/2014.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if(L == 0){
            result.add("");
            return result;
        }
        StringBuilder single = new StringBuilder();

        int i = 0;
        int count = 0;
        int len = 0;
        while(i < words.length){
            if(len + words[i].length() <= L){
                len += words[i].length() + 1;
                count++;
                if(i == words.length - 1){
                    for(int j = i - count + 1; j <= i; j++){
                        single.append(words[j]);
                        if(j != i) single.append(' ');
                    }
                    int leftSpaces = L - single.length();
                    for(int m = 0; m < leftSpaces; m++){
                        single.append(' ');
                    }
                    result.add(single.toString());
                }
                i++;
            }else{
                if(count == 1){
                    single.append(words[i - 1]);
                    int leftSpaces = L - single.length();
                    for(int m = 0; m < leftSpaces; m++){
                        single.append(' ');
                    }
                }else{
                    len -= 1;
                    int spaces = L - len;
                    int average = spaces / (count - 1);
                    int extra = spaces % (count - 1);
                    for(int j = i - count; j <= i - 1; j++){
                        single.append(words[j]);
                        if(j != i - 1){
                            single.append(' ');
                            for(int m = 0; m < average; m++) single.append(' ');
                            if(extra > 0){
                                single.append(' ');
                                extra--;
                            }
                        }
                    }
                }
                result.add(single.toString());
                single = new StringBuilder();
                len = 0;
                count = 0;
            }
        }
        return result;
    }

    public static void main(String[] args){
        TextJustification test = new TextJustification();
        String[] words = {"This","is","an","example","of","text","xiaomeng","chen"};
//        String[] words = {"a"};
        int L = 16;
        for(String single : test.fullJustify(words, L)){
            System.out.println("{" + single + "}");
        }
    }
}
