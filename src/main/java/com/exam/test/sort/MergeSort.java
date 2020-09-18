package com.exam.test.sort;

import com.exam.test.util.PrintUtil;

public class MergeSort {
  // O(nlogn)
  // 계속 반씩 나누어서 최종 두 배열을 탐색하면서 작은 값을 새로운 배열에 차례대로 넣는다.
  public static void main(String[] args) {
    int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
    PrintUtil.printArray(arr);
    mergeSort(arr);
    PrintUtil.printArray(arr);
  }

  private static void mergeSort(int[] arr) {
    int[] tmp = new int[arr.length];
    mergeSort(arr, tmp, 0, arr.length - 1);
  }

  private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arr, tmp, start, mid);
      mergeSort(arr, tmp, mid + 1, end);
      merge(arr, tmp, start, mid, end);
    }
  }

  private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
    // init
    for (int i = start; i <= end; i++) {
      tmp[i] = arr[i];
    }

    int part1 = start;
    int part2 = mid + 1;
    int result_index = start;
    while (part1 <= mid && part2 <= end) {
      if (tmp[part1] <= tmp[part2]) {
        arr[result_index] = tmp[part1];
        part1++;
      } else {
        arr[result_index] = tmp[part2];
        part2++;
      }
      result_index++;
    }

    // 앞쪽 데이터가 남은게 있으면 나머지를 다 붙여준다.
    // 뒤쪽 배열의 데이터가 남아 있는 경우에는 최종 배열에 맨 뒤에 남아 있게 되므로 따로 붙여줄 필요가 없다.
    for (int i = 0; i <= mid - part1; i++) {
      arr[result_index + i] = tmp[part1 + i];
    }
  }


}
