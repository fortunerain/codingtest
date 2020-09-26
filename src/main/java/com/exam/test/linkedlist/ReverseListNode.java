package com.exam.test.linkedlist;

public class ReverseListNode {
  public static void main(String[] args) {
    // 1 -> 2 -> 3--> 4 -> 5 -> null
    // 5 -> 4 -> 3--> 2 -> 1 -> null
    ListNode node5 = new ListNode(5, null);
    ListNode node4 = new ListNode(4, node5);
    ListNode node3 = new ListNode(3, node4);
    ListNode node2 = new ListNode(2, node3);
    ListNode head = new ListNode(1, node2);
//    while (head != null) {
//      System.out.printf(head.value + "->");
//      head = head.next;
//    }

//    ListNode reverse = reverse(head);
//    while (reverse != null) {
//      System.out.printf(reverse.value + "->");
//      reverse = reverse.next;
//    }

    ListNode reverseRecursion = reverseRecursion(head);
    while (reverseRecursion != null) {
      System.out.printf(reverseRecursion.value + "->");
      reverseRecursion = reverseRecursion.next;
    }
  }

  private static ListNode reverse(ListNode head) {
    ListNode newNode = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newNode;
      newNode = head;
      head = next;
    }
    return newNode;
  }

  private static ListNode reverseRecursion(ListNode head) {
    return reverseRecursion(head, null);
  }

  private static ListNode reverseRecursion(ListNode head, ListNode newNode) {
    if (head == null) {
      return newNode;
    }
    ListNode next = head.next;
    head.next = newNode;
    return reverseRecursion(next, head);
  }
}

class ListNode {
  int value;
  ListNode next;

  ListNode() {}

  ListNode(int value) {
    this.value = value;
  }

  ListNode(int value, ListNode next) {
    this.value = value;
    this.next = next;
  }
}
