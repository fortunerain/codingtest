package com.exam.test.arraystring;

import java.util.Arrays;

public class MaxProductOfThree {
  public static void main(String[] args) {
    int[] A = {-5, 5, -5, 4};
    // 125??
    int solution = solution(A);
    System.out.println(solution);


  }

  private static int solution(int[] A) {
    Arrays.sort(A);
    // 1. 음수와 음수의 곱은 양수이므로 음수 2개를 곱한것과 양수1개를 곱한 케이스
    // 2. 양수만 3개를 곱한 케이스
    int caseA = A[0] * A[1] * A[A.length - 1];
    int caseB = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];

    return caseA > caseB ? caseA : caseB;
  }
}
