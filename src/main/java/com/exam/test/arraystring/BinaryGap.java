package com.exam.test.arraystring;

public class BinaryGap {
  public static void main(String[] args) {
    // 이진수의 1과 1 사이의 0의 최대 갯수를 반환
    int solution = solution(561892);
    System.out.println(solution);
  }

  public static int solution(int N) {
    int count = 0, total = 0;
    String s = Integer.toBinaryString(N);
    System.out.println(s);
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '0') {
        count++;
      } else {
        // 최대 갯수 구함
        if (count > total) {
          total = count;
        }
        count = 0;
      }
    }
    return total;
  }
}
