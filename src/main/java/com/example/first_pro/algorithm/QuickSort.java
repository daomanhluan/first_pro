package com.example.first_pro.algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12,9,6,1,7,8};
        System.out.println("Before sorting: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After sorting: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotIndex = (low + high) / 2; // Choosing middle element as pivot
        int pivotValue = arr[pivotIndex];

        // Swap pivot with the last element
        swap(arr, pivotIndex, high);

        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivotValue) {
                swap(arr, i, j);
                i++;
            }
        }
        System.out.println("After swap: ");
//        for(int i1=0;i1<=arr.length-1;i1++){
//            System.out.println(arr[i1]);
//        }
        // Swap pivot back to its final position

        swap(arr, i, high);


        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}