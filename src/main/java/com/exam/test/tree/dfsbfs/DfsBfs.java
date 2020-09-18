package com.exam.test.tree.dfsbfs;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DfsBfs {

  /*
        0
       /
      1 ㅡ 3    7
      |  / | \ /
      2 ㅡ 4  5
                \
                  6 ㅡ 8
  ------------------------
  DFS(0)
  0 1 3 5 7 6 8 4 2
  BFS(0)
  0 1 2 3 4 5 6 7 8
  DFSR(0) - Recursive
  0 1 2 4 3 5 6 8 7
  ------------------------
  DFS(3)
  3 5 7 6 8 4 2 1 0
  BFS(3)
  3 1 2 4 5 0 6 7 8
  DFSR(3) - Recursive
  3 1 0 2 4 5 6 8 7
   */
  public static void main(String[] args) {
    Graph graph = new Graph(9);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.addEdge(2, 4);
    graph.addEdge(2, 3);
    graph.addEdge(3, 4);
    graph.addEdge(3, 5);
    graph.addEdge(5, 6);
    graph.addEdge(5, 7);
    graph.addEdge(6, 8);
    graph.dfs();
    //    graph.bfs();
    //    graph.dfsR();
    //    graph.dfs(3);
    //    graph.bfs(3);
    //    graph.dfsR(3);
  }
}

class Queue<T> {
  class Node<T> {
    private final T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node<T> first;
  private Node<T> last;

  public void add(T item) {
    Node<T> node = new Node<>(item);

    if (last != null) {
      last.next = node;
    }
    last = node;
    // 데이터가 업을 경우, first 도 null 이라 같은 값을 할당함.
    if (first == null) {
      first = last;
    }
  }

  public T remove() {
    // queue 가 비어있으면
    if (first == null) {
      throw new NoSuchElementException();
    }
    // 데이터를 지우기 전에 다음 데이터를 first로 만들어줘야 하니까 data를 백업한다.
    T data = first.data;
    first = first.next;

    if (first == null) {
      last = null;
    }
    return data;
  }

  public T peek() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }

}

class Stack<T> {

  class Node<T> {
    private final T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
    }
  }

  private Node<T> top;

  public T pop() {
    if (top == null) {
      throw new EmptyStackException();
    }

    // pop 하면 그 다음에 있는 노드를 top 으로 만들어줘야 함. 데이터를 백업한뒤.
    T item = top.data;
    top = top.next;
    return item;
  }

  public void push(T item) {
    Node<T> node = new Node<>(item);
    // 새로 들어갈 node 의 앞에 top 을 위치 시킴.
    node.next = top;
    // 새로 들어온 node 가 top 이 됨.
    top = node;
  }

  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }
}

class Graph {
  class Node {
    int data;
    LinkedList<Node> adjacent;
    boolean marked;

    public Node(int data) {
      this.data = data;
      this.marked = false;
      adjacent = new LinkedList<>();
    }
  }

  Node[] nodes;

  public Graph(int size) {
    nodes = new Node[size];
    for (int i = 0; i < size; i++) {
      nodes[i] = new Node(i);
    }
  }

  public void addEdge(int i1, int i2) {
    Node n1 = nodes[i1];
    Node n2 = nodes[i2];

    if (!n1.adjacent.contains(n2)) {
      n1.adjacent.add(n2);
    }
    if (!n2.adjacent.contains(n1)) {
      n2.adjacent.add(n1);
    }
  }

  public void dfs() {
    dfs(0);
  }

  public void dfs(int index) {
    Node root = nodes[index];
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    root.marked = true;
    // stack 이 빌때까지
    while (!stack.isEmpty()) {
      // stack에서 하나 pop한다.
      Node node = stack.pop();
      // pop한 node 의 인접한 자식 노드들을 stack 에 추가한다.
      for (Node n : node.adjacent) {
        if (n.marked == false) {
          n.marked = true;
          stack.push(n);
        }
      }
      // 출력
      visit(node);
    }
  }

  public void bfs() {
    bfs(0);
  }

  public void bfs(int index) {
    Node root = nodes[index];
    Queue<Node> q = new Queue<>();
    q.add(root);
    root.marked = true;
    while (!q.isEmpty()) {
      Node node = q.remove();
      for (Node n : node.adjacent) {
        if (n.marked == false) {
          n.marked = true;
          q.add(n);
        }
      }
      visit(node);
    }
  }

  private void dfsR() {
    dfsR(0);
  }

  // 특정 인덱스 부터 재귀를 호출
  public void dfsR(int index) {
    Node node = nodes[index];
    dfsR(node);
  }

  private void dfsR(Node node) {
    if (node == null) {
      return;
    }
    node.marked = true;
    visit(node);
    // 호출이 되지 않은 자식들을 재귀로 호출해준다.
    for (Node n : node.adjacent) {
      if (n.marked == false) {
        dfsR(n);
      }
    }
  }

  private void visit(Node node) {
    System.out.print(node.data + " ");
  }
}