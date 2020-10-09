package com.exam.test.arraystring;

import java.util.Arrays;

import static com.exam.test.util.PrintUtil.printArray;

public class FailureRate {
  public static void main(String[] args) {
//    int N = 5;
//    int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; //3,4,2,1,5
//    int[] stages = {4,4,4,4,4}; //4,1,2,3
    int N = 8;
    int[] stages = {1, 2, 3, 4, 5, 6, 7}; // 7 6 5 4 3 2 1 8

    int[] answer = new int[N];
    FailRate[] temp = new FailRate[N];
    // 1번 스테이지 부터
    for (int i = 0; i < N; i++) {
      double challengeCount = 0, userCount = 0;

      // 막혀있는 스테이지
      for (int j = 0; j < stages.length; j++) {
        // 도전한 사용자 수
        if (stages[j] >= (i + 1)) {
          challengeCount++;
        }

        // 막혀있는 사용자 수
        if (stages[j] == (i + 1)) {
          userCount++;
        }
      }

      // 실패율
      double fail = userCount / challengeCount;

      // 스테이지 번호와 실패율을 string 배열에 담는다.
      if (challengeCount == 0) {
        temp[i] = new FailRate(i + 1, 0);
      } else {
        temp[i] = new FailRate(i + 1, fail);
      }
    }


    // 배열에서 실패율 내림차순으로 스테이지 번호를 정렬해야 한다.
    Arrays.sort(temp, (s1, s2) -> {
      double failRate1 = s1.failRate;
      double failRate2 = s2.failRate;
      // 실패율이 같을 때 작은 스테이지 기준 정렬
      if (failRate1 != failRate2) {
        return Double.compare(failRate2, failRate1);
      }
      return s1.stage - s2.stage;
    });

    // 정렬된 배열에서 정답인 스테이지만 추출한다.
    for (int i = 0; i < temp.length; i++) {
      answer[i] = temp[i].stage;
    }

    printArray(answer);
  }
}

class FailRate {
  int stage;
  double failRate;

  public FailRate(int stage, double failRate) {
    this.stage = stage;
    this.failRate = failRate;
  }
}