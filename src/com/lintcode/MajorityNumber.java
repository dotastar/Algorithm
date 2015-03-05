package com.lintcode;

import java.util.List;

/**
 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
 *
 * Example
 * For [1, 1, 1, 1, 2, 2, 2], return 1
 *
 * Challenge
 * O(n) time and O(1) space
 *
 */
public class MajorityNumber {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        int candidate = nums.get(0);
        int count = 1;
        for(int i = 1; i < nums.size(); i++){
            if(candidate == nums.get(i)){
                count++;
            }else if(count == 0){
                candidate = nums.get(i);
                count = 1;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
