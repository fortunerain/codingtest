package com.exam.test.sort;

import java.util.Arrays;

public class StringSortReverse {
  public static void main(String[] args) {
    String s = "Zbcdefg";
    char[] c = s.toCharArray();

    Arrays.sort(c);

    StringBuilder builder = new StringBuilder();
    builder.append(c);
    builder.reverse().toString();

    System.out.println(builder.toString());

  }
}
