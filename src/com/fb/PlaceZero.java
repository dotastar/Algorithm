package com.fb;

/**
 * Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
 * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
 * The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).
 *
 */
public class PlaceZero {
    /**
     * Reference: http://www.geeksforgeeks.org/move-zeroes-end-array/
     */
    public static void placeZero2(int[] arr){
        if(arr.length == 0) return;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                arr[count++] = arr[i];
            }
        }
        while(count < arr.length) arr[count++] = 0;
    }

    /**
     * My solution: doesn't keep the order
     *
     */
    public static void placeZero1(int[] arr){
        if(arr.length == 0) return;

        int start = 0, end = arr.length - 1;
        while(end >= start && arr[end] == 0) end--;
        while(start < end){
            if(arr[end] == 0){
                end--;
            }if(arr[start] != 0){
                start++;
            }else if(arr[start] == 0){
                swap(arr, start++, end--);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        placeZero2(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
