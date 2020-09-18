package com.exam.test.arraystring;

import java.util.Arrays;

public class SockMerchant {
  // 같은 숫자가 쌍으로 몇개가 있는지
  // (10, 10), (10, 10), (20, 20) 총 3개.
  // 오름차순 정렬하여 다음 값과 비교해서 같으면 1씩 증가시킨후 2로 나눈값을 누적시켰다.
  public static void main(String[] args) {
    int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};

    Arrays.sort(arr);
    int count = 1;
    int result = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
        count++;
      } else {
        result += count / 2;
        count = 1;
      }
    }
    System.out.println(result);
  }
}
