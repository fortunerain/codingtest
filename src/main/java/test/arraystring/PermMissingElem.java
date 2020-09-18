package test.arraystring;

import java.util.Arrays;

public class PermMissingElem {
  public static void main(String[] args) {
//    int arr[] = {2, 3, 1, 5};
    int arr[] = {1, 3, 6, 4, 1, 2};
    int solution = solution(arr);
    System.out.println(solution);

    int solution2 = solution2(arr);
    System.out.println(solution2);
  }

  // 요소가 [1] 일때 2
  // 요소가 [2] 일때 1
  // 요소가 [1,2] 일때 3 이 반환 되어야 한다.
  private static int solution(int[] A) {
    Arrays.sort(A);
    int result = 0;
    for (int i = 0; i < A.length; i++) {
      if (i + 1 != A[i]) {
        return i + 1;
      }
    }
    return result;
  }

  // (n * (n + 1)) / 2 를 구하여 배열의 모든 값을 뺀다.
  private static int solution2(int[] A) {
    long sum = sum(A.length + 1);
    for (int i = 0; i < A.length; i++) {
      sum -= A[i];
    }
    return (int) sum;
  }

  // int max 값을 조심하자.
  private static long sum(int i) {
    return ((long) i * (i + 1)) / 2;
  }
}
