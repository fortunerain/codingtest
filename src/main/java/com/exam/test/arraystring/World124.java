package com.exam.test.arraystring;

public class World124 {
  public static void main(String[] args) {
    int n = 5;

    String[] numbers = {"4", "1", "2"};
    String answer = "";

    int num = n;

    while(num > 0){
      int remainder = num % 3;
      num /= 3;

      if(remainder == 0) num--;

      answer = numbers[remainder] + answer;
    }

    System.out.println(answer);
  }
}
