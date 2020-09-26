package com.exam.test.sort;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JavaTest {
  public static void main(String[] args) {
    String s = "(())()";
    System.out.println(isBracket(s));
  }

  private static boolean isBracket(String s) {
    if (s.startsWith(")") || s.endsWith("(")) {
      return false;
    }
    String[] split = s.split("");
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < split.length; i++) {
      if (map.containsKey(split[i])) {
        map.put(split[i], map.get(split[i]) + 1);
        continue;
      }
      map.put(split[i], 1);
    }
    if (map.get("(") == map.get(")")) {
      return true;
    }
    return true;
  }

  @Test
  public void forTest() {
    int[] arr = {2, 2, 1};

    for (int i = 0; i < arr.length; i++) {
      int count = 0;
      for (int j = 1; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }

      if (count == 0) {
        System.out.println(arr[i]);
      }
    }
  }
}
