package com.exam.test.greedy;

import java.util.Arrays;

public class GymSuit {
  public static void main(String[] args) {
    int n = 5;
    int[] lost = {2, 4};
    int[] reserve = {1, 3, 5};
    int _return = 5;

//    int n = 7;
//    int[] lost = {4, 3};
//    int[] reserve = {2, 3};
//    int _return = 6;

    // reserve 중에 도난 당한 학생이 있을 경우 lost 에서도 삭제를 해줘야 한다.
    // lost 에 삭제 안하게 되면 reserve 에서 lost 의 3에 빌려줄 수 있는 경우가 발생하고, 이렇게 되면 3번 학생은 두벌이 있는 꼴.
    Arrays.sort(lost);
    Arrays.sort(reserve);
    int solution = getMemberSize(n, lost, reserve);
    System.out.println(solution);
  }

  public static int getMemberSize(int n, int[] lost, int[] reserve) {
    int result = n - lost.length;
    int temp = 0;
    int count = 0;
    // 여벌 체육복을 가진 학생이 도난 당했는지 검사
    // 도난 당했으면 목록에서 제거
    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (lost[i] == reserve[j]) {
          temp++;
          lost[i] = -1;
          reserve[j] = -1;
          break;
        }
      }
    }

    // lost 에서 빌려줄 수 있는 학생이 있는지 검사
    for (int i = 0; i < lost.length; i++) {
      for (int j = 0; j < reserve.length; j++) {
        if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
          count++;
          reserve[j] = -1;
          break;
        }
      }
    }

    return result + temp + count;
  }
}
