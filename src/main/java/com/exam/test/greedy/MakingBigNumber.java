package com.exam.test.greedy;

public class MakingBigNumber {
  public static void main(String[] args) {
    String number = "1924";
    int k = 2;
    int idx = 0;
    char max;

    StringBuilder answer = new StringBuilder();
    // length 에서 -k 번째 만큼 찾아야 한다.
    // 적어도 192 중에 제일 큰거를 찾아야 마지막 4랑 조합시 제일 큰수다.
    for (int i = 0; i < number.length() - k; i++) {
      max = '0';
      // 9를 찾고, 인덱스는 2부터 시작한다. max 는 다시 초기화 됐다.
      // i 를 더해 줬으므로 j 는 2부터 끝까지 찾게 된다.
      for (int j = idx; j <= k + i; j++) {
        if (max < number.charAt(j)) {
          max = number.charAt(j);
          idx = j + 1;
        }
      }
      answer.append(max);
    }

    System.out.println(answer.toString());
  }


}
