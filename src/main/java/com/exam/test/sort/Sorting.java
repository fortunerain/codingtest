package com.exam.test.sort;

import com.exam.test.util.PrintUtil;

import java.util.*;

import static com.exam.test.util.PrintUtil.printArray;

public class Sorting {
  public static void main(String[] args) {
    int[] arr = {2, 4, 3, 7, 6, 5};
    char[] chars = {'h','e','l','l','o'};

    //배열 오름차순 정렬
    Arrays.sort(arr);
    printArray(arr);
    // 내림차순 정렬. 기본 타입으로는 할 수 없다.
    Integer[] arr2 = {2, 4, 3, 7, 6, 5};
    Arrays.sort(arr2, Comparator.reverseOrder());
    printArray(arr2);

    // 혹은 오름 차순 정렬 후 아래와 같이 직접 구현하여 뒤집는다.
    Arrays.sort(arr);
    reverse(chars);
    printArray(arr);

    // List Sorting
    List<Integer> lists = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      lists.add(arr[i]);
    }

    lists.sort(Collections.reverseOrder());

  }

  // 단순 뒤집기
  private static void reverse(char[] s) {
    int left = 0;
    int right = s.length -1;

    while (left < right) {
      char temp = s[left];
      s[left++] = s[right];
      s[right--] = temp;
    }
  }

}

class MinimumSwap {
  public static void main(String[] args) {
    int[] arr = {7, 1, 3, 2, 4, 5, 6};
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != i + 1) {
        for (int j = i + 1; j < arr.length; j++) {
          if (arr[j] == i + 1) {
            swap(arr, i, j);
            count++;
            break;
          }
        }
      }
    }

    PrintUtil.printArray(arr);
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}

class MaxNumber {
  public static void main(String[] args) {
//    int[] numbers = {6, 10, 2};
    int[] numbers = {3, 30, 5, 34, 9};
    // PriorityQueue 사용시 아래와 같이 나올 수 있어서 사용 못함.
    // 9534303
    // 9534330 이 제일 큰수임.

    // 배열을 내림차순해서 정렬하자. 근데 숫자로 정렬하면 제일 큰수가 34가 되어 버리니까
    // string 으로 만들어서 정렬하면 앞의 숫자가 큰 값으로 정렬되니까 원하는 정렬이다.
    String[] numbersStr = new String[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      numbersStr[i] = numbers[i] + "";
    }
    // 정렬할때에는 앞의 숫자와 ab ba 중 큰거를 기준으로 정렬한다.
    // 30 3 은 303 330 중 330 이 크다.
    Arrays.sort(numbersStr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

    if (numbersStr[0].startsWith("0")) {
      System.out.println("0");
    }
    printArray(numbersStr);
    // 정렬된 숫자를 모두 더함.
    String number = "";
    for (int i = 0; i < numbersStr.length; i++) {
      number += numbersStr[i];
    }
    System.out.println(number);
  }

  // 문자열 스왑
  private static String swap(String str, int i, int j) {
    StringBuilder builder = new StringBuilder(str);
    builder.setCharAt(i, builder.charAt(j));
    builder.setCharAt(j, builder.charAt(i));
    return builder.toString();
  }

  // 문자열 단순 뒤집기
  private static void reverse(String[] input) {
    int last = input.length - 1;
    int middle = input.length / 2;
    for (int i = 0; i <= middle; i++) {
      String temp = input[i];
      input[i] = input[last - i];
      input[last - i] = temp;
    }
  }

}

class HIndex {
  public static void main(String[] args) {
    int[] citations = {3, 0, 6, 1, 5};
//    int[] citations = {0, 0, 0, 0, 0};
    // 0, 1, 3, 5, 6
    // 0 회 이상 5
    // 1회 이상 4
    // 3회 이상 3
    // 5회 이상 2
    // 6회 이상 1
    // n  >= vaule 인 경우는 3, 2, 1 중 3이 최대값.
    // 모두 0인 케이스는 0 이므로 count0 추가함.
    Arrays.sort(citations);
    System.out.println(getHIndex(citations));
  }

  private static int getHIndex(int[] citations) {
    List<Integer> result = new ArrayList<>();
    int count0 = 0;
    for (int i = 0; i < citations.length; i++) {
      int count = 0;

      if (citations[i] == 0) {
        count0++;
      }
      for (int j = 0; j < citations.length; j++) {
        if (citations[i] <= citations[j]) {
          count++;
        }

      }
      if (citations[i] >= count) {
        result.add(count);
      }
    }
    // 모두 0인 케이스
    if (count0 == citations.length) {
      return 0;
    }

    result.sort(Comparator.reverseOrder());
    return result.get(0);
  }
}