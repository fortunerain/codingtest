package test.hash;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Spy {
  public static void main(String[] args) {
    String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    Map<String, List<String>> map = getHashMapJava8(clothes);
    int result = getNumberOfCases(map);

    int result2 = getNumberOfCasesJava8(clothes);

    System.out.println(map.toString());
    System.out.println(result);
    System.out.println(result2);
  }

  private static int getNumberOfCases(Map<String, List<String>> map) {
    Collection<List<String>> values = map.values();
    int result = 1;
    for (List<String> list : values) {
      result *= list.size() + 1;
    }
    return result - 1;
  }

  private static int getNumberOfCasesJava8(String[][] clothes) {
    return Arrays.stream(clothes)
      .collect(groupingBy(s -> s[1], mapping(s -> s[0], counting())))
      .values()
      .stream()
      .collect(reducing(1L, (a, b) -> a * (b + 1))).intValue() - 1;
  }

  private static Map<String, List<String>> getHashMap(String[][] clothes) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < clothes.length; i++) {
      String key = clothes[i][1];
      String value = clothes[i][0];

      if (map.containsKey(key)) {
        List<String> list = map.get(key);
        list.add(value);
        map.put(key, list);
        continue;
      }
      List<String> list = new ArrayList<>();
      list.add(value);
      map.put(key, list);
    }
    return map;
  }

  private static Map<String, List<String>> getHashMapJava8(String[][] clothes) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < clothes.length; i++) {
      String key = clothes[i][1];
      String value = clothes[i][0];

      map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    return map;
  }
}
