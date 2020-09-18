package com.exam.test.sort;

import com.exam.test.util.PrintUtil;

public class InsertionSort {
  // O(n^2)
  public static void main(String[] args) {
    int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
    //    int[] arr = {2,3,4,5,6,7,8,9,10,1};
    PrintUtil.printArray(arr);
    insertionSort(arr);
    PrintUtil.printArray(arr);
  }

  // 기준을 두번째 값으로 했을 경우
  private static void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;

      //      printArray(arr);
    }
  }

  // 뒤에서 두번째 값으로 정렬할 경우
  private static void insertionSort2(int[] arr) {
    int n = arr.length;
    for (int i = n - 2; i >= 0; i--) {
      int key = arr[i];
      int j = i + 1;
      while (j < n && arr[j] < key) {
        arr[j - 1] = arr[j];
        j++;
      }
      arr[j - 1] = key;

    }
  }

  // 뒤에서 두번째 값으로 오른쪽에 값을 복사하면서 출력하는 형태
  private static void insertionSort3(int[] arr) {
    int n = arr.length;
    int last = arr[arr.length - 1];
    boolean isLast = false;
    for (int i = n - 2; i >= 0; i--) {
      int key = arr[i];
      // j 는 맨뒤에 있는 값.
      int j = i + 1;

      if (j >= 0 && key > last) {
        arr[j] = key;
        j--;
        PrintUtil.printArray(arr);
      } else {
        arr[j] = last;
        PrintUtil.printArray(arr);
        isLast = true;
        break;
      }
    }

    // for문을 다 돌았는데도 값을 넣지 않은 경우는 맨 앞에 last 값이 와야 하므로 넣어줌.
    if (!isLast) {
      arr[0] = last;
      PrintUtil.printArray(arr);
    }
  }


}
