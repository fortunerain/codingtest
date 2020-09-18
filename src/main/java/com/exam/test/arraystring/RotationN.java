package com.exam.test.arraystring;

import static com.exam.test.util.PrintUtil.printArray;

public class RotationN {
  public static void main(String[] args) {
    // 1234
    // -> 4123
    // -> 3412
    // -> 2341
    int[] arr = {3, 8, 9, 7, 6};
    int[] solution = solution(arr, 3);
    printArray(solution);

  }

  private static int[] solution(int[] A, int K) {
    int length = A.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      int index = (i + K) % length;
      result[index] = A[i];
    }

    return result;
  }


}
