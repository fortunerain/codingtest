package test.arraystring;

import java.util.Arrays;

public class Triangle {
  public static void main(String[] args) {
    int[] A = {10, 2, 5, 1, 8, 20};
//    int[] A = {10, 50, 5, 1};

    int triangle = isTriangle(A);
    System.out.println(triangle);
  }

  private static int isTriangle(int[] A) {
    Arrays.sort(A);
    for (int i = 0; i < A.length - 2; i++) {
      int P = A[i];
      int Q = A[i + 1];
      int R = A[i + 2];
      if (P > 0 && Q == Integer.MAX_VALUE || P + Q > R) {
        return 1;
      }
    }
    return 0;
  }
}
