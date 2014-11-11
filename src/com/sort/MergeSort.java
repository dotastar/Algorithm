package com.sort;

/**
 * Merge Sort
 *
 */
public class MergeSort {
    public void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int start, int end){
        if(start >= end) return;

        int mid =  start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public void merge(int[] arr, int start, int mid, int end){
        int[] helper = new int[end - start + 1];

        int index = 0;
        int i = start, j = mid + 1;
        while(i <= mid && j <= end){
            if(arr[i] < arr[j])
                helper[index++] = arr[i++];
            else
                helper[index++] = arr[j++];
        }

        while(i <= mid){
            helper[index++] = arr[i++];
        }

        while(j <= end){
            helper[index++] = arr[j++];
        }

        for(int k = 0; k < end - start + 1; k++){
            arr[start + k] = helper[k];
        }
    }

    public static void main(String[] args){
        MergeSort test = new MergeSort();
        int[] arr = {3,1,2,5,67,2,1,32,456,1,12,3,5342};
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        test.mergeSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
