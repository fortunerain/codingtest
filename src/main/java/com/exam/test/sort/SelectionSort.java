package com.exam.test.sort;

import com.exam.test.util.PrintUtil;

public class SelectionSort {
  // O(n^2)
  // 배열에서 첫번째 값을 기준으로 해서 제일 작은 값을 찾는다.
  // min_index 를 update 하면서 계속 제일 작은 값의 인덱스를 찾는다.
  // 첫번째 값과 min_index 에 있는 값을 교체 하면 첫번째는 정렬된다.
  // 재귀함수로 다음번째의 값보다 또 작은 값이 있는지 계속 찾게 된다.
  public static void main(String[] args) {
    int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
    PrintUtil.printArray(arr);
    selectionSort(arr);
    PrintUtil.printArray(arr);
  }

  private static void selectionSort(int[] arr) {
    selectionSort(arr, 0);
  }

  private static void selectionSort(int[] arr, int start) {
    if (start < arr.length - 1) {
      int min_index = start;
      for (int i = start; i < arr.length; i++) {
        if (arr[min_index] > arr[i]) {
          min_index = i;
        }
      }
      swap(arr, start, min_index);
      selectionSort(arr, start + 1);
    }
  }

  private static void swap(int[] arr, int start, int min_index) {
    int tmp = arr[start];
    arr[start] = arr[min_index];
    arr[min_index] = tmp;
  }


}
