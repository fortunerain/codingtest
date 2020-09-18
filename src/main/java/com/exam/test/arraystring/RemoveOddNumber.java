package com.exam.test.arraystring;

import java.util.Scanner;

public class RemoveOddNumber {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("숫자를 입력해주세요. 홀수만 제거합니다. : ");
    String number = input.nextLine();
    int len = number.length();
    String result = "";

    for (int i = 0; i < len; i++) {
      //char 타입인데 int형으로 자동형변환이 된다.
      int num = number.charAt(i);
      //명시적으로 int형으로 변환
      //			int num = Character.getNumericValue(number.charAt(i));
      System.out.println(num);
      if (num % 2 == 0) {
        result += num;
      }
    }
    System.out.println(result);
  }

}
