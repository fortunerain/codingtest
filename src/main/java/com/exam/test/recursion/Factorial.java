package com.exam.test.recursion;

public class Factorial {
  public static void main(String[] args) {
    int n = 4;
    int fact = fact(n);
    System.out.println(fact);

  }

  public static int fact(int n) {
    // 종료 조건
    if (n <= 1) {
      return n;
    }

    return fact(n - 1) * n;
  }
}
