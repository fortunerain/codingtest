package com.exam.test.arraystring;

import static com.exam.test.util.PrintUtil.printArray;

public class Gcd {
  public static void main(String[] args) {
    // 최대 공약수, 최소공배수.
    // 최대 공약수는 유클리드호제법을 사용.
    // 최소 공배수는 두 자연수의 곱 = 최대 공약수 * 최소공배수 이므로
    // 두 자연수의 곱 / 최대 공약수 는 최소 공배수가 된다.
    int n = 3, m = 12;

    int multiply = n * m;
    int mod = n % m;
    while (mod > 0) {
      n = m;
      m = mod;
      mod = n % m;
    }

    int min = multiply / m;

    int[] answer = {m, min};
    printArray(answer);
  }
}
