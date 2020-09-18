package com.exam.test.arraystring;

import com.exam.test.util.PrintUtil;

import java.util.Arrays;

public class Rotation {
  // isSubString 이라는 함수를 1번만 사용해서 문자열이 회전을 한건지 파악해라.
  // ex) string -> ingstr : true
  public static void main(String[] args) {
    System.out.println(isRotation("string", "ingstr"));
    System.out.println(isRotation("string", "ngstri"));
    System.out.println(isRotation("string", "trinks"));
    System.out.println(isRotation("string", "ingsnr"));

    int[] arr = {1, 2, 3, 4, 5};
    System.out.println();
    rotation2(arr, 4);
  }

  private static boolean isRotation(String string, String string2) {
    if (string.length() != string2.length()) {
      return false;
    }
    return isSubString(string + string, string2);
  }

  private static boolean isSubString(String mergedString, String string2) {
    return mergedString.contains(string2);
  }

  private static void rotation(int[] arr, int n) {
    int size = arr.length;
    int[] sumArray = new int[size * 2];
    int[] result = new int[size];
    // copy
    for (int i = 0; i < size; i++) {
      sumArray[i] = arr[i];
    }

    for (int i = 0, j = size, k = n; i < size; i++, j++, k++) {
      // copy한 배열 value의 바로 뒤에 원본을 더한다. 1234512345
      sumArray[j] = arr[i];
      // n 번째 부터 배열길이 만큼 넣는다. 51234
      result[i] = sumArray[k];
    }

    PrintUtil.printArray(result);
  }

  private static void rotation2(int[] arr, int n) {
    int size = arr.length;
    int[] sumArray = new int[size * 2];
    // copy
    for (int i = 0; i < size; i++) {
      sumArray[i] = arr[i];
    }

    // 배열을 전부 size 인덱스 뒤에 넣음. 복사
    for (int i = 0, j = size; i < size; i++, j++) {
      sumArray[j] = arr[i];
    }
    int[] result = Arrays.copyOfRange(sumArray, n, n + arr.length);
    PrintUtil.printArray(result);
  }
}
