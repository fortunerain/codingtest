package com.exam.test.greedy;

public class UnionFind {
  public static void main(String[] args) {
    int[] parent = new int[11];
    for (int i = 1; i < parent.length; i++) {
      parent[i] = i;
    }

    unionParent(parent, 1, 2);
    int parent1 = findParent(parent, 1, 3);
    System.out.println(parent1);
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
