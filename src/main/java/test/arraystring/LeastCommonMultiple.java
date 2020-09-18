package test.arraystring;

import java.util.Arrays;

public class LeastCommonMultiple {
  public static void main(String[] args) {
    // 최소공배수 구하기.
    // 168
    int[] arr = {2, 6, 8, 14};
    Arrays.sort(arr);
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
      min = lcm(min, arr[i]);
    }
    System.out.println(min);
  }

  // 최대 공약수
  // 유클리드 호제법
  public static int gcd(int a, int b) {
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  public static int lcm(int a, int b) {
    return a * b / gcd(a, b);
  }

}
