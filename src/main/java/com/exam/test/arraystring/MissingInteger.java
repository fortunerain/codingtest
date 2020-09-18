package com.exam.test.arraystring;

import java.util.Arrays;

public class MissingInteger {
  public static void main(String[] args) {
    // N 개의 정수 배열 A가 주어지면 A에서 발생하지 않는 가장 작은 양의 정수 (0보다 큼)를 반환합니다.
    int[] A = {1, 3, 6, 4, 1, 2};

    int notOccurInt = getNotOccurInt(A);
    System.out.println(notOccurInt);


  }

  private static int getNotOccurInt(int[] A) {
    Arrays.sort(A);
    int ans = 1;
    if (A[A.length - 1] <= 0) {
      return 1;
    }
    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0 && A[i] == ans) {
        ans++;
      }
    }
    return ans;
  }
}
