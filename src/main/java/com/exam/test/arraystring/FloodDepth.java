package com.exam.test.arraystring;

import java.util.HashMap;
import java.util.Map;

public class FloodDepth {
  public static void main(String[] args) {
    int[] A = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
//    int[] A = {5, 8};
//    int[] A = {1,2,3};
//    int[] A = {1};
    // 자신 앞 뒤로 비교해서 자신이 사이에 있어야함.
    // FIXME: 2020-09-16 테스트 케이스 통과 안되는 부분이 많음. 수정해야함.
    int deep = deep(A);
    System.out.println(deep);

  }

  private static int deep(int[] A) {
    Map<String, Integer> map = new HashMap<>();
    int leftIndex = 0, rightIndex = 2, leftMax = 0, rightMax = 0, deep = 0;


    for (int i = 1; i <= A.length; i++) {

      // 끝까지 갔는데도 없으면 0
      if (i + 1 >= A.length) {
        if (map.size() == 0) {
          return 0;
        }
        return map.get("deep");
      }
      // 위치 선언

      int curr = A[i];
      leftMax = A[leftIndex];
      rightMax = A[rightIndex];
      // left 변경
      if (leftMax < curr) {
        leftMax = curr;
        leftIndex = i;
      }

      // right 변경
      if (rightMax < curr) {
        rightMax = curr;
        rightIndex = i;
      } else if (leftIndex == rightIndex && i + 1 <= A.length) {
        rightIndex = i + 1;
      }

      // deep 값 변경
      if (curr < A[i - 1]) {
        deep = (leftMax < rightMax) ? (leftMax - curr) : (rightMax - curr);
      }
      addDeepPoint(map, leftMax, rightMax, deep);

    }
    return map.get("deep");
  }

  private static void addDeepPoint(Map<String, Integer> map, int leftMax, int rightMax, int deep) {
//    System.out.printf("leftMax : %d, rightMax : %d, deep : %d%n", leftMax, rightMax, deep);
    int getDeep = map.getOrDefault("deep", 0);
    map.put("deep", getDeep < deep ? deep : getDeep);
  }
}
