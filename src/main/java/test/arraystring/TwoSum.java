package test.arraystring;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  // 하나의 숫자가 주어지고 해당 배열에서 어떤 인덱스의 값을 더하면 해당 숫자가 나오는지 인덱스 값 두개를 배열로 반환하라.
  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15};
    int n = 9;
    //    int[] arr = {6, 4, 3, 8, 7, 5, 2};
    //    int n = 5;
    int[] twoSum = twoSum(arr, n);
    System.out.println(twoSum[0] + "," + twoSum[1]);
  }

  private static int[] twoSum(int[] arr, int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(n - arr[i])) {
        int[] result = new int[2];
        result[0] = map.get(n - arr[i]);
        result[1] = i;
        return result;
      }
      map.put(arr[i], i);
    }
    return null;
  }
}
