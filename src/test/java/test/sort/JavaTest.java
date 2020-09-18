package test.sort;

import java.util.HashMap;
import java.util.Map;

public class JavaTest {
  public static void main(String[] args) {
    String s = "(())()";
    System.out.println(isBracket(s));
  }

  private static boolean isBracket(String s) {
    if (s.startsWith(")") || s.endsWith("(")) {
      return false;
    }
    String[] split = s.split("");
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < split.length; i++) {
      if (map.containsKey(split[i])) {
        map.put(split[i], map.get(split[i]) + 1);
        continue;
      }
      map.put(split[i], 1);
    }
    if (map.get("(") == map.get(")")) {
      return true;
    }
    return true;
  }
}
