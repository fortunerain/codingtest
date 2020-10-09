package com.exam.test.arraystring;

public class _124World {
  public static void main(String[] args) {
    int n = 10;
    String[] temp = {"4", "1", "2"};
    String answer = "";
    while (n > 0) {
      int remain = n % 3;
      n /= 3;

      if (remain == 0) {
        n--;
      }
      answer = temp[remain] + answer;
    }

    System.out.println(answer);
  }

}
