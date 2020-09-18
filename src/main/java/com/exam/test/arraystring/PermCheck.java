package com.exam.test.arraystring;

import java.util.Arrays;

public class PermCheck {
  public static void main(String[] args) {
    // 순열이면 1 아니면 0
//    int[] A = {4, 1, 3, 2};
    int[] A = {1};

    int solution = solution(A);
    System.out.println(solution);

  }

  private static int solution(int[] A) {
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
      if (A[i] != i + 1) {
        return 0;
      }
    }
    return 1;
  }
}
