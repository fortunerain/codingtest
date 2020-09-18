package test.stackqueue;

import com.exam.test.util.PrintUtil;

public class Stock {
  public static void main(String[] args) {
    // 1초 단위의 주식 가격 변동을 배열로 제공.
    // 가격이 떨어지지 않은 기간은 몇초인지.
    // 4, 3, 1, 1, 0
    int[] arr = {1, 2, 3, 2, 3};
    // 2, 1, 2, 1, 0
    int[] arr2 = {3, 4, 2, 6, 5};
    int[] result = new int[arr2.length];

    for (int i = 0; i < arr2.length; i++) {
      int time = -1;
      for (int j = i; j < arr2.length; j++) {
        if (arr2[i] > arr2[j]) {
          time++;
          break;
        }
        time++;
      }
      result[i] = time;
    }
    PrintUtil.printArray(result);
  }

}
