package com.exam.test.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
  private static final int N = 10;
  static Map<Integer, Integer> cacheMap = new HashMap<>();
  static int[] cached = new int[N + 1];

  public static void main(String[] args) {
    int fibo = fibo(10);
    System.out.println(fibo);

    // 초기값 a, b 가 주어지고, N 이 주어 졌을 때 n번째 값은?
    int fibo2 = fibo2(1, 1, 60);
    System.out.println(fibo2);
//
//    int fibo3 = fibo3(N);
//    System.out.println(fibo3);
//
//    int fibo4 = fibo4(N);
//    System.out.println(fibo4);
  }

  // 피보나치 기본
  public static int fibo(int n) {
    // 종료 조건
    if (n <= 1) {
      return n;
    }
//    System.out.println(n);
    return fibo(n - 2) + fibo(n - 1);
  }

  public static int fibo2(int a, int b, int n) {
    if (n <= 2) return a;
    int sum = 0;
    for (int i = 2; i < n; i++) {
      sum = a + b;
      a = b;
      b = sum;
    }

    return sum;
  }

  public static int fibo3(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n must not be less than zero");
    }

    cacheMap.put(0, 0);
    cacheMap.put(1, 1);
    return fiboWithCache(n);
  }

  private static int fiboWithCache(int n) {
    if (cacheMap.containsKey(n)) {
      return cacheMap.get(n);
    }
    int result = fiboWithCache(n - 2) + fiboWithCache(n - 1);
    cacheMap.put(n, result);
    return result;
  }

  public static int fibo4(int n) {
    // 종료 조건
    if (n <= 1) {
      return n;
    }

    if (cached[n] != 0) {
      return cached[n];
    }
    return fibo4(n - 2) + fibo4(n - 1);
  }
}
