package com.exam.test.arraystring;

public class ExcelSheetColumnNumber {
  public static void main(String[] args) {
    String s = "AAA";
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      // i+1의 자리 부터 순서대로 구한다.
      result = result * 26 + (s.charAt(i) - 'A' + 1);

    }
    System.out.println(result);
  }
}
