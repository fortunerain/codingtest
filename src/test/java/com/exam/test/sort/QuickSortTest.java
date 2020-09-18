package com.exam.test.sort;

import org.junit.Test;

public class QuickSortTest {

  @Test
  public void main() {
    int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
    printArray(arr);
    quickSort(arr);
    printArray(arr);

  }

  private void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int start, int end) {
    int part2 = sorting(arr, start, end);

    // 왼쪽
    if (start < part2 - 1) {
      quickSort(arr, start, part2 - 1);
      System.out.println("left");
    }

    if (part2 < end) {
      quickSort(arr, part2, end);
      System.out.println("right");
    }

    // 3, 9, 4, 7, 5, 0, 1, 6, 8, 2
    // sorting
    // 3, 2, 4, 1, 0, 5, 7, 6, 8, 9
    // quickSort
    // 3, 2, 4, 1, 0
    // sorting
    // 3, 2, 0, 1, 4
    // quickSort
    // 3, 2, 0, 1
    // sorting
    // 1, 0, 2, 3
    // quickSort
    // 1, 0, 2, 3
    // sorting
    // 0, 1, 2, 3
    // left
    // quickSort
    // 2, 3, 1
    // sorting
    // 2, 1, 3
  }

  private int sorting(int[] arr, int start, int end) {
    int pivot = arr[(start + end) / 2];
    while (start <= end) {
      while (arr[start] < pivot) start++;
      while (arr[end] > pivot) end--;

      if (start <= end) {
        swap(arr, start, end);
        start++;
        end--;
      }
    }
    return start;
  }

  private void swap(int[] arr, int start, int end) {
    int tmp = arr[start];
    arr[start] = arr[end];
    arr[end] = tmp;
  }

  private void printArray(int[] arr) {
    for (int data : arr) {
      System.out.print(data + " ");
    }
    System.out.println();
  }
}