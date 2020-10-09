package com.exam.test.arraystring;

import static com.exam.test.util.PrintUtil.printArray;

public class SecretMap {
  public static void main(String[] args) {
    int n = 5;
    int[] arr1 = {9, 20, 28, 18, 11};
    int[] arr2 = {30, 1, 21, 17, 28};
    String[] answer = new String[n];

    for (int i = 0; i < arr1.length; i++) {
      String result = Integer.toBinaryString(arr1[i] | arr2[i]);
      result = String.format("%" + n + "s", result);
      result = result.replaceAll("1", "#");
      result = result.replaceAll("0", " ");
      answer[i] = result;
    }

    printArray(answer);
  }
}
