package com.exam.test.sort;

import com.exam.test.util.PrintUtil;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class StringSort {
  public static void main(String[] args) {
//    String[] strings = {"sun", "bed", "car"};
    String[] strings = {"abce", "abcd", "cdx"};
    int n = 2;

    String[] solution = solution(strings, n);
    PrintUtil.printArray(solution);
  }

  private static String[] solution(String[] strings, int n) {
    Arrays.sort(strings, (s1, s2) -> {
      char c1 = s1.charAt(n);
      char c2 = s2.charAt(n);
      // 특정 인덱스의 문자가 동일하면 알파벳 순으로 정렬
      if (c1 == c2) {
        return s1.compareTo(s2);
      } else {
        return c1 - c2;
      }
    });
    return strings;
  }
}
