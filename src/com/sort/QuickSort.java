package com.sort;

/**
 * Quick Sort
 *
 */
public class QuickSort {
    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end){
        if(start >= end) return;
        int partitionIndex = partition(arr, start, end);
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    public int partition(int[] arr, int start, int end){
        int mid = start + (end - start)/2;
        int pivot = arr[mid];
        swap(arr, mid, end);

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
        QuickSort test = new QuickSort();
        int[] arr = {3,1,2,5,67,2,1,32,456,1,12,3};
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        test.quickSort(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
