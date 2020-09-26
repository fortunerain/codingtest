package com.exam.test.tree.dfsbfs;

// balanced BST
//         0
//        / \
//      -3   9
//      /   /
//    -10  5
public class ConvertSortedArrayBinarySearchTree {
  public static void main(String[] args) {
    int[] arr = {-10, -3, 0, 5, 9};

    MyTreeNode node = makeNode(arr);

  }

  private static MyTreeNode makeNode(int[] arr) {
    return makeNode(arr, 0, arr.length - 1);
  }

  private static MyTreeNode makeNode(int[] arr, int left, int right) {
    if (left > right) {
      return null;
    }
    int middle = (left + right) / 2;
    MyTreeNode root = new MyTreeNode(arr[middle]);
    root.left = makeNode(arr, left, middle -1);
    root.right = makeNode(arr, middle + 1, right);
    return root;
  }


}

class MyTreeNode {
  int value;
  MyTreeNode left;
  MyTreeNode right;

  MyTreeNode() {}
  MyTreeNode(int value) {
    this.value = value;
  }
  MyTreeNode(int value, MyTreeNode left, MyTreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}
