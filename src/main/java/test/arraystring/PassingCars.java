package test.arraystring;

public class PassingCars {
  public static void main(String[] args) {
    int[] A = {0, 1, 0, 1, 1};
//    int[] A = {0};
    int solution = passingCars2(A);
    System.out.println(solution);
  }

  private static int passingCars1(int[] A) {
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        if (A[i] < A[j]) {
          count++;
          System.out.println(i + "," + j);
        }
      }
    }

    if (count == 0) {
      return 0;
    } else if (count > 1000000000) {
      return -1;
    }
    return count;
  }

  private static int passingCars2(int[] A) {
    int zeroCount = 0;
    int count = 0;

    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) zeroCount++;
      else {
        if (count > 1000000000) {
          return -1;
        }
        count += zeroCount;
      }
    }

    return count;
  }
}
