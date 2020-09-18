package com.exam.test.hash;

import com.exam.test.util.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BestAlbum {
  public static void main(String[] args) {
    //genres    	                          plays 	                    return
    //[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

    String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    int[] plays = {500, 600, 150, 800, 2500};

    Map<String, List<PlayInfo>> map = makeHashMap(genres, plays);
    List<PlaysSumInfo> playsSumInfos = getPlaysSumInfos(map);

    // 결과
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < playsSumInfos.size(); i++) {
      List<PlayInfo> playInfos = playsSumInfos.get(i).getPlayInfos();
      result.add(playInfos.get(0).getIndex());
      if (playInfos.size() > 1) {
        result.add(playInfos.get(1).getIndex());
      }
    }

    // int 배열로 변환
    int[] indexs = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      indexs[i] = result.get(i);
    }
    PrintUtil.printArray(indexs);
  }

  private static List<PlaysSumInfo> getPlaysSumInfos(Map<String, List<PlayInfo>> map) {
    List<PlaysSumInfo> resultList = new ArrayList<>();
    for (List<PlayInfo> playInfos : map.values()) {
      // sum
      int sum = playInfos.stream()
        .mapToInt(a -> a.getPlay())
        .sum();

      resultList.add(new PlaysSumInfo(sum, playInfos));
    }

    // 내림차순 정렬
    resultList.sort((a, b) -> b.getSum() - a.getSum());
    return resultList;
  }

  private static void printMap(Map<String, List<PlayInfo>> map) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, List<PlayInfo>> entry : map.entrySet()) {
      String key = entry.getKey();
      List<PlayInfo> playInfos = entry.getValue();
      stringBuilder.append(key).append("=");
      for (PlayInfo playInfo : playInfos) {
        stringBuilder.append(playInfo.getPlay()).append("(")
          .append(playInfo.getIndex()).append(")").append(",");
      }
    }
    System.out.println(stringBuilder.toString());
  }

  private static Map<String, List<PlayInfo>> makeHashMap(String[] genres, int[] plays) {
    Map<String, List<PlayInfo>> map = new HashMap<>();
    for (int i = 0; i < genres.length; i++) {
      map.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new PlayInfo(plays[i], i));
    }

    // 내림차순 정렬.
    for (List<PlayInfo> playInfos : map.values()) {
      playInfos.sort((a, b) -> b.getPlay() - a.getPlay());
    }
    return map;
  }

}

class PlayInfo {
  int play;
  int index;

  public PlayInfo(int play, int index) {
    this.play = play;
    this.index = index;
  }

  public int getPlay() {
    return play;
  }

  public int getIndex() {
    return index;
  }
}

class PlaysSumInfo {
  int sum;
  List<PlayInfo> playInfos;

  public PlaysSumInfo(int sum, List<PlayInfo> playInfos) {
    this.sum = sum;
    this.playInfos = playInfos;
  }

  public int getSum() {
    return sum;
  }

  public List<PlayInfo> getPlayInfos() {
    return playInfos;
  }
}
