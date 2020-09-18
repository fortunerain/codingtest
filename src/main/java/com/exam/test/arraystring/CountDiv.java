package com.exam.test.arraystring;

public class CountDiv {
  public static void main(String[] args) {
    int A = 6;
    int B = 11;
    int K = 2;

    int result = solution1(A, B, K);
    int result2 = solution2(A, B, K);
    System.out.println(result2);
  }

  private static int solution1(int A, int B, int K) {
    int count = 0;
    for (int i = A; i <= B; i++) {
      if (i % K == 0) {
        count++;
      }
    }
    System.out.println(count);
    return count;
  }

  private static int solution2(int A, int B, int K) {
    if (A % K ==0) {
      return B / K - A / K + 1;
    }
    return B / K - A / K;

  }
}
