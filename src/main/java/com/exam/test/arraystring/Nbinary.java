package com.exam.test.arraystring;

import java.util.Stack;

import static com.exam.test.util.PrintUtil.printArray;

public class Nbinary {
  public static void main(String[] args) {
//    int n = 2, t = 4, m = 2, p = 1; // 0111
    int n = 16, t = 16, m = 2, p = 1; // 02468ACE11111111
//    int n = 16, t = 16, m = 2, p = 2; // 13579BDF01234567

    String solution = solution(n, t, m, p);
    System.out.println(solution);
  }

  public static String solution(int n, int t, int m, int p) {
    String answer = "";
    StringBuilder sb = new StringBuilder();
    // 게임
    int i = 1;
    sb.append(0);
    while (sb.length() < m * t) {
      sb.append(notation(i++, n));
    }
    // 튜브가 말해야 하는 숫자
    for (int j = p - 1; j < m * (t - 1) + p; j += m) {
      answer += sb.charAt(j);
    }
    return answer;
  }

  // 진법 변환
  static String notation(int num, int n) {
    String nStr = "";
    while (num != 0) {
      if (num % n < 10)
        nStr = num % n + nStr;
      else // 10진수 이상 알파벳 저장
        nStr = String.valueOf((char) (num % n + 55)) + nStr;
      num /= n;
    }
    return nStr;
  }
}
