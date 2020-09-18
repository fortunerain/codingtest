package com.exam.test.arraystring;

import java.util.Scanner;

public class MergetwoString {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("첫번째 문자를 입력해주세요. : ");
    String first = input.nextLine();
    int firstLeng = first.length();

    System.out.println("두번째 문자를 입력해주세요. : ");
    String second = input.nextLine();
    int secondLeng = second.length();
    //		String result = "";
    int minLeng = Math.min(firstLeng, secondLeng);

    StringBuilder mergeString = new StringBuilder(firstLeng + secondLeng);

    for (int i = 0; i < minLeng; i++) {
      mergeString.append(first.charAt(i)).append(second.charAt(i));
      //			result += first.charAt(i);
      //			result += second.charAt(i);
    }
    mergeString.append(first, minLeng, firstLeng).append(second, minLeng, secondLeng);

    System.out.println(mergeString.toString());

  }

}
