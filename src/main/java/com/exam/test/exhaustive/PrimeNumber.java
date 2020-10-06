package com.exam.test.exhaustive;

import java.util.Set;
import java.util.TreeSet;

public class PrimeNumber {
  public static void main(String[] args) {
    String numbers = "7843";
    Set<Integer> sets = new TreeSet<>();
    permutation("", numbers, sets);

    int count = 0;
    for (int prime : sets) {
      if (prime == 2) {
        count++;
      }
      if (prime % 2 != 0 && isPrime(prime)) {
        count++;
      }
    }
    System.out.println(count);
  }

  // 소수 구하기
  private static boolean isPrime(int prime) {
    if (prime == 0 || prime == 1) {
      return false;
    }
    for (int i = 3; i <= (int) Math.sqrt(prime); i += 2) {
      if (prime % i == 0) {
        return false;
      }
    }
    return true;
  }

  private static void permutation(String prefix, String str, Set<Integer> sets) {
    int n = str.length();
    if (!"".equals(prefix)) {
      sets.add(Integer.valueOf(prefix));
    }
    for (int i = 0; i < n; i++) {
      permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), sets);
    }
  }
}
