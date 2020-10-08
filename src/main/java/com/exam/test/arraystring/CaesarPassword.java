package com.exam.test.arraystring;

public class CaesarPassword {
  public static void main(String[] args) {
    String s = "ZAB";  // ZzYy
    int n = 25;
    String answer = "";
    char[] arr = s.toCharArray();

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      char c = arr[i];
      if (c == ' ') {
        result.append(" ");
        continue;
      }
      int a = c;
      int b = a + n;
      // 소문자 a ~ z 까지 일때
      if (a >= 97 && a <= 122) {
        if (b > 122) {
          b = b - 26;
        }
      } else if (a >= 65 && a <= 90) {    // 대문자 A ~ Z 까지 일때
        if (b > 90) {
          b = b - 26;
        }
      }
      char d = (char) b;
      result.append(d);
    }
    answer = result.toString();

    System.out.println(answer);
  }
}
