package test.sort;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class MapSorting {
  public static void main(String[] args) {
    // 카운트가 높은 순으로 정렬하되, 중복된 값은 알파벳 순으로 보이도록 한다.
    String[] arr = {"strawberry", "c", "c", "banana", "banana", "apple", "orange", "pineapple", "apple", "strawberry", "orange", "orange"};

    Map<String, Integer> map = makeHashMapCountByKey(arr);
//    Map<String, Integer> map = makeTreeMapCountByKeyReverseOrder(arr);
//    System.out.println(map);

//    List<Map.Entry<String, Integer>> list_entries = sortingByCollectionSortJava7(map);
//    System.out.println(list_entries);

    sortingByCollectionSortJava8(map);


  }

  private static Map<String, Integer> makeTreeMapCountByKeyReverseOrder(String[] arr) {
    // key 순으로 역정렬 한다. 내림차순.
    Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    return map;
  }

  private static Map<String, Integer> makeHashMapCountByKey(String[] arr) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    return map;
  }

  private static List<Map.Entry<String, Integer>> sortingByCollectionSortJava7(Map<String, Integer> map) {
    // Map.Entry 리스트 작성
    List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(map.entrySet());

    // 비교함수 Comparator를 사용하여 오름차순으로 정렬
    Collections.sort(list_entries, new Comparator<Map.Entry<String, Integer>>() {
      // compare로 값을 비교
      public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
        // value가 같은게 있으면 key를 알파벳 순으로 정렬
        if (obj1.getValue() == obj2.getValue()) {
          return obj1.getKey().compareTo(obj2.getKey());
        } else {
          // 아니면 value 값으로 오름차순 정렬
          return obj2.getValue().compareTo(obj1.getValue());
        }
      }
    });
    return list_entries;
  }

  private static void sortingByCollectionSortJava8(Map<String, Integer> map) {
    // Map.Entry 리스트 작성
//    List<Map.Entry<String, Integer>> list_entries = new ArrayList<>(map.entrySet());
//    Collections.sort(list_entries, (obj1, obj2) -> obj2.getValue().compareTo(obj1.getValue()));

    // map 정렬시 중요한 부분은
    // 1. Map.Entry.comparingByValue(Collections.reverseOrder())
    // 2. LinkedHashMap::new
    Map<String, Integer> reverseValueMap = map.entrySet().stream()
      // 는 value가 같은게 있으면 key를 알파벳 순으로 정렬 안된다.
      // thenComparing 으로 해결하는데 sorted 방법이 좀 다르다.
      // .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
      .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
      .thenComparing(Map.Entry.comparingByKey()))
      .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new));

    System.out.println("reverseValueMap : " + reverseValueMap);
//    return list_entries;
  }
}
