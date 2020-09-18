package test.arraystring;

import java.math.BigInteger;
import java.util.Arrays;

public class AddTwoNumbers {
  public static void main(String[] args) {
    //    int[] arr1 = {2, 4, 3};
    //    int[] arr2 = {5, 6, 4};
    int[] arr1 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    int[] arr2 = {2, 9, 9, 9, 9, 9, 9, 9, 9, 9};
    ListNode l1 = getListNode(arr1);
    ListNode l2 = getListNode(arr2);
    // 807 로 나오는데 708 로 나오게 해야함.
    ListNode listNode = addTwoNumbers(l1, l2);
    printNode(listNode);
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    String s1 = convertNodeToString(l1);
    String s2 = convertNodeToString(l2);
    BigInteger sum = new BigInteger(s1).add(new BigInteger(s2));
    String sumStr = String.valueOf(sum);
    String[] sumArray = sumStr.split("");
    int[] arr1 = Arrays.stream(sumArray).mapToInt(Integer::parseInt).toArray();
    return getListNodeReverse(arr1);
  }

  private static String convertNodeToString(ListNode node) {
    if (node.next == null) {
      return node.val + "";
    }
    return convertNodeToString(node.next) + node.val;
  }

  private static ListNode getListNode(int[] arr1) {
    return getListNode(arr1, 0);
  }

  private static ListNode getListNode(int[] arr, int i) {
    if (i >= arr.length - 1) {
      return new ListNode(arr[i]);
    }
    ListNode node = new ListNode(arr[i++]);
    node.next = getListNode(arr, i);
    return node;
  }

  private static ListNode getListNodeReverse(int[] arr1) {
    return getListNodeReverse(arr1, arr1.length - 1);
  }

  private static ListNode getListNodeReverse(int[] arr, int i) {
    if (i <= 0) {
      return new ListNode(arr[i]);
    }
    ListNode node = new ListNode(arr[i--]);
    node.next = getListNodeReverse(arr, i);
    return node;
  }

  private static void printNode(ListNode node) {
    while (node.next != null) {
      System.out.print(node.val + "->");
      node = node.next;
    }
    System.out.println();
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}