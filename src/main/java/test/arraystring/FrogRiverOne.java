package test.arraystring;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
  public static void main(String[] args) {
    // 1 ~ X 가 전부 나타나는 인덱스는 몇번째 인가?
    // 5 이전의 값들 중에 전부 1,2,3,4,5 가 나타나므로 6
    int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
    int X = 5;
//    int[] A = {2, 2, 2, 2, 2};
//    int X = 2;

    int result = frogTime(A, X);
    System.out.println(result);

  }

  private static int frogTime(int[] A, int X) {
    Set<Integer> distance = new HashSet<>();

    for (int i = 0; i < A.length; i++) {
      if (A[i] <= X) {
        distance.add(A[i]);
        if (distance.size() == X) {
          return i;
        }
      }
    }

    return -1;
  }

}
