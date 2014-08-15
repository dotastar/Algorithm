package com.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Created by Xiaomeng on 8/3/2014.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        Map<Integer, Character> map = buildMap();
        String number = String.valueOf(num);
        int exp = number.length() - 1;
        for(int i = 0; i < number.length(); i++){
            int digit = Character.getNumericValue(number.charAt(i));
            int base = (int)Math.pow(10, exp);
            if(digit <= 3 && digit > 0){
                for(int j = 0; j < digit; j++) result.append(map.get(base));
            }else if(digit == 4){
                result.append(map.get(base));
                result.append(map.get(base * 5));
            }else if(digit == 5){
                result.append(map.get(base * 5));
            }else if(digit > 5 && digit <= 8){
                result.append(map.get(base * 5));
                for(int j = 0; j < digit - 5; j++) result.append(map.get(base));
            }else if(digit == 9){
                result.append(map.get(base));
                result.append(map.get(base * 10));
            }
            exp--;
        }
        return result.toString();
    }

    public Map<Integer, Character> buildMap(){
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1,   'I');
        map.put(5,   'V');
        map.put(10,  'X');
        map.put(50,  'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000,'M');
        return map;
    }

    public static void main(String[] args){
        int num = 1954;
        IntegerToRoman test = new IntegerToRoman();
        System.out.println(test.intToRoman(num));
    }
}
