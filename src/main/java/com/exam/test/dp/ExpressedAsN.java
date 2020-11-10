package com.exam.test.dp;

public class ExpressedAsN {
  static int answer = -1;

  public static void main(String[] args) {
    int N = 5;
    int number = 12;
    solution(5, 12, 0, 0);
    System.out.println(answer);

  }
  public static void solution(int N, int number, int cnt, int prev) {
    int temp = N;
    if (cnt > 8) {
      answer = -1;
      return;
    }

    if (number == prev) {
      if (answer == -1 || answer > cnt) {
        answer = cnt;
        return;
      }
    }

    for (int i = 0; i < 8 - cnt; i++) {
      solution(N, number, cnt + i + 1, prev - temp);
      solution(N, number, cnt + i + 1, prev + temp);
      solution(N, number, cnt + i + 1, prev * temp);
      solution(N, number, cnt + i + 1, prev / temp);
      temp = increaseNumber(temp, N);
    }
  }

  public static int increaseNumber(int value, int N) {
    return value * 10 + N;
  }
}
