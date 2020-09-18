package com.exam.test.sort;

import com.exam.test.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitAndSort {
  public static void main(String[] args) {
    int[] arr = {1, 5, 2, 6, 3, 7, 4};
    int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}, {1, 4, 3}};
    splitAndSort(arr, commands);


    int[] arr2 = {3, 2, 6};
    int d = 5;
    // 배열 중 d 로 나누어 떨어지는 값을 출력. 없으면 -1.
    PrintUtil.printArray(division1(arr, d));
    PrintUtil.printArray(divisionJava8(arr, d));
  }

  private static int[] splitAndSort(int[] arr, int[][] commands) {
    int[] answer = new int[commands.length];
    // 1, 5, 2, 6, 3, 7, 4
    // i = 2, j = 5, k = 3
    for (int a = 0; a < commands.length; a++) {
      int i = commands[a][0];
      int j = commands[a][1];
      int k = commands[a][2];
      Integer[] split = split(arr, i, j);
      Arrays.sort(split);
      answer[a] = split[k - 1];
    }
    return answer;
  }

  private static Integer[] split(int[] array, int x, int y) {
    List<Integer> result = new ArrayList<>();
    int j = 0;
    for (int i = 0; i < array.length; i++) {
      if (i >= x - 1 && i <= y - 1) {
        result.add(array[i]);
        j++;
      }
    }
    return result.toArray(new Integer[result.size()]);
  }

  private static int[] division1(int[] arr, int divisor) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % divisor == 0) {
        result.add(arr[i]);
      }
    }
    if (result.size() == 0) {
      result.add(-1);
    }
    int[] answer = new int[result.size()];
    int size = 0;
    for (Integer a : result) {
      answer[size++] = a;
    }
    return answer;
  }

  private static int[] divisionJava8(int[] arr, int divisor) {

    int[] array = Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
    if (array.length <= 0) {
      return new int[]{-1};
    }
    return array;
  }


}
