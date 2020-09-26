package com.exam.test.arraystring;

import java.util.Arrays;

public class LargestTime {
  public static void main(String[] args) {
    // 시간은 0 ~ 23까지. 00 가능. 앞자리 제일 큰수는 2. 뒷자리는 3이 제일 큼.
    // 배열 1,2,3,4 -> 23:41 이 제일 큼.
//    int[] arr = {1, 2, 3, 4};
//    int[] arr = {5,5,5,5};
    int[] arr = {0,0,4,0};  //04:00

    String ans = "";
    for (int i = 0; i < 4; ++i) {
      for (int j = 0; j < 4; ++j) {
        for (int k = 0; k < 4; ++k) {
          if (i == j || i == k || j == k) continue; // avoid duplicate among i, j & k.
          String h = "" + arr[i] + arr[j], m = "" + arr[k] + arr[6 - i - j - k], t = h + ":" + m; // hour, minutes, & time.
          if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(t) < 0) ans = t; // hour < 24; minute < 60; update result.
        }
      }
    }
    System.out.println(ans);
//    return ans;
  }
}
