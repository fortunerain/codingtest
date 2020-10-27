package com.exam.test.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
  public static void main(String[] args) {
    int n = 4;
    int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5},{1,3,1}, {2,3,8}};

    List<Edge> result = new ArrayList<>();
    int[] parent = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < costs.length; i++) {
      result.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
    }
    Collections.sort(result);

    int sum = 0;
    for (int i = 0; i < result.size(); i++) {
      Edge edge = result.get(i);

      if (findParent(parent, edge.a, edge.b) == 0) {
        unionParent(parent, edge.a, edge.b);
        sum += edge.distance;
      }
    }

    System.out.println(sum);

  }

  // 부모 노드를 찾음
  private static int getParent(int[] parent, int x) {
    if (parent[x] == x) {
      return x;
    }
    return parent[x] = getParent(parent, parent[x]);
  }

  // 부모를 합침.
  private static void unionParent(int[] parent, int a, int b) {
    a = getParent(parent, a);
    b = getParent(parent, b);
    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
  }

  // 같은 부모를 가지는지 확인
  private static int findParent(int[] parent, int a, int b) {
    a = getParent(parent, a);
    b = getParent(parent, b);
    if (a == b) {
      return 1;
    }
    return 0;
  }


}

class Edge implements Comparable<Edge> {
  int a;
  int b;
  int distance;

  public Edge(int a, int b, int distance) {
    this.a = a;
    this.b = b;
    this.distance = distance;
  }

  @Override
  public int compareTo(Edge o) {
    return this.distance - o.distance;
  }
}
