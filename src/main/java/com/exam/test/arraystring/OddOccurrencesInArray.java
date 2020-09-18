package com.exam.test.arraystring;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
  public static void main(String[] args) {
    // 짝이 없는 value를 찾아라.
    int[] arr = {9, 3, 9, 3, 9, 7, 9};

    int solution = solution(arr);
    System.out.println(solution);

    // time out 실패. 개선해보자.
    int solution2 = solution2(arr);
    System.out.println(solution2);

    // for문 성공
    int solution3 = solution3(arr);
    System.out.println(solution3);

    // xor 성공
    int solution4 = solution4(arr);
    System.out.println(solution4);

  }

  public static int solution(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    return map.entrySet().stream()
      .filter(a -> a.getValue() % 2 != 0)
      .findFirst()
      .get()
      .getKey();
  }


  public static int solution2(int[] arr) {
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      int count = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j]) {
          count++;
        }
      }

      if (count % 2 != 0) {
        result = arr[i];
      }
    }
    return result;
  }

  // 100%. 스트림을 사용하는거보다 빠르다.
  public static int solution3(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() % 2 != 0) {
        return entry.getKey();
      }
    }
    return 0;
  }

  // XOR 연산. 두 수를 비교하여 같으면 참(1). 다르면 거짓(0) 반환.
  public static int solution4(int[] arr) {
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      result ^= arr[i];
    }

    return result;
  }

}
