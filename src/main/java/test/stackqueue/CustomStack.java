package test.stackqueue;

import java.util.EmptyStackException;

// pop
// push
// peek
// isEmpty
public class CustomStack {
  public static void main(String[] args) {
    MyStack<Integer> myStack = new MyStack<>();
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    myStack.push(4);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.peek());
    System.out.println(myStack.pop());
    System.out.println(myStack.isEmpty());
    System.out.println(myStack.pop());
    System.out.println(myStack.isEmpty());
  }
}

class MyStack<T> {

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

