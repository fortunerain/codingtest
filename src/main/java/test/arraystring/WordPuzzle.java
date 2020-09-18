package test.arraystring;

import java.util.HashMap;
import java.util.Map;

public class WordPuzzle {
  static Map<String, Integer> map = new HashMap<>();

  // TODO: 2020-09-07 시간 초과 발생. 개선 해야함.
  public static void main(String[] args) {
    String[] strs = {"ab", "na", "n", "a", "bn"};
    String t = "nabnabn";
//    String[] strs = {"app", "ap", "p", "l", "e", "ple", "pp"};
//    String t = "apple";
    int answer = 0;


    int min = min(strs, "", t);
    System.out.println(min == Integer.MAX_VALUE - 1 ? -1 : min);
  }

  private static int min(String[] strs, String word, String target) {
    if (word.length() > target.length()) {
      return Integer.MAX_VALUE - 1;
    }
    if (word.equals(target)) {
      return 0;
    }
    if (map.containsKey(word)) {
      return map.get(word);
    }
    int result = Integer.MAX_VALUE - 1;
    for (int i = 0; i < strs.length; i++) {
      result = Math.min(result, min(strs, word + strs[i], target) + 1);
    }
    map.put(word, result);
    return result;
  }
}
