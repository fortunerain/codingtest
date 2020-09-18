package test.arraystring;

import java.util.Arrays;

public class AccumulatedMinValue {
  public static void main(String[] args) {
    int[] arr1 = {1, 4, 2};
    int[] arr2 = {5, 4, 4};

    System.out.println(accumulate(arr1, arr2));

  }

  private static int accumulate(int[] arr1, int[] arr2) {
    // 가장 작은수 * 가장 큰수 + 그다음 작은수 * 그다음 큰수 형태로 누적하면 된다.
    // 각 배열을 오름차순, 내림차순으로 정렬한 뒤 각각 곱해주면 누적된 곱의 값이 최소값이 된다.
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    reverse(arr2);
    int result = 0;
    for (int i = 0; i < arr1.length; i++) {
      result += arr1[i] * arr2[i];
    }
    return result;
  }

  private static void reverse(int[] arr) {
    int last = arr.length - 1;
    int middle = arr.length / 2;
    for (int i = 0; i <= middle; i++) {
      int temp = arr[i];
      arr[i] = arr[last - i];
      arr[last - i] = temp;
    }
  }
}
