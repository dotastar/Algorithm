package com.sort;

import java.util.Random;

/**
 * Created by Xiaomeng on 11/8/2014.
 */
public class QuickSelect {
    /**
     * Average case performance: O(n)
     * Best case performance: O(n)
     * Worst case performance: O(n^2)
     *
     */
    public int quickSelect(int[] arr, int k){
        if(k - 1 <= 0 || k - 1 > arr.length) return -1;
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    public int quickSelect(int[] arr, int start, int end, int k){
        if(start <= end){
            int partitionIndex = partition(arr, start, end);
            if(partitionIndex == k){
                return arr[partitionIndex];
            }else if(partitionIndex < k){
                return quickSelect(arr, partitionIndex + 1, end, k);
            }else{
                return quickSelect(arr, start, partitionIndex - 1, k);
            }
        }
        return -1;
    }

    public int partition(int[] arr, int start, int end){
        Random random = new Random();
        int pivotIndex = start + random.nextInt(end - start + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);

        int index = start;
        for(int i = start; i <= end; i++){
            if(arr[i] < pivot){
                swap(arr, i, index++);
            }
        }
        swap(arr, index, end);
        return index;
    }

    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = {12,21,32,43,5,63,7};
        QuickSelect test = new QuickSelect();
        System.out.println(test.quickSelect(arr, 4));
    }
}
