package com.example.first_pro.algorithm;

import java.util.List;

public class MergeSort implements Sort {
  @Override
  public List<Integer> sort(Integer[] arrs) {
    return null;
  }

  public static void merge(Integer[] arr, int l, int m, int r) {
    Integer[] temp = new Integer[r - l + 1];
    int i = l, j = m + 1, t = 0;
    while (i <= m && j <= r) {
      if (arr[i] <= arr[j]) {
        temp[t] = arr[i];
        t++;
        i++;
      } else {
        temp[t] = arr[j];
        t++;
        j++;
      }
    }

    while (i <= m) {
      temp[t] = arr[i];
      i++;
      t++;
    }
    while (j <= r) {
      temp[t] = arr[j];
      j++;
      t++;
    }
    for (int a = l, t1 = 0; a <= r; a++, t1++) {
      arr[a] = temp[t1];
    }

    System.out.println("================================after merge: ");
    for (i = l; i <= r; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void sort(Integer[] arr, int l, int r) {
    if (l >= r) return;
    int mid = (l + r) / 2;
    sort(arr, l, mid);
    sort(arr, mid + 1, r);
    merge(arr, l, mid, r);
  }

  public static int swap(Integer arr[], int l, int r) {
    int i = l, j = r;

    int tmp;
    int pivot = arr[(l + r) / 2];
    while (i <= j) {
      while (arr[i] < pivot) i++;
      while (arr[j] > pivot) j--;
      if (i <= j) {
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
        j--;
      }
    }
    ;

    return i;
  }

  public static void quickSort(Integer arr[], int l, int r) {
      if(l>=r) return ;
    int index = swap(arr, l, r);
    quickSort(arr, l, index - 1);
    quickSort(arr, index, r);
  }

  public static void main(String[] args) {
    //
    Integer[] arr = new Integer[] {12, 9, 6, 1, 7, 8};
    quickSort(arr, 0, arr.length - 1);
    System.out.println("=====================FINAL=======================");
    for (int i = 0; i <= arr.length - 1; i++) {
      System.out.println(arr[i]);
    }
  }
}
