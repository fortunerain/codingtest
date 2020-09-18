package test.sort;

import com.exam.test.util.PrintUtil;

public class CountingSort {
  // O(n)
  // 범위가 정해져 있을때 가장 빠른 정렬알고리즘이다.
  // 예를 들어 5이하의 자연수
  // 1의 인덱스에 1의 카운트를 1씩 증가시킨다. 이런식으로 각 숫자의 인덱스에 하나씩 발견된 숫자의 카운트를 세어 배열로 만든다.
  // 해당 카운트 만큼 인덱스를 출력하면 정렬이 된 상태로 출력이 된다.

  public static void main(String[] args) {
    int n = 7;
    //    int[] arr = {1, 1, 2, 3, 4, 4, 2, 2, 1, 1, 3};
    int[] arr = {19, 10, 12, 10, 24, 25, 22};
    countingSort(arr, n);
  }

  private static void countingSort(int[] arr, int n) {
    int length = arr.length;
    int[] result = new int[100];
    // init
    for (int i = 0; i < n; i++) {
      result[i] = 0;
    }

    for (int i = 0; i < length; i++) {
      result[arr[i]]++;
    }

    PrintUtil.printArray(result);
    printArrayValue(result);
  }


  private static void printArrayValue(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i]; j++) {
        System.out.print(i + " ");
      }
    }
    System.out.println();
  }

}
