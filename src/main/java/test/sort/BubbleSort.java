package test.sort;

import com.exam.test.util.PrintUtil;

public class BubbleSort {
  // O(n^2)
  // 인접한 두 수를 비교
  public static void main(String[] args) {
    int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
    PrintUtil.printArray(arr);
    bubbleSort(arr, arr.length - 1);
    PrintUtil.printArray(arr);
  }

  private static void bubbleSort(int[] arr, int last) {
    if (last > 0) {
      for (int i = 1; i <= last; i++) {
        if (arr[i - 1] > arr[i]) {
          swap(arr, i - 1, i);
        }
      }
      bubbleSort(arr, last - 1);
    }
  }

  private static void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }


}
