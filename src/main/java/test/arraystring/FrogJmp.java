package test.arraystring;

public class FrogJmp {
  public static void main(String[] args) {
//    int x = 10, y = 85, d = 30;
//    int x = 1, y = 5, d = 2;
    int x = 3, y = 999111321, d = 7;

//    int solution = solution(x, y, d);
//    System.out.println(solution);

    // 너무 어렵게 풀었다. 계산문제임.
    int solution2 = solution2(x, y, d);
    System.out.println(solution2);
  }

  private static int solution(int x, int y, int d) {
    return jump(x, y, d, 0);
  }

  private static int jump(int x, int y, int d, int count) {
    if (x >= y) {
      return count;
    }
    return jump(x + d, y, d, ++count);
  }

  private static int solution2(int x, int y, int d) {
    return (y-x) / d + ((y-x) % d == 0 ? 0 : 1);
  }
}
