package test.stackqueue;

import java.util.NoSuchElementException;

// add()
// remove()
// peek()
// isEmpty()
public class CustomQueue {
  public static void main(String[] args) {
    MyQueue<Integer> q = new MyQueue<>();
    q.add(1);
    q.add(2);
    q.add(3);
    q.add(4);
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.peek());
    System.out.println(q.isEmpty());
    System.out.println(q.remove());
    System.out.println(q.isEmpty());
  }
}

class MyQueue<T> {
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


