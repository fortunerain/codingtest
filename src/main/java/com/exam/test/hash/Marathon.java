package com.exam.test.hash;

import java.util.HashMap;
import java.util.Map;

public class Marathon {
  //  마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
  //  완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
  public static void main(String[] args) {
    //    ["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]
    String[] participant = {"mislav", "stanko", "mislav", "ana"};
    String[] completion = {"stanko", "ana", "mislav"};
    System.out.println(Solution(participant, completion));
  }

  private static String Solution(String[] participant, String[] completion) {
    Map<String, Integer> completeMap = new HashMap<>();
    // 참여자 초기화. 중복된 사람은 2가 된다.
    for (int i = 0; i < participant.length; i++) {
      completeMap.put(participant[i], completeMap.getOrDefault(participant[i], 0) + 1);
    }
    // 완료자 검사. 중복된 사람은 -1 해서 1이 된다. 완주한 사람은 0이 되고 완주 못한 사람은 1이다.
    for (int i = 0; i < completion.length; i++) {
      completeMap.replace(completion[i], completeMap.get(completion[i]) - 1);
    }

    // 완주 못한 1인 값 키를 추출함.
    return completeMap.entrySet().stream()
      .filter(v -> v.getValue() == 1)
      .findFirst()
      .get()
      .getKey();
  }
}
